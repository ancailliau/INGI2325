package uclouvain.ingi2325.parser;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import uclouvain.ingi2325.exception.*;

/**
 * Parser for SDL files
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public final class Parser extends DefaultHandler {

	/** Methods of ParserHandler that start an element */
	private static final Map<String, Method> startMethods =
		new HashMap<String, Method>();

	/** Methods of ParserHandler that end an element */
	private static final Map<String, Method> endMethods =
		new HashMap<String, Method>();

	/**
	 * The locator of the document being parsed.
	 */
	private Locator locator = null;

	/** Handlers */
	private final List<ParserHandler> handlers =
		new ArrayList<ParserHandler>(2);

	static {
		// Fill startMethods and endMethods
		for (Method method : ParserHandler.class.getDeclaredMethods()) {
			String name = method.getName();

			if (name.startsWith("start"))
				startMethods.put(name.substring(5), method);
			else if (name.startsWith("end"))
				endMethods.put(name.substring(3), method);
		}
	}

	/**
	 * Add a parser handler
	 * 
	 * @param handler
	 *            A parser handler
	 */
	public void addHandler(ParserHandler handler) {
		if (!handlers.contains(handler))
			handlers.add(handler);
	}

	/**
	 * Remove a parser handler
	 * 
	 * @param handler
	 *            The handler to remove
	 */
	public void removeHandler(ParserHandler handler) {
		handlers.remove(handler);
	}

	/**
	 * Parse a document and call the user's parser handler
	 * <p>
	 * You should set <code>validate</code> to <code>true</code> wherever
	 * possible. If you experience problems with the validation, make sure you
	 * regenerated the DTD using the application {@link MakeParserDTD}, then
	 * re-check your SDL file. If the problems cannot be resolved, then set this
	 * value to <code>false</code>.
	 * </p>
	 * <p>
	 * If <code>echo</code> is set to <code>true</code>, the parser will rewrite
	 * to the standard output the XML file that it reads, exactly as it
	 * understands it. This can be useful for debugging the parser.
	 * </p>
	 * 
	 * @param input
	 *            The input
	 * @param validate
	 *            True for validating the document on parsing
	 * @param echo
	 *            If true, the document is echoed to the standard output
	 * @return a boolean indicating if the parse was successful.
	 */
	public boolean parse(InputSource input, boolean validate, boolean echo) {
		if (echo)
			handlers.add(0, EchoParserHandler.makeHandler());

		try {
			// Use the default parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(validate);

			// We are the SAX event handler
			DefaultHandler saxHandler = this;

			// Parse the input
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(input, saxHandler);
		} catch (SAXParseException e) {
			// Report the exception (with the line number) and return false
			System.err.print("ERROR : " + e.getMessage());
			System.err.println((e.getLineNumber() > 0 ? (" (line "
					+ e.getLineNumber() + ")") : ""));
			return false;
		} catch (Exception e) {
			// Report the exception and return false
			System.err.println("ERROR : " + e.getMessage());
			return false;
		}

		// The parsing has succeeded
		return true;
	}

	/**
	 * SAX2 event handler for handling the start of an element
	 * <p>
	 * Receive notification of the start of an element.
	 * </p>
	 * <p>
	 * You should not call this method, it is called by the SAX2 parser.
	 * </p>
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			org.xml.sax.Attributes attributes) throws SAXException {
		try {
			// Find the appropriate method
			Method method = findMethod(startMethods, qName);

			// Get attribute names
			Attributes annotation = method.getAnnotation(Attributes.class);
			String[] attrNames;
			if (annotation == null)
				attrNames = new String[0];
			else
				attrNames = annotation.value();

			// Get attribute types
			Class<?>[] attrTypes = method.getParameterTypes();
			assert attrNames.length == attrTypes.length;

			// Fetch which parameters are optional
			Optional[] optionals = new Optional[attrNames.length];
			Annotation[][] paramAnnotations = method.getParameterAnnotations();
			for (int i = 0; i < attrNames.length; i++) {
				for (Annotation paramAnnotation : paramAnnotations[i])
					if (paramAnnotation instanceof Optional)
						optionals[i] = (Optional) paramAnnotation;
			}

			// Parse the parameters
			Object[] parameters = new Object[attrNames.length];
			for (int i = 0; i < attrNames.length; i++) {
				String name = attrNames[i];
				Class<?> type = attrTypes[i];
				Optional optional = optionals[i];

				String value = attributes.getValue(name);

				if (value != null) {
					// Explicit value
					parameters[i] = ParserUtils.parseAttribute(value, type);
				} else if (optional == null) {
					// Missing non-optional attribute
					throw new ParseException(String.format(
							"Element \"%s\" requires attribute \"%s\".",
							qName, name));
				} else if (!optional.value().equals(Optional.NULL_STRING)) {
					// Non-null default value
					parameters[i] = ParserUtils.parseAttribute(
							optional.value(), type);
				} else {
					// Implied value - parameters[i] is already null
				}
			}

			// Invoke the method
			invokeHandlerMethod(method, parameters);
		} catch (Exception exception) {
			// Catch any exception and turn it into a SAXParseException
			exception.printStackTrace();
			throw new SAXParseException(null, locator, exception);
		}
	}

	/**
	 * SAX2 event handler for handling the end of an element
	 * <p>
	 * Receive notification of the end of an element.
	 * </p>
	 * <p>
	 * You should not call this method, it is called by the SAX2 parser.
	 * </p>
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		try {
			// Find the appropriate method
			Method method = findMethod(endMethods, qName);

			// Invoke the method
			invokeHandlerMethod(method, null);
		} catch (Exception exception) {
			// Catch any exception and turn it into a SAXParseException
			throw new SAXParseException(null, locator, exception);
		}
	}

	/**
	 * Find a method
	 * 
	 * @param methods
	 *            Map of methods
	 * @param name
	 *            Name in the map
	 * @return The method
	 * @throws ParseException
	 *             The method was not found
	 */
	private Method findMethod(Map<String, Method> methods, String name)
			throws ParseException {
		Method method = methods.get(name);

		if (method == null)
			throw new ParseException(String.format(
					"Unknown element \"%s\".", name));

		return method;
	}

	/**
	 * Invoke a method on all handlers
	 * 
	 * @param method
	 *            Method to invoke
	 * @param parameters
	 *            Parameters of the method
	 * @throws Throwable
	 *             The
	 */
	private void invokeHandlerMethod(Method method, Object[] parameters)
			throws Exception {
		try {
			for (ParserHandler handler : handlers)
				method.invoke(handler, parameters);
		} catch (InvocationTargetException error) {
			if (error.getCause() instanceof Exception)
				throw (Exception) error.getCause();
			else if (error.getCause() instanceof Error)
				throw (Error) error.getCause();
			else
				throw error;
		}
	}

	/**
	 * SAX2 event handler for setting the document locator
	 * <p>
	 * Receive an object for locating the origin of SAX document events.
	 * </p>
	 * <p>
	 * You should not call this method, it is called by the SAX2 parser.
	 * </p>
	 */
	@Override
	public void setDocumentLocator(Locator locator) {
		this.locator = locator;
	}

	/**
	 * SAX2 event handler for warning handling
	 * <p>
	 * Receive notification of a parser warning.
	 * </p>
	 * <p>
	 * You should not call this method, it is called by the SAX2 parser.
	 * </p>
	 */
	@Override
	public void warning(SAXParseException e) {
		// Report the warning and continue
		System.err.println("SDLParser.warning() : WARNING : " + e);
	}

	/**
	 * SAX2 event handler for recoverable error handling
	 * <p>
	 * Receive notification of a recoverable parser error.
	 * </p>
	 * <p>
	 * You should not call this method, it is called by the SAX2 parser.
	 * </p>
	 */
	@Override
	public void error(SAXParseException e) throws SAXParseException {
		// Abort the parse anyway
		throw e;
	}

	/**
	 * SAX2 event handler for fatal error handling
	 * <p>
	 * Report a fatal XML parsing error.
	 * </p>
	 * <p>
	 * You should not call this method, it is called by the SAX2 parser.
	 * </p>
	 */
	@Override
	public void fatalError(SAXParseException e) throws SAXParseException {
		// Abort the parse
		throw e;
	}
}

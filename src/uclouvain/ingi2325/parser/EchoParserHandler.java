package uclouvain.ingi2325.parser;

import java.lang.reflect.*;

public class EchoParserHandler {

	/**
	 * Make an echo handler
	 * 
	 * @return The echo handler created
	 */
	public static ParserHandler makeHandler() {
		return (ParserHandler) Proxy.newProxyInstance(
				EchoParserHandler.class.getClassLoader(),
				new Class<?>[] { ParserHandler.class },
				new EchoInvocationHandler());
	}

	/**
	 * Invocation handler for the echo proxy
	 * 
	 * @author sjrd
	 */
	private static class EchoInvocationHandler implements InvocationHandler {

		/** Current indentation */
		private String indent = "";

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			String name = method.getName();

			if (name.startsWith("start"))
				invokeStart(name.substring(5), method, args);
			else if (name.startsWith("end"))
				invokeEnd(name.substring(3), method, args);
			else
				assert false;

			return null;
		}

		/**
		 * Invoke a start method
		 * 
		 * @param elementName
		 *            Name of the element
		 * @param method
		 *            Method
		 * @param args
		 *            Arguments
		 */
		private void invokeStart(String elementName, Method method,
				Object[] args) {
			System.out.print(indent + "<" + elementName);

			if (args != null && args.length > 0) {
				Attributes parameters = method.getAnnotation(Attributes.class);
				String[] attrNames = parameters.value();

				for (int i = 0; i < args.length; i++) {
					if (args[i] != null) {
						System.out.print(String.format(" %s=\"%s\"",
								attrNames[i],
								ParserUtils.formatAttribute(args[i])));
					}
				}
			}

			System.out.println(">");

			indent = indent + "   ";
		}

		/**
		 * Invoke an end method
		 * 
		 * @param elementName
		 *            Name of the element
		 * @param method
		 *            Method
		 * @param args
		 *            Arguments
		 */
		private void invokeEnd(String elementName, Method method,
				Object[] args) {
			indent = indent.substring(0, indent.length() - 3);

			System.out.println(indent + "</" + elementName + ">");
		}
	}
}

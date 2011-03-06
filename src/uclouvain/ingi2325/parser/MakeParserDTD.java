package uclouvain.ingi2325.parser;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * DTD maker for a parser
 * 
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public class MakeParserDTD {

	/** Output stream */
	private final PrintStream output;

	/**
	 * Make the DTD for the parser and output it on the standard output
	 * 
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String[] args) {
		new MakeParserDTD(System.out).produceDTD();
	}

	/**
	 * Create a maker of DTD
	 * 
	 * @param output
	 *            Output stream
	 */
	public MakeParserDTD(PrintStream output) {
		this.output = output;
	}

	/**
	 * Produce the DTD
	 */
	public void produceDTD() {
		Class<ParserHandler> clazz = ParserHandler.class;

		for (Method method : clazz.getMethods()) {
			String name = method.getName();

			if (name.startsWith("start"))
				produceElement(name.substring(5, name.length()), method);
		}
	}

	/**
	 * Produce the DTD chunk for one element
	 * 
	 * @param name
	 *            Name of the element
	 * @param method
	 *            Method representing this element
	 */
	private void produceElement(String name, Method method) {
		produceContains(name, method);
		produceAttributeList(name, method);
		output.println();
	}

	/**
	 * Produce the contains part for an element
	 * 
	 * @param name
	 *            Name of the element
	 * @param method
	 *            Method representing this element
	 */
	private void produceContains(String name, Method method) {
		Contains annotation = method.getAnnotation(Contains.class);
		String containsDesc;

		if (annotation == null) {
			containsDesc = "EMPTY";
		} else {
			String[] contains = annotation.value();
			containsDesc = contains[0];

			if (contains.length > 1) {
				String separation = annotation.many().separation;
				for (int i = 1; i < contains.length; i++)
					containsDesc += separation + contains[i];
				containsDesc = "(" + containsDesc + ")";
			}

			String manyIndicator = annotation.many().indicator;
			if (!manyIndicator.isEmpty())
				containsDesc = "(" + containsDesc + manyIndicator + ")";
		}

		output.println(String.format("<!ELEMENT %s %s>", name, containsDesc));
	}

	/**
	 * Produce the attribute list part for an element
	 * 
	 * @param name
	 *            Name of the element
	 * @param method
	 *            Method representing this element
	 */
	private void produceAttributeList(String name, Method method) {
		Attributes annotation = method.getAnnotation(Attributes.class);

		if (annotation == null) {
			output.println(String.format("<!ATTLIST %s>", name));
		} else {
			output.println(String.format("<!ATTLIST %s", name));

			String[] attributes = annotation.value();
			Annotation[][] paramAnnotations = method.getParameterAnnotations();

			for (int i = 0; i < attributes.length; i++) {
				String attribute = attributes[i];
				Annotation[] annotations = paramAnnotations[i];

				String type = attribute.equals("name") ? "ID" : "CDATA";
				String optionality = "#REQUIRED";

				for (Annotation annot : annotations) {
					if (annot instanceof IDRef)
						type = "IDREF";
					else if (annot instanceof Optional) {
						Optional optional = (Optional) annot;
						if (optional.value().equals(Optional.NULL_STRING))
							optionality = "#IMPLIED";
						else
							optionality = "\"" + optional.value() + "\"";
					}
				}

				output.print("\t" + attribute);

				for (int j = 0; j < 7 - (attribute.length() / 4); j++)
					output.print("\t");

				output.print(type);

				for (int j = 0; j < 4 - (type.length() / 4); j++)
					output.print("\t");

				output.println(optionality);
			}

			output.println(">");
		}
	}
}

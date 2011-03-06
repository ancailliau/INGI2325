package uclouvain.ingi2325.parser;

import java.lang.annotation.*;

/**
 * Annotation for elements containing other elements
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Contains {

	/** Default value */
	String[] value();

	/** How many times the whole set of elements */
	ManySpec many() default ManySpec.Single;

	/**
	 * Specification for many elements
	 * @author sjrd
	 */
	public static enum ManySpec {
		Single(",", ""), ZeroToMany("|", "*"), OneToMany("|", "+");

		public final String separation;

		public final String indicator;

		ManySpec(String separation, String indicator) {
			this.separation = separation;
			this.indicator = indicator;
		}
	}
}

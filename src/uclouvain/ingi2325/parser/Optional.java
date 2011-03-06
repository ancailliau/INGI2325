package uclouvain.ingi2325.parser;

import java.lang.annotation.*;

/**
 * Annotation for optional attributes
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface Optional {

	/** Null string */
	public static final String NULL_STRING = "<null>";

	/** Default value */
	String value() default NULL_STRING;
}

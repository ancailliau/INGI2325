package uclouvain.ingi2325.parser;

import java.lang.annotation.*;

/**
 * Parameter names of a method
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Attributes {

	String[] value();
}

package uclouvain.ingi2325.parser;

import java.lang.annotation.*;

/**
 * Annotation for attributes that are references to an ID
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface IDRef {
}

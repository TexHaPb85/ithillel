package edu.ithillel.reflection.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention(RetentionPolicy.SOURCE)// present only on code level, after code compilation annotation will be removed
//@Retention(RetentionPolicy.CLASS)// during compilation annotation will be added to bytecode but in runtime not present
@Retention(RetentionPolicy.RUNTIME)//present at runtime
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface Hillel {
    String annotationParam1() default "paramOne";
    String annotationParam2();

}

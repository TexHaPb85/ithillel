package edu.ithillel.reflection.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import edu.ithillel._common.person.PersonWorker;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Repeatable(PersonWorker.class)
public @interface Clon {
}

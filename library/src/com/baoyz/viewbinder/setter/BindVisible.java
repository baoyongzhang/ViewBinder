package com.baoyz.viewbinder.setter;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author baoyz
 * @date 2014-7-4
 *
 */
@Retention(RUNTIME)
@Target({METHOD, FIELD})
public @interface BindVisible {
	int value();
	String setter() default "setVisibility";
}

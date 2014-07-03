package com.baoyz.viewbinder.setter;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author baoyz
 * 
 * @createby 2014-7-3
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface BindChecked {
	int value();
}

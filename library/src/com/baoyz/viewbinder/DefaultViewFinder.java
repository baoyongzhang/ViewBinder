package com.baoyz.viewbinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:03:36
 */
public class DefaultViewFinder implements ViewFinder {

	@Override
	public View findView(Field field, View view) {
		field.setAccessible(true);
		Annotation[] annotations = field.getAnnotations();
		for (Annotation a : annotations) {
			if (a instanceof BindView) {
				return view.findViewById(((BindView) a).value());
			}
		}
		// TODO default
		return null;
	}

}

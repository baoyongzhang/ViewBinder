package com.baoyz.viewbinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.view.View;

/**
 * 
 * @author baoyz
 * 
 * @createby 2014-6-24
 */
public class DefaultViewFinder extends ViewFinder {

	@Override
	public BindInfo findView(AccessibleObject obj, View view) {

		obj.setAccessible(true);

		BindInfo info = null;

		if (obj.isAnnotationPresent(BindView.class)) {
			BindView bindView = (BindView) obj
					.getAnnotation(BindView.class);
			View findView = view.findViewById(bindView.value());
			if (findView != null) {
				info = new BindInfo(bindView, findView);
			}
		} else {
			info = findSetter(obj, view);
		}

		if (info != null) {
			if (obj instanceof Method) {
				info.setMethod((Method) obj);
			} else {
				info.setField((Field) obj);
			}
		} else {
			// TODO default
		}

		return info;
	}

	private BindInfo findSetter(AccessibleObject obj, View view) {
		for (Class<? extends Annotation> clazz : ViewFinder.SETTERS) {
			if (obj.isAnnotationPresent(clazz)) {
				try {
					Annotation an = obj.getAnnotation(clazz);
					BindInfo info = new BindInfo(an, view);
					View findView = view.findViewById((int) clazz.getMethod(
							"value").invoke(an));
					if (findView == null) {
						break;
					}
					info.setView(findView);
					info.setSetter((String) clazz.getMethod("setter")
							.invoke(an));
					return info; 
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}

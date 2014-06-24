package com.baoyz.viewbinder;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:04:01
 * @param <T>
 */
public abstract class ViewBinder<T> {

	private static ViewBinder instance;

	public abstract void setViewValue(View view, Field field, T bean);

	public abstract void bindView(View view, T bean);

	public static <T> ViewBinder<T> getDefault(Context context) {
		if (instance == null) {
			synchronized (ViewBinder.class) {
				if (instance == null) {
					instance = new DefaultViewBinder<T>(context);
				}
			}
		}
		return instance;
	}

	public static void bind(View view, Object bean) {
		ViewBinder.getDefault(view.getContext()).bindView(view, bean);
	}

	public static void bind(Activity act, Object bean) {
		bind(act.getWindow().getDecorView(), bean);
	}

	public static void bind(Fragment f, Object bean) {
		bind(f.getView(), bean);
	}
}

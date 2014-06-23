package com.baoyz.viewbinder;

import java.lang.reflect.Field;

import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014��6��24������2:04:01
 * @param <T>
 */
public interface ViewBinder<T> {

	public void setViewValue(View view, Field field, T bean);
}

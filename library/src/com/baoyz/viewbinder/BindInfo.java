package com.baoyz.viewbinder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014-7-4
 * 
 */
public class BindInfo {

	private View view;
	private boolean isField;
	private Method method;
	private Field field;
	private boolean isSetter;
	private String setter;

	public BindInfo(View view, boolean isSetter) {
		super();
		this.view = view;
		this.isSetter = isSetter;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
		isField = true;
	}

	public boolean isField() {
		return isField;
	}

	public void setField(boolean isField) {
		this.isField = isField;
	}

	public String getSetter() {
		return setter;
	}

	public void setSetter(String setter) {
		this.setter = setter;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
		isField = false;
	}

	public boolean isSetter() {
		return isSetter;
	}

	public void setSetter(boolean isSetter) {
		this.isSetter = isSetter;
	}

	public Object getBindValue(Object bean) {
		try {
			return isField ? field.get(bean) : method.invoke(bean);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Class<?> getBindParamType() {
		return isField ? field.getType() : method.getReturnType();
	}

	@Override
	public String toString() {
		return "BindInfo [view=" + view + ", isField=" + isField + ", method="
				+ method + ", field=" + field + ", isSetter=" + isSetter
				+ ", setter=" + setter + "]";
	}

}

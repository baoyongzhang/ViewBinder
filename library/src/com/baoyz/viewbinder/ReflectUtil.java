package com.baoyz.viewbinder;

import java.lang.reflect.Method;

public class ReflectUtil {

	public static Method findMethod(Class<?> clazz, String methodName,
			Class<? extends Object> param) {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				if (parameterTypes != null && parameterTypes.length == 1
						&& parameterTypes[0].isAssignableFrom(param)) {
					return method;
				}
			}
		}
		return null;
	}
}

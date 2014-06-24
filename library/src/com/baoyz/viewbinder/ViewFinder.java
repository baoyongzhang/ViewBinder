package com.baoyz.viewbinder;

import java.lang.reflect.Field;

import android.content.Context;
import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:04:09
 */
public abstract class ViewFinder {

	private static ViewFinder instance;

	public abstract View findView(Field field, View view);

	public static ViewFinder getDefault(Context context) {
		if (instance == null) {
			synchronized (ViewFinder.class) {
				if (instance == null) {
					instance = new DefaultViewFinder();
				}
			}
		}
		return instance;
	}
}

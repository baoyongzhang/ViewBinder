package com.baoyz.viewbinder;

import java.lang.reflect.Field;

import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:04:09
 */
public interface ViewFinder {

	public View findView(Field field, View view);
}

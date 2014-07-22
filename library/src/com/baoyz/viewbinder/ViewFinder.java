package com.baoyz.viewbinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.List;

import com.baoyz.viewbinder.setter.BindBackgroundColor;
import com.baoyz.viewbinder.setter.BindBackgroundDrawable;
import com.baoyz.viewbinder.setter.BindBackgroundResource;
import com.baoyz.viewbinder.setter.BindChecked;
import com.baoyz.viewbinder.setter.BindImageBitmap;
import com.baoyz.viewbinder.setter.BindImageDrawable;
import com.baoyz.viewbinder.setter.BindImageResource;
import com.baoyz.viewbinder.setter.BindSetter;
import com.baoyz.viewbinder.setter.BindSelected;
import com.baoyz.viewbinder.setter.BindText;
import com.baoyz.viewbinder.setter.BindVisible;

import android.content.Context;
import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014-6-24
 *
 */
public abstract class ViewFinder {
	
	public static final List<Class<? extends Annotation>> SETTERS = new ArrayList<Class<? extends Annotation>>();
	
	static{
		SETTERS.add(BindBackgroundColor.class);
		SETTERS.add(BindBackgroundDrawable.class);
		SETTERS.add(BindBackgroundResource.class);
		SETTERS.add(BindChecked.class);
		SETTERS.add(BindSelected.class);
		SETTERS.add(BindSetter.class);
		SETTERS.add(BindText.class);
		SETTERS.add(BindVisible.class);
		SETTERS.add(BindImageBitmap.class);
		SETTERS.add(BindImageDrawable.class);
		SETTERS.add(BindImageResource.class);
	}

	private static ViewFinder instance;

	public abstract BindInfo findView(AccessibleObject obj, View view);

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

package com.baoyz.viewbinder;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.baoyz.viewbinder.handler.ImageHandler;
import com.baoyz.viewbinder.handler.PicassoImageHandler;

/**
 * 
 * @author baoyz
 * @date 2014-6-24
 * 
 * @param <T>
 */
public abstract class ViewBinder<T> {

	private static ViewBinder instance;
	private static ImageHandler imageHandler;

	static {
		// default setting
		imageHandler = new PicassoImageHandler();
	}

	public abstract void setViewValue(BindInfo info, T bean);

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

	public static void setImageHandler(ImageHandler handler) {
		imageHandler = handler;
	}

	public static ImageHandler getImageHandler() {
		return imageHandler;
	}
}

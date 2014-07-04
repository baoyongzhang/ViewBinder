package com.baoyz.viewbinder.adapter;


import android.content.Context;
import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:04:24
 * @param <T>
 */
public abstract class AdapterHandler<T> {

	private static AdapterHandler instance;

	public abstract void createViewHolder(T bean, View view);

	public abstract void bindView(View view, T bean);

	public static <T> AdapterHandler<T> getDefault(Context context) {
		if (instance == null) {
			synchronized (AdapterHandler.class) {
				if (instance == null) {
					instance = new DefaultAdapterHandler<T>(context);
				}
			}
		}
		return instance;
	}
}

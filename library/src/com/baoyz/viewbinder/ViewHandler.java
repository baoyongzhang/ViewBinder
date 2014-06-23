package com.baoyz.viewbinder;

import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:04:24
 * @param <T>
 */
public interface ViewHandler<T> {

	public void createViewHolder(T bean, View view);

	public void bindView(View view, T bean);
}

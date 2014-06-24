package com.baoyz.viewbinder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.view.View;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:03:09
 * @param <T>
 */
public class DefaultAdapterHandler<T> extends AdapterHandler<T> {

	private Map<View, Map<String, View>> mHolderMap;
	private ViewFinder mViewFinder;
	private ViewBinder<T> mViewBinder;

	public DefaultAdapterHandler(Context context) {
		mHolderMap = new HashMap<View, Map<String, View>>();

		mViewFinder = ViewFinder.getDefault(context);
		mViewBinder = ViewBinder.getDefault(context);
	}

	@Override
	public void createViewHolder(T bean, View view) {
		if (bean == null || view == null) {
			return;
		}
		HashMap<String, View> viewHolder = new HashMap<String, View>();
		mHolderMap.put(view, viewHolder);

		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			viewHolder.put(field.getName(), mViewFinder.findView(field, view));
		}

	}

	@Override
	public void bindView(View view, T bean) {
		if (view == null || bean == null) {
			return;
		}
		Map<String, View> holder = mHolderMap.get(view);
		if (holder == null) {
			return;
		}
		for (Map.Entry<String, View> entry : holder.entrySet()) {
			try {
				Field field = bean.getClass().getDeclaredField(entry.getKey());
				mViewBinder.setViewValue(entry.getValue(), field, bean);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}

	}

}

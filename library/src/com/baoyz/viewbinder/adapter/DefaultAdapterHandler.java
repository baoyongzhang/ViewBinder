package com.baoyz.viewbinder.adapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;

import com.baoyz.viewbinder.BindInfo;
import com.baoyz.viewbinder.ViewBinder;
import com.baoyz.viewbinder.ViewFinder;

/**
 * 
 * @author baoyz
 * @date 2014年6月24日上午2:03:09
 * @param <T>
 */
public class DefaultAdapterHandler<T> extends AdapterHandler<T> {

	private Map<View, List<BindInfo>> mHolderMap;
	private ViewFinder mViewFinder;
	private ViewBinder<T> mViewBinder;

	public DefaultAdapterHandler(Context context) {
		mHolderMap = new HashMap<View, List<BindInfo>>();

		mViewFinder = ViewFinder.getDefault(context);
		mViewBinder = ViewBinder.getDefault(context);
	}

	@Override
	public void createViewHolder(T bean, View view) {
		if (bean == null || view == null) {
			return;
		}
		List<BindInfo> viewHolder = new ArrayList<BindInfo>();
		mHolderMap.put(view, viewHolder);

		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			BindInfo info = mViewFinder.findView(field, view);
			if (info != null) {
				viewHolder.add(info);
			}
		}

		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			BindInfo info = mViewFinder.findView(method, view);
			if (info != null) {
				viewHolder.add(info);
			}
		}

	}

	@Override
	public void bindView(View view, T bean) {
		if (view == null || bean == null) {
			return;
		}
		List<BindInfo> holder = mHolderMap.get(view);
		if (holder == null) {
			return;
		}
		for (BindInfo info : holder) {
			mViewBinder.setViewValue(info, bean);
		}

	}

	@Override
	public View getViewFromHolder(View view, int viewId) {
		List<BindInfo> list = mHolderMap.get(view);
		for (BindInfo info : list) {
			if (info.getView().getId() == viewId) {
				return info.getView();
			}
		}
		return null;
	}

}

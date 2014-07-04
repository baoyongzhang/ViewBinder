package com.baoyz.viewbinder.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 基本列表适配器
 * 
 * @author Baoyz
 * 
 * @date 2014-6-5 下午12:28:16
 */
public class SimpleListAdapter<T> extends BaseAdapter {

	private List<T> mList;
	private Context mContext;
	private AdapterHandler<T> mAdapterHandler;
	private int mViewId;

	public SimpleListAdapter(Context context, List<T> list) {
		this(context, list, 0);
	}

	public SimpleListAdapter(Context context, List<T> list, int viewId) {
		mList = list;
		mContext = context;
		mAdapterHandler = AdapterHandler.getDefault(context);
		mViewId = viewId;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		T bean = getItem(position);
		if (view == null) {
			view = View.inflate(mContext, getViewId(), null);
			mAdapterHandler.createViewHolder(bean, view);
		}
		mAdapterHandler.bindView(view, bean);
		return view;
	}

	protected int getViewId() {
		return mViewId;
	};

}

package com.baoyz.viewbinder;

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
public abstract class BaseListAdapter<T> extends BaseAdapter {

	private List<T> mList;
	private Context mContext;
	private ViewHandler<T> mViewHandler;

	public BaseListAdapter(Context context, List<T> list) {
		mList = list;
		mContext = context;
		mViewHandler = new DefaultViewHandler<T>(mContext);
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
			mViewHandler.createViewHolder(bean, view);
		}
		mViewHandler.bindView(view, bean);
		return view;
	}

	protected abstract int getViewId();

}

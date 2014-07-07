package com.baoyz.viewbinder.adapter;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * 
 * @author Baoyz
 * 
 * @date 2014-6-9 ÏÂÎç6:37:32
 */
public class SimpleCursorAdapter<T extends ICursorBean> extends
		CursorAdapter {

	private Context mContext;
	private Class<T> mBeanClass;
	private T mBean;
	private AdapterHandler<T> mAdapterHandler;
	private int mViewId;

	public SimpleCursorAdapter(Context context, Class<T> beanClass) {
		this(context, null, beanClass, 0);
	}

	public SimpleCursorAdapter(Context context, Class<T> beanClass, int viewId) {
		this(context, null, beanClass, viewId);
	}

	public SimpleCursorAdapter(Context context, Cursor c, Class<T> beanClass, int viewId) {
		super(context, c, true);
		mContext = context;
		mBeanClass = beanClass;
		mViewId = viewId;
		try {
			mBean = mBeanClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		mAdapterHandler = AdapterHandler.getDefault(context);
	}
	
	public T getItemModel(int position){
		T bean = null;
		try {
			bean = mBeanClass.newInstance();
			bean.loadFromCursor((Cursor) getItem(position));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View view = View.inflate(mContext, getViewId(), null);
		mAdapterHandler.createViewHolder(mBean, view);
		return view;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		try {
			T bean = mBeanClass.newInstance();
			bean.loadFromCursor(cursor);
			mAdapterHandler.bindView(view, bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected int getViewId(){
		return mViewId;
	}

}

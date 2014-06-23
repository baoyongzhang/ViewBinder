package com.baoyz.viewbinder;

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
 * @date 2014-6-9 ����6:37:32
 */
public abstract class BaseCursorAdapter<T extends ICursorBean> extends
		CursorAdapter {

	private Context mContext;
	private Class<T> mBeanClass;
	private T mBean;
	private ViewHandler<T> mViewHandler;

	public BaseCursorAdapter(Context context, Class<T> beanClass) {
		this(context, null, beanClass);
	}

	public BaseCursorAdapter(Context context, Cursor c, Class<T> beanClass) {
		super(context, c, true);
		mContext = context;
		mBeanClass = beanClass;
		try {
			mBean = mBeanClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		mViewHandler = new DefaultViewHandler<T>(mContext);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View view = View.inflate(mContext, getViewId(), null);
		mViewHandler.createViewHolder(mBean, view);
		return view;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		try {
			T bean = mBeanClass.newInstance();
			bean.loadFromCursor(cursor);
			mViewHandler.bindView(view, bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract int getViewId();

}

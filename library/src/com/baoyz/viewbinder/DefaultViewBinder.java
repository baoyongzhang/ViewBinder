package com.baoyz.viewbinder;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * 
 * @author baoyz
 * @date 2014-7-4
 * 
 * @param <T>
 */
public class DefaultViewBinder<T> extends ViewBinder<T> {

	private Context mContext;

	public DefaultViewBinder(Context context) {
		mContext = context;
	}

	@Override
	public void setViewValue(BindInfo info, T bean) {
		if (info == null || bean == null) {
			return;
		}
		if (info.isSetter()) {
			try {
				Object bindValue = info.getBindValue(bean);
				// info.getView().getClass()
				// .getMethod(info.getSetter(), bindValue.getClass())
				// .invoke(info.getView(), bindValue);
				Method method = ReflectUtil.findMethod(info.getView()
						.getClass(), info.getSetter(), info.getBindParamType());
				method.invoke(info.getView(), bindValue);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			bindViewValue(info, bean);
		}
	}

	private void bindViewValue(BindInfo info, Object bean) {
		if (info == null) {
			return;
		}
		View view = info.getView();
		try {
			if (view instanceof CheckBox) {
				((CheckBox) view).setChecked((boolean) info.getBindValue(bean));
			} else if (view instanceof TextView) {
				((TextView) view).setText(info.getBindValue(bean).toString());
			} else if (view instanceof ImageView) {
				ImageView iv = (ImageView) view;
				handleImageView(iv, info.getBindValue(bean));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleImageView(ImageView iv, Object obj) {
		if (obj == null) {
			return;
		}
		Picasso.with(mContext).cancelRequest(iv);
		if (obj instanceof Integer) {
			Picasso.with(mContext).load((Integer) obj).into(iv);
		} else {
			Uri uri = convertUri(obj);
			Picasso.with(mContext).load(uri).into(iv);
		}
	}

	private Uri convertUri(Object obj) {
		if (obj != null) {
			if (obj instanceof File) {
				return Uri.fromFile((File) obj);
			}
			if (obj instanceof Uri) {
				return (Uri) obj;
			}
			return Uri.parse(obj.toString());
		}
		return null;
	}

	@Override
	public void bindView(View view, T bean) {
		if (view == null || bean == null) {
			return;
		}
		ViewFinder viewFinder = ViewFinder.getDefault(mContext);
		// field
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			setViewValue(viewFinder.findView(field, view), bean);
		}
		// method
		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			setViewValue(viewFinder.findView(method, view), bean);
		}
	}

}

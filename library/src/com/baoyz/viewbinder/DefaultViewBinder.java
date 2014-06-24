package com.baoyz.viewbinder;

import java.io.File;
import java.lang.reflect.Field;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * 
 * @author baoboy
 * @date 2014年6月24日上午2:03:50
 * @param <T>
 */
public class DefaultViewBinder<T> extends ViewBinder<T> {

	private Context mContext;

	public DefaultViewBinder(Context context) {
		mContext = context;
	}

	@Override
	public void setViewValue(View view, Field field, Object bean) {
		if (view == null || field == null || bean == null) {
			return;
		}
		try {
			field.setAccessible(true);
			if (view instanceof CheckBox) {
				((CheckBox) view).setChecked(field.getBoolean(bean));
			} else if (view instanceof TextView) {
				((TextView) view).setText(field.get(bean).toString());
			} else if (view instanceof ImageView) {
				ImageView iv = (ImageView) view;
				handleImageView(iv, field.get(bean));
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
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			setViewValue(viewFinder.findView(field, view), field, bean);
		}
	}

}

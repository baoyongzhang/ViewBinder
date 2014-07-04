package com.baoyz.viewbinder.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class CustomView extends TextView {

	public CustomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setDate(long date) {
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date(date));
		setText("我是自定义View 显示时间：" + format);
	}
}

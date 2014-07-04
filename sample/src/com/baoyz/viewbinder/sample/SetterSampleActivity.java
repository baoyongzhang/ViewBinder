package com.baoyz.viewbinder.sample;

import android.app.Activity;
import android.os.Bundle;

import com.baoyz.viewbinder.ViewBinder;

public class SetterSampleActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setter);

		SetterBean bean = new SetterBean();
		bean.setDate(System.currentTimeMillis());
		bean.setPictureId(R.drawable.picture);
		bean.setText("ʹ�� Setter ע����а�");

		ViewBinder.bind(this, bean);
		
	}

}

package com.baoyz.viewbinder.sample;

import android.app.Activity;
import android.os.Bundle;

import com.baoyz.viewbinder.ViewBinder;

public class SimpleDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_detail);

		ListBean bean = (ListBean) getIntent().getSerializableExtra("bean");
		ViewBinder.bind(this, bean);
	}

}

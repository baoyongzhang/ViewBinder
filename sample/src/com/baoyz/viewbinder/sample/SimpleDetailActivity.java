package com.baoyz.viewbinder.sample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.baoyz.viewbinder.ViewBinder;
import com.squareup.picasso.Picasso;

public class SimpleDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_detail);

		ListBean bean = (ListBean) getIntent().getSerializableExtra("bean");

		long startTime = System.nanoTime();
		ViewBinder.bind(this, bean);
		long endTime = System.nanoTime();
		Log.i("byz", "ViewBinder 耗时 = " + (endTime - startTime));

		startTime = System.nanoTime();
		ImageView iv = (ImageView) findViewById(R.id.iv_avatar);
		Picasso.with(getApplicationContext()).load(Uri.parse(bean.getAvatar()))
				.into(iv);
		TextView name = (TextView) findViewById(R.id.tv_name);
		name.setText(bean.getName());
		TextView des = (TextView) findViewById(R.id.tv_description);
		des.setText(bean.getDescription());
		endTime = System.nanoTime();
		Log.i("byz", "正常 耗时 = " + (endTime - startTime));
	}

}

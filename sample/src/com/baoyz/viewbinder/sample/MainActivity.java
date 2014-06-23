package com.baoyz.viewbinder.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onSimpleList(View v) {
		startActivity(new Intent(this, SimpleActivity.class));
	}

	public void onContactList(View v) {
		startActivity(new Intent(this, ContactActivity.class));
	}
}

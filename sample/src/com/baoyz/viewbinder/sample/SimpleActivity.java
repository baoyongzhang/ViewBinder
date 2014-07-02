package com.baoyz.viewbinder.sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baoyz.viewbinder.adapter.BaseListAdapter;

public class SimpleActivity extends Activity {

	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple);

		List<ListBean> list = new ArrayList<ListBean>();
		for (int i = 0; i < 50; i++) {
			list.add(new ListBean(
					"Name" + i,
					"https://avatars1.githubusercontent.com/u/" + (4636761 + i),
					"descirption " + i));
		}

		mListView = (ListView) findViewById(R.id.lv_list);
		mListView.setAdapter(new BaseListAdapter<ListBean>(this, list) {
			@Override
			protected int getViewId() {
				return R.layout.list_item;
			}
		});
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(SimpleActivity.this,
						SimpleDetailActivity.class);
				// TODO ParcelableGenerator
				intent.putExtra("bean", (Serializable) parent.getAdapter()
						.getItem(position));
				startActivity(intent);
			}
		});
		
		ImageView iv = new ImageView(this);
		
		TextView tv = new TextView(this);
		
		CheckBox cb = new CheckBox(this);
		
		
		
	}

}

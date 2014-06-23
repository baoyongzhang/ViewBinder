package com.baoyz.viewbinder.sample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.baoyz.viewbinder.BaseListAdapter;

public class SimpleActivity extends Activity {

	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple);

		List<ListBean> list = new ArrayList<ListBean>();
		for (int i = 0; i < 50; i++) {
			list.add(new ListBean("Name" + i,
					"https://avatars1.githubusercontent.com/u/" + (4636761 + i)));
		}

		mListView = (ListView) findViewById(R.id.lv_list);
		mListView.setAdapter(new BaseListAdapter<ListBean>(this, list) {
			@Override
			protected int getViewId() {
				return R.layout.list_item;
			}
		});
	}

}

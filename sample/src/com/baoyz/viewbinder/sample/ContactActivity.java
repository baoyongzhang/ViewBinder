package com.baoyz.viewbinder.sample;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.ListView;

import com.baoyz.viewbinder.adapter.SimpleCursorAdapter;

public class ContactActivity extends BaseLoadActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_contact);
		ListView mListView = (ListView) findViewById(R.id.lv_list);

		SimpleCursorAdapter<ContactBean> mAdapter = new SimpleCursorAdapter<ContactBean>(
				this, ContactBean.class, R.layout.list_contact_item);
		initLoad(mListView, mAdapter, Phone.CONTENT_URI, null, null);
	}

}

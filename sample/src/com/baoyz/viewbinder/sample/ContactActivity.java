package com.baoyz.viewbinder.sample;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.ListView;

import com.baoyz.viewbinder.BaseCursorAdapter;

public class ContactActivity extends BaseLoadActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_contact);
		ListView mListView = (ListView) findViewById(R.id.lv_list);

		BaseCursorAdapter<ContactBean> mAdapter = new BaseCursorAdapter<ContactBean>(
				this, ContactBean.class) {
			@Override
			protected int getViewId() {
				return R.layout.list_contact_item;
			}

		};
		initLoad(mListView, mAdapter, Phone.CONTENT_URI, null, null);
	}

}

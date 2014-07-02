package com.baoyz.viewbinder.sample;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import com.baoyz.viewbinder.BindView;
import com.baoyz.viewbinder.adapter.ICursorBean;

public class ContactBean implements ICursorBean {

	@BindView(R.id.tv_name)
	private String name;
	@BindView(R.id.tv_number)
	private String number;
	@BindView(R.id.iv_avatar)
	private Uri avatar;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Uri getAvatar() {
		return avatar;
	}

	public void setAvatar(Uri avatar) {
		this.avatar = avatar;
	}

	@Override
	public void loadFromCursor(Cursor cursor) {
		setAvatar(ContentUris.withAppendedId(
				ContactsContract.Contacts.CONTENT_URI,
				cursor.getLong(cursor.getColumnIndex(Phone.CONTACT_ID))));
		setName(cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME)));
		setNumber(cursor.getString(cursor.getColumnIndex(Phone.NUMBER)));
	}

}

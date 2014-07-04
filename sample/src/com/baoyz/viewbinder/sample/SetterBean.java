package com.baoyz.viewbinder.sample;

import com.baoyz.viewbinder.setter.BindImageResource;
import com.baoyz.viewbinder.setter.BindSetter;
import com.baoyz.viewbinder.setter.BindText;

public class SetterBean {

	private String text;
	private int pictureId;
	private long date;

	@BindText(R.id.tv_text)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@BindImageResource(R.id.iv_picture)
	public int getPictureId() {
		return pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}

	@BindSetter(value = R.id.tv_date, setter = "setDate")
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

}

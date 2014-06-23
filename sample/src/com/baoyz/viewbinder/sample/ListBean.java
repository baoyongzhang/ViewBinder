package com.baoyz.viewbinder.sample;

import com.baoyz.viewbinder.BindView;

public class ListBean {

	@BindView(R.id.tv_name)
	private String name;
	@BindView(R.id.iv_avatar)
	private String avatar;

	public ListBean(String name, String avatar) {
		super();
		this.name = name;
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}

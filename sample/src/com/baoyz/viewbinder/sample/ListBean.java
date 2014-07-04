package com.baoyz.viewbinder.sample;

import java.io.Serializable;

import com.baoyz.viewbinder.BindView;

public class ListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2221269192972761210L;

	@BindView(R.id.tv_name)
	private String name;
	private String avatar;
	@BindView(R.id.tv_description)
	private String description;

	public ListBean(String name, String avatar, String description) {
		super();
		this.name = name;
		this.avatar = avatar;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@BindView(R.id.iv_avatar)
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

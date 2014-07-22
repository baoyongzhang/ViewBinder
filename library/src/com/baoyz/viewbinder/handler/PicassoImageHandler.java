package com.baoyz.viewbinder.handler;

import java.io.File;

import com.squareup.picasso.Picasso;

import android.net.Uri;
import android.widget.ImageView;

/**
 * 
 * @author baoyz
 * @date 2014-7-22
 *
 */
public class PicassoImageHandler implements ImageHandler {

	@Override
	public void handle(ImageView iv, Object value) {
		if (value == null) {
			return;
		}
		Picasso.with(iv.getContext()).cancelRequest(iv);
		if (value instanceof Integer) {
			Picasso.with(iv.getContext()).load((Integer) value).into(iv);
		} else {
			Uri uri = convertUri(value);
			Picasso.with(iv.getContext()).load(uri).into(iv);
		}
	}

	private Uri convertUri(Object obj) {
		if (obj != null) {
			if (obj instanceof File) {
				return Uri.fromFile((File) obj);
			}
			if (obj instanceof Uri) {
				return (Uri) obj;
			}
			return Uri.parse(obj.toString());
		}
		return null;
	}
}

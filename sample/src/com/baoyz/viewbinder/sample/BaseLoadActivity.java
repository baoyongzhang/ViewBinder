package com.baoyz.viewbinder.sample;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 
 * 
 * @author Baoyz
 * 
 * @date 2014-6-9 ÏÂÎç6:18:50
 */
public class BaseLoadActivity extends FragmentActivity implements
		LoaderCallbacks<Cursor>, OnItemClickListener {

	private CursorAdapter mAdapter;
	private String mOrderBy;
	private String mSelection;
	private Uri mUri;

	public void initLoad(ListView listView, CursorAdapter adapter, Uri uri,
			String selection, String orderBy) {
		mAdapter = adapter;
		mSelection = selection;
		mOrderBy = orderBy;
		mUri = uri;
		if (listView != null) {
			listView.setAdapter(mAdapter);
			listView.setOnItemClickListener(this);
		}
		getSupportLoaderManager().initLoader(0, null, this);
		loadData(1);
	}

	protected void loadData(int page) {

	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		return new CursorLoader(this, mUri, null, mSelection, null, mOrderBy);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loder, Cursor cursor) {
		if (cursor != null) {
			mAdapter.swapCursor(cursor);
		}
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		mAdapter.swapCursor(null);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}
}

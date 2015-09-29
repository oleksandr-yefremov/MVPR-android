/*
 * Copyright (c) Oleksandr Yefremov (yefremov.oleksandr@gmail.com)
 */

package io.github.oleksandr_yefremov.mvpr_android.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import io.github.oleksandr_yefremov.mvpr_android.R;
import io.github.oleksandr_yefremov.mvpr_android.view.viewholder.DiscoverCardAdapter.DiscoverViewHolder;

/**
 *
 */
public class DiscoverCardAdapter extends RecyclerView.Adapter<DiscoverViewHolder> {

	private List<DiscoverItem> items;
	DiscoverItem itemsData[] = { new DiscoverItem("Help"),
		                       new DiscoverItem("Delete"),
		                       new DiscoverItem("Cloud"),
		                       new DiscoverItem("Favorite"),
		                       new DiscoverItem("Like"),
		                       new DiscoverItem("Rating"),
		                       new DiscoverItem("1"),
		                       new DiscoverItem("2"),
		                       new DiscoverItem("3"),
		                       new DiscoverItem("4"),
		                       new DiscoverItem("5"),
		                       new DiscoverItem("6"),
		                       new DiscoverItem("7"),
		                       new DiscoverItem("8"),
		                       new DiscoverItem("9"),
		                       new DiscoverItem("10"),
		                       new DiscoverItem("11")};

	public DiscoverCardAdapter() {
		this.items = Arrays.asList(itemsData);
	}

	public DiscoverCardAdapter(List<DiscoverItem> items) {
		this.items = items;
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public void onBindViewHolder(DiscoverViewHolder discoverViewHolder, int i) {
		DiscoverItem item = items.get(i);
//		discoverViewHolder.imageView.setImageDrawable(item.name);
		discoverViewHolder.textView.setText(item.text);
	}

	@Override
	public DiscoverViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_discover_card, viewGroup, false);

		return new DiscoverViewHolder(itemView);
	}

	public static class DiscoverViewHolder extends RecyclerView.ViewHolder {
		protected ImageView imageView;
		protected TextView textView;

		public DiscoverViewHolder(View view) {
			super(view);
			imageView = (ImageView) view.findViewById(R.id.imageView);
			textView = (TextView) view.findViewById(R.id.textView);
		}
	}

	public static class DiscoverItem {
		public String text;

		public DiscoverItem(String text) {
			this.text = text;
		}
	}
}
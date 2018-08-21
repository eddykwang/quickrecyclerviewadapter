package com.eddystudio.quickrecyclerviewadapterdemo;

import android.support.annotation.NonNull;

import com.eddystudio.quickrecyclerviewadapterlib.QuickRecyclerViewBaseAdapter;

import java.util.List;

public class MyAdapter extends QuickRecyclerViewBaseAdapter {
  private final List<RecyclerviewItemViewModel> list;
  private final int layoutId = R.layout.layout_recyclerview_item;

  MyAdapter(List<RecyclerviewItemViewModel> list) {
    super(com.eddystudio.quickrecyclerviewadapterdemo.BR.vm);
    this.list = list;
  }

  @Override
  public void onBindViewHolder(@NonNull QuickRecyclerViewBaseAdapter.QuickRecyclerViewHolder quickRecyclerViewHolder, int i) {
    super.onBindViewHolder(quickRecyclerViewHolder, i);
//    quickRecyclerViewHolder.itemView.findViewById(...)
    // you can get the view here to do whatever you want
  }

  public void setData(List<RecyclerviewItemViewModel> list) {
    this.list.clear();
    this.list.addAll(list);
    this.notifyDataSetChanged();
  }

  public void addDataInPos(int pos, RecyclerviewItemViewModel item) {
    this.list.add(pos, item);
    this.notifyItemInserted(pos);
  }

  // ... Do whatever you want for the adapter

  @Override
  protected Object getObjectForPosition(int position) {
    return list.get(position);
  }

  @Override
  protected int getLayoutIdForPosition(int position) {
    return getLayoutId();
  }

  @Override
  protected int getLayoutId() {
    return layoutId;
  }

  @Override
  public int getItemCount() {
    return list.size();
  }
}

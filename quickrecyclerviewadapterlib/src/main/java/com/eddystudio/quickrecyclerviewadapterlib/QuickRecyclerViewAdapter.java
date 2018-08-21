package com.eddystudio.quickrecyclerviewadapterlib;

import java.util.List;

public class QuickRecyclerViewAdapter<T> extends QuickRecyclerViewBaseAdapter {

  private final List<T> itemList;
  private final int layout;

  public QuickRecyclerViewAdapter(List<T> itemList, int layout, int bindId) {
    super(bindId);
    this.itemList = itemList;
    this.layout = layout;
  }

  public void SetItemList(List<T> itemList) {
    this.itemList.addAll(itemList);
    notifyDataSetChanged();
  }

  public List<T> getItemList() {
    return itemList;
  }

  public void addSingleData(T data) {
    this.itemList.add(data);
    notifyItemInserted(itemList.size());
  }

  @Override
  public int getItemCount() {
    return itemList.size();
  }

  @Override
  protected int getLayoutId() {
    return layout;
  }

  @Override
  protected Object getObjectForPosition(int position) {
    return itemList.get(position);
  }

  @Override
  protected int getLayoutIdForPosition(int position) {
    return layout;
  }
}

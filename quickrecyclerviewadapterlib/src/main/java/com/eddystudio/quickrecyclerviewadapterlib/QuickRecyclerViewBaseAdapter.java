package com.eddystudio.quickrecyclerviewadapterlib;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class QuickRecyclerViewBaseAdapter extends RecyclerView.Adapter<QuickRecyclerViewBaseAdapter.QuickRecyclerViewHolder> {

  private final int bindId;

  QuickRecyclerViewBaseAdapter(int bindId) {this.bindId = bindId;}

  @NonNull
  @Override
  public QuickRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View singleItemView =
        LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutId(), viewGroup, false);
    return new QuickRecyclerViewHolder(singleItemView);
  }


  @Override
  public void onBindViewHolder(@NonNull QuickRecyclerViewHolder quickRecyclerViewHolder, int i) {
    Object obj = getObjectForPosition(i);
    quickRecyclerViewHolder.bind(obj);
  }

  @Override
  public int getItemViewType(int position) {
    return getLayoutIdForPosition(position);
  }

  protected abstract Object getObjectForPosition(int position);

  protected abstract int getLayoutIdForPosition(int position);

  protected abstract int getLayoutId();

  class QuickRecyclerViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public QuickRecyclerViewHolder(@NonNull View itemView) {
      super(itemView);
      this.binding = DataBindingUtil.bind(itemView);
    }

    public void bind(Object obj) {
      binding.setVariable(bindId, obj);
      binding.executePendingBindings();
    }
  }
}

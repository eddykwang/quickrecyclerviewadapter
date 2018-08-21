package com.eddystudio.quickrecyclerviewadapterdemo;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class RecyclerviewItemViewModel {
  public final ObservableField<String> title = new ObservableField<>("");
  public final ObservableField<String> description = new ObservableField<>("");

  RecyclerviewItemViewModel(String title, String description) {
    this.title.set(title);
    this.description.set(description);
  }
}

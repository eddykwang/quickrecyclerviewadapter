package com.eddystudio.quickrecyclerviewadapterdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.eddystudio.quickrecyclerviewadapterlib.QuickRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
    final List<RecyclerviewItemViewModel> vmList = new ArrayList<>();
    vmList.add(new RecyclerviewItemViewModel("Cupcake", "On April 27, 2009, the Android 1.5 update was released"));
    vmList.add(new RecyclerviewItemViewModel("Donut", "On September 15, 2009, Android 1.6 – dubbed Donut – was released"));
    vmList.add(new RecyclerviewItemViewModel("Eclair", "On October 26, 2009, the Android 2.0 SDK was released"));
    vmList.add(new RecyclerviewItemViewModel("Froyo", "On May 20, 2010, the SDK for Android 2.2 (Froyo, short for frozen yogurt) was released"));
    vmList.add(new RecyclerviewItemViewModel("Gingerbread", "On December 6, 2010, the Android 2.3 (Gingerbread) SDK was released"));
    vmList.add(new RecyclerviewItemViewModel("Honeycomb", "On February 22, 2011, the Android 3.0 (Honeycomb) SDK – the first tablet-only Android update – was released"));
    vmList.add(new RecyclerviewItemViewModel("Ice Cream Sandwich", "The SDK for Android 4.0.1 (Ice Cream Sandwich), based on Linux kernel 3.0.1,[93] was publicly released on October 19, 2011"));
    vmList.add(new RecyclerviewItemViewModel("Jelly Bean", "Google announced Android 4.1 (Jelly Bean) at the Google I/O conference on June 27, 2012."));
    vmList.add(new RecyclerviewItemViewModel("Kitkat", "Google announced Android 4.4 KitKat on September 3, 2013."));

    final QuickRecyclerViewAdapter quickRecyclerViewAdapter = new QuickRecyclerViewAdapter<>(vmList, R.layout.layout_recyclerview_item, BR.vm);
    recyclerView.setAdapter(quickRecyclerViewAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        quickRecyclerViewAdapter.SetItemList(vmList);
        Snackbar.make(view, "Add more date into adapter", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });
  }

}

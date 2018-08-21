# quickrecyclerviewadapter
[![](https://jitpack.io/v/eddykwang/quickrecyclerviewadapter.svg)](https://jitpack.io/#eddykwang/quickrecyclerviewadapter)

### A quick and easy to use Generic Recyclerview adapter for databinding recyclerview.

<img src="https://github.com/eddykwang/quickrecyclerviewadapter/blob/master/screenshot/Screenshot_1.png" width="250">

## Dependency
```
allprojects {
  repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```
dependencies {
  implementation 'com.github.eddykwang:quickrecyclerviewadapter:1.01'
}
```

# How to use
## Basic usage
``` java
/**
QuickRecyclerview takse three parameters:
List of your viewmodel for recyclerview item
Layout for recyclerview item
Bind id for recyclerview item (see the example layout file below)
*/
List<RecyclerviewItemViewModel> vmList = new ArrayList<>();
QuickRecyclerViewAdapter quickRecyclerViewAdapter = new QuickRecyclerViewAdapter<>(vmList, R.layout.layout_recyclerview_item, BR.vm);
RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
recyclerView.setAdapter(quickRecyclerViewAdapter);
```

Example of layout file with DataBinding
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools">

  <data>

    <variable
      name="vm"
      type="com.eddystudio.quickrecyclerviewadapterdemo.RecyclerviewItemViewModel"/>
  </data>

  <android.support.constraint.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
      android:id="@+id/title_tv"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="@{vm.title}"
	      ...
	/>

    <TextView
      android:id="@+id/decrip_tv"
      android:layout_width="0dp"
      android:layout_height="wrap_content"
      android:text="@{vm.description}"
	      ...
	/>
  </android.support.constraint.ConstraintLayout>
</layout>
```
Viewmodel class example
```java
public class RecyclerviewItemViewModel {
  public final ObservableField<String> title = new ObservableField<>("");
  public final ObservableField<String> description = new ObservableField<>("");

  RecyclerviewItemViewModel(String title, String description) {
    this.title.set(title);
    this.description.set(description);
  }
}
```
## Advance Usage
You also can extend ```QuickRecyclerViewBaseAdapter``` class to do more custom usage.

For example:
```java

````

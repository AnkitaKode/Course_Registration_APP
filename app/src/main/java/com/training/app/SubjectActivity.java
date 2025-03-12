package com.training.app;

import android.content.ClipData;
import android.media.RouteListingPreference;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.app.Adapter.Itemadapter;
import com.training.app.DataModel.Items;

import java.util.ArrayList;
import java.util.List;

public class SubjectActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        recyclerView=findViewById(R.id.recycle_tab);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Items> itemList=new ArrayList<>();
        itemList.add(new Items("item2"));
        itemList.add(new Items("item3"));
        itemList.add(new Items("item4"));
        itemList.add(new Items("item5"));
        itemList.add(new Items("item1"));
        itemList.add(new Items("item6"));
        itemList.add(new Items("item7"));
        itemList.add(new Items("item8"));
        itemList.add(new Items("item9"));

        Itemadapter adapter=new Itemadapter(itemList);
        recyclerView.setAdapter(adapter);

    }
}
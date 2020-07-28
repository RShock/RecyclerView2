package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = findViewById(R.id.recView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new DataAdapter(initData());
        recyclerView.setAdapter(mAdapter);
    }

    private List<Data> initData() {
        return IntStream.rangeClosed(0, 15).boxed().map(
                i -> {
                    if(i == 0)
                        return new Data(Data.TYPE_HEADER,"this is header", null, 0);
                    return new Data(Data.TYPE_ITEM, "title" + i, "desp" + i, i);
                }
        ).collect(Collectors.toList());
    }
}
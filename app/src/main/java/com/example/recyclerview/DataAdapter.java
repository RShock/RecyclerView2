package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

public class DataAdapter extends Adapter<DataAdapter.MyViewHolder> {

    List<Data> dataList;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View item;
        public TextView title;
        public TextView desc;
        public MyViewHolder(View v) {
            super(v);
            item = v;
            title = item.findViewById(R.id.title);
            desc = item.findViewById(R.id.description);
        }
    }

    public DataAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.title.setText(data.getTitle());
        holder.desc.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

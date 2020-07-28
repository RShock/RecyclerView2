package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter {

    List<Data> dataList;

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View item;
        public TextView title;
        public TextView desc;
        public TextView num;

        public ContentViewHolder(View v) {
            super(v);
            item = v;
            title = item.findViewById(R.id.title);
            desc = item.findViewById(R.id.description);
            num = item.findViewById(R.id.num);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View item;
        public TextView header;

        public HeaderViewHolder(View v) {
            super(v);
            item = v;
            header = item.findViewById(R.id.header);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).type;
    }

    public DataAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case Data.TYPE_HEADER:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.header, parent, false);
                return new HeaderViewHolder(v);
            case Data.TYPE_ITEM:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item, parent, false);
                return new ContentViewHolder(v);
            default:
                return new ContentViewHolder(null);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        switch (data.type){
            case Data.TYPE_HEADER:
                ((HeaderViewHolder) holder).header.setText(data.title);
                break;
            case Data.TYPE_ITEM:
                ((ContentViewHolder) holder).title.setText(data.title);
                ((ContentViewHolder) holder).desc.setText(data.description);
                ((ContentViewHolder) holder).num.setText(String.valueOf(data.number));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

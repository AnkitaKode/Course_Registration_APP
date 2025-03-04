package com.training.app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.training.app.DataModel.Items;
import com.training.app.R;
import java.util.List;


public class Itemadapter extends RecyclerView.Adapter<Itemadapter.ViewHolder> {
    private List<Items> itemList;

    public Itemadapter(List<Items> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Itemadapter.ViewHolder holder, int position) {
        Items item = itemList.get(position);
        holder.textViewItem.setText(item.getText());
    }


    @Override
    public int getItemCount() {
        return itemList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.sub_text);
        }
    }
}

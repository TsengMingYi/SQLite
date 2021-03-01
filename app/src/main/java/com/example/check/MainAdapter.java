package com.example.check;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<Content> arrayList = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Content content = arrayList.get(position);
        holder.Name.setText(content.getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public void refreshUI( ArrayList<Content> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        Name = itemView.findViewById(R.id.Name);
    }
}
}

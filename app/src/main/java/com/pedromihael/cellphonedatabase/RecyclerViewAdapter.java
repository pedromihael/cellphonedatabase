package com.pedromihael.cellphonedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context mContext;
    List<Model> mModelList;

    public RecyclerViewAdapter(Context mContext, List<Model> mModelList) {
        this.mContext = mContext;
        this.mModelList = mModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.card_item_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_model.setText(mModelList.get(position).getName());
        holder.tv_brand.setText("/ " + mModelList.get(position).getBrand());

    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private TextView tv_model;
        private TextView tv_brand;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_brand = itemView.findViewById(R.id.card_text_brand);
            tv_model = itemView.findViewById(R.id.card_text_model);

        }
    }

}

package com.example.furnitureappandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;
    private Context mContext;

    public CustomAdapter(ArrayList<DataModel> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_card_view , parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageViewIcon = holder.imageViewIcon;
        DataModel dataModel = dataSet.get(position);
        textViewName.setText(dataModel.getName());
        textViewVersion.setText(dataModel.getVersion());
       //glide image
        Glide.with(mContext).load(dataModel.getImage()).apply(
                RequestOptions.bitmapTransform(new RoundedCorners(20))
        ).into(imageViewIcon);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;
       // ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewVersion = itemView.findViewById(R.id.textViewVersion);
            imageViewIcon = itemView.findViewById(R.id.imageView);
            // itemView.setOnClickListener( (View.OnClickListener) this);
        }


        @Override
        public void onClick(View v) {

        }
    }
}

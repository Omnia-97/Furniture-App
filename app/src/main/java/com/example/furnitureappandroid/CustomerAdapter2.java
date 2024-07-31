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
import java.util.zip.Inflater;

public class CustomerAdapter2 extends RecyclerView.Adapter<CustomerAdapter2.CustomerViewHolder> {
    private Context mContext2;
    private ArrayList<DataModel> data2s;

    public CustomerAdapter2(Context mContext2, ArrayList<DataModel> data2s) {
        this.mContext2 = mContext2;
        this.data2s = data2s;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_secondary, parent, false);
        CustomerViewHolder customerViewHolder = new CustomerViewHolder(view);

        return customerViewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomerViewHolder holder, final int position) {
        TextView textViewName = holder.textViewName2;
        TextView textViewVersion = holder.textViewVersion2;
        ImageView imageViewIcon = holder.imageViewIcon2;
        DataModel dataModel = data2s.get(position);
        textViewName.setText(dataModel.getName());
        textViewVersion.setText(dataModel.getVersion());
        //glide image
        Glide.with(mContext2).load(dataModel.getImage()).apply(
                RequestOptions.bitmapTransform(new RoundedCorners(20))
        ).into(imageViewIcon);


    }

    @Override
    public int getItemCount() {
        return data2s.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName2;
        TextView textViewVersion2;
        ImageView imageViewIcon2;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName2 = itemView.findViewById(R.id.textViewName);
            textViewVersion2 = itemView.findViewById(R.id.textViewVersion);
            imageViewIcon2 = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {

        }
    }
}

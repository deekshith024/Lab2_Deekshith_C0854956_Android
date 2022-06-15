package com.example.lab2_deekshith_c0854956_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import  java.util.ArrayList;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {

   private Context context;
   private  ArrayList  product_id, product_name, product_description, product_price;

   CustomAdaptor(Context context,
                 ArrayList product_id,
                 ArrayList product_name,
                 ArrayList product_description,
                 ArrayList product_price) {
       this.context = context;
       this.product_id = product_id;
       this.product_name = product_name;
       this.product_description = product_description;
       this.product_price = product_price;
   }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.product_id_txt.setText(String.valueOf(product_id.get(position)));
       holder.product_name_txt.setText(String.valueOf(product_name.get(position)));
       holder.product_description_txt.setText(String.valueOf(product_description.get(position)));
       holder.product_price_txt.setText(String.valueOf(product_price.get(position)));



    }

    @Override
    public int getItemCount() {
        return product_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView product_id_txt, product_name_txt, product_description_txt, product_price_txt;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        product_id_txt = itemView.findViewById(R.id.product_id_text);
        product_name_txt = itemView.findViewById(R.id.product_name_txt);
            product_description_txt = itemView.findViewById(R.id.product_description);
            product_price_txt = itemView.findViewById(R.id.product_price_txt);

        }
    }
}









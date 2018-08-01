package com.example.dell.loginandsignup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELL on 6/4/2018.
 */
/*
public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

    private Context ctx;
    private ArrayList<Product> products;

    public adapter(Context ctx,ArrayList<Product> products)
    {
        this.ctx = ctx;
        this.products = products;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(ctx).inflate(R.layout.menu_items,parent,false);
    } */

public class adapter extends  RecyclerView.Adapter<adapter.ViewHolder>
{
    private Context ctx;
    private ArrayList<Product> products;
    Callback callback;
    private ArrayList<Product> selectedList= new ArrayList<>();

    public adapter(Context ctx,ArrayList<Product> products,Callback callback ) {
        this.ctx=ctx;
        this.products =products;
        this.callback=callback;
    }

    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.menu_items,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final adapter.ViewHolder holder, int position) {

        final Product product=products.get(holder.getAdapterPosition());

        holder.imageView.setImageResource(product.getProductImage());
        holder.textView1.setText(product.getProductName());
        holder.textView2.setText(product.getProductDesc());
        holder.textView3.setText(product.getPrice());
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(product.getSelection());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(holder.checkBox.isChecked()){
                    product.setSelection(true);
                    holder.checkBox.setChecked(true);
                    notifyDataSetChanged();
                    if(product.getSelection()){
                        selectedList.add(product);
                    }
                    if(callback!=null)
                    {
                        callback.onCallBack(selectedList);
                    }
                } else {
                    product.setSelection(false);
                    holder.checkBox.setChecked(false);
                    notifyDataSetChanged();
                    if(!product.getSelection()){
                        selectedList.remove(product);
                    }
                    if(callback!=null)
                    {
                        callback.onCallBack(selectedList);
                    }
                }
            }
        });
        //notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1,textView2,textView3;
        CheckBox checkBox;

        public ViewHolder(View view)
        {
            super(view);
            this.setIsRecyclable(false);
            imageView = view.findViewById(R.id.img1);
            textView1 = view.findViewById(R.id.tview1);
            textView2 = view.findViewById(R.id.tview2);
            textView3 = view.findViewById(R.id.tview3);
            checkBox = view.findViewById(R.id.checkbox);
        }
    }
}

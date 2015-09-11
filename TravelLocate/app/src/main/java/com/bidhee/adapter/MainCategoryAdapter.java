package com.bidhee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bidhee.model.CategoryModel;
import com.bidhee.travellocate.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by user on 7/19/2015.
 */
public class MainCategoryAdapter extends BaseAdapter {

    private ArrayList<CategoryModel> catItems;
    private Context context;
    private LayoutInflater layoutInflater;
    ViewHolder viewHolder;

    public MainCategoryAdapter(Context context, ArrayList<CategoryModel> catItems) {
        this.context = context;
        this.catItems = catItems;
        try {
            layoutInflater = LayoutInflater.from(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getCount() {
        return catItems.size();
    }

    @Override
    public Object getItem(int position) {
        return catItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int currentPostion = position;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapter_main_category,parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvCatTitle = (TextView) convertView	.findViewById(R.id.tvCatTitle);
            viewHolder.tvCatShortDescp= (TextView) convertView	.findViewById(R.id.tvCatShortDescp);

            viewHolder.ivCat = (ImageView) convertView.findViewById(R.id.ivCat);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(catItems.get(currentPostion).getCatImage()).into(viewHolder.ivCat);
        viewHolder.tvCatTitle.setText(catItems.get(currentPostion).getCatName());
        viewHolder.tvCatShortDescp.setText(catItems.get(currentPostion).getCatDetails());
        return convertView;
    }

    static class ViewHolder {
        TextView tvCatTitle,tvCatShortDescp;
        ImageView ivCat;


    }




}

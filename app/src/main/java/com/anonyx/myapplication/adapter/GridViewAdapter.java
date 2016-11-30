package com.anonyx.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anonyx.myapplication.model.ImageItem;
import com.anonyx.myapplication.R;

import java.util.ArrayList;

/**
 * Created by anonyx on 30/11/16.
 */

public class GridViewAdapter extends ArrayAdapter {

    Context context;
    int resourceId;
    ArrayList data = new ArrayList();

    public GridViewAdapter(Context context, int resourceId, ArrayList data) {
        super(context, resourceId, data);
        this.context = context;
        this.resourceId = resourceId;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder viewHolder = null;

        if (row==null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) row.findViewById(R.id.thumbnail);
            viewHolder.textView = (TextView) row.findViewById(R.id.title);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) row.getTag();
        }

        ImageItem imageItem = (ImageItem) data.get(position);
        viewHolder.textView.setText(imageItem.getTitle());
        viewHolder.imageView.setImageBitmap(imageItem.getImage());
        return row;
    }

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
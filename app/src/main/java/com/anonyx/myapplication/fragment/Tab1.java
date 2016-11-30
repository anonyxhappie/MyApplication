package com.anonyx.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.anonyx.myapplication.R;
import com.anonyx.myapplication.activity.DetailsActivity;
import com.anonyx.myapplication.activity.MainActivity;
import com.anonyx.myapplication.adapter.GridViewAdapter;
import com.anonyx.myapplication.model.ImageItem;

import java.util.ArrayList;

/**
 * Created by anonyx on 30/11/16.
 */

public class Tab1 extends Fragment {

    GridView gridView;
    Activity activity;
    public Tab1(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        CardView cardView = (CardView) this.getLayoutInflater(savedInstanceState).inflate(R.layout.layout_card, null);
//        TextView textView = (TextView) cardView.findViewById(R.id.title);
//        textView.setText("Done Bruh!!");
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.layout_tab1, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        GridViewAdapter viewAdapter = new GridViewAdapter(getContext(), R.layout.layout_card, getData());
        gridView.setAdapter(viewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                Intent intent = new Intent(activity, DetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());
                startActivity(intent);
            }

        });

        return view;
    }

    private ArrayList getData(){
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.remote);
        imageItems.add(new ImageItem(bitmap, "Basic"));
        imageItems.add(new ImageItem(bitmap, "Intermediate"));
        imageItems.add(new ImageItem(bitmap, "Web"));
        imageItems.add(new ImageItem(bitmap, "Advance"));
        return imageItems;
    }

}

package com.anonyx.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anonyx.myapplication.R;

/**
 * Created by anonyx on 30/11/16.
 */

public class Tab2 extends Fragment {

    TextView textView;

    public Tab2() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab2, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("The PRO is yet to come!!");
        return view;
    }

}

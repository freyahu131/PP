package com.project.pp.parentparadise.lin;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;

import com.project.pp.parentparadise.R;

import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {

    private Gallery mGallery;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private Handler mHandler = new Handler();
    private int[] Pics = {} ;

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Gallery gallery = view.findViewById(R.id.gallery);
        ImageView ivSlide = view.findViewById(R.id.ivSlide);
        return view;

    }

}

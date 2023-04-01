package com.lbas.collegestudentapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lbas.collegestudentapp.R;


public class AboutFragment extends Fragment {

    private ImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_about, container, false);
        image = view.findViewById(R.id.collegeImg);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/lbas-college-app.appspot.com/o/lb_college.png?alt=media&token=1e6d7dc0-94f9-4dc3-845c-7675376e30a8")
                .into(image);
        return view;
    }
}
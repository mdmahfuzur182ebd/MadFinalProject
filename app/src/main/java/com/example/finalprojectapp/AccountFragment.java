package com.example.finalprojectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class AccountFragment  extends Fragment {
    public  AccountFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        getActivity().setTitle("Shopify-Account");
        return  inflater.inflate(R.layout.fragment_abouts, container, false);


    }
}

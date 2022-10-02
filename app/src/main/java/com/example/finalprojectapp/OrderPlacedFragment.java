package com.example.finalprojectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class OrderPlacedFragment extends Fragment {

    public  OrderPlacedFragment(){

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        getActivity().setTitle("MediMart-Order Placed");
        return  inflater.inflate(R.layout.fragment_order_placed, container, Boolean.parseBoolean("false"));
    }
}

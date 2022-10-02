package com.example.finalprojectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import  androidx.fragment.app.Fragment;


public class AboutsFragment extends  Fragment{


    public AboutsFragment(){

    }


    public  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
      getActivity().setTitle("Shopify-Cart");
      return  inflater.inflate(R.layout.fragment_abouts, container, false);

    }



    public static  class CatListFragment extends  Fragment{

        private  static final  String ARG_PARAM1 = "param1";
        private  static final  String ARG_PARAM2 = "param2";

        private  String mParam1;
        private  String mParam2;

        public CatListFragment() {

        }

        public  static  CatListFragment newInstance (String Param1, String Param2){
            CatListFragment fragment = new CatListFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, Param1);
            args.putString(ARG_PARAM2, Param2);
            fragment.setArguments(args);
            return  fragment;
        }

        public void  onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            if (getArguments()!=null){
                mParam1 = getArguments().getString((ARG_PARAM1));
                mParam2 = getArguments().getString((ARG_PARAM2));
            }
        }

        public  View OnCreateView(LayoutInflater inflater, ViewGroup Container, Bundle savedInstanceState){
            return  inflater.inflate(R.layout.fragment_cartlist, Container, false);
        }


    }
}

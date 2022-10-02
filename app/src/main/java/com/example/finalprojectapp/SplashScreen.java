package com.example.finalprojectapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplashScreen  extends Activity {

    private  int counter ;
    private ProgressBar pbar;
    private Handler handler = new Handler();
   // private FirbaseFirstore ff;
    public final static List<Product> plist = new ArrayList<>();
    public final static List<Product> catlist = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scren);
        pbar = findViewById((R.id.progressBar));
        boolean b = handler.postDelayed(run, Long.parseLong("100"));
        plist.clear();
        loadList();
    }

    public  void  loadList(){
//        ff= FirebaseFirestore.getInstance();
//        ff.collection("products");
//        .get()
//                .addOnCompleteListener((task) -> {
//                    if (task.isSuccessful()){
//                        Set<String> cats = new HashSet<>();
//
//                    }
//                });

    }

    Runnable run=()-> {
        counter ++;
        pbar.setProgress(counter);
        if (counter == 100){
            finish();
            startActivity(new Intent(SplashScreen.this, HomeActivity.class));
        }else {
            handler.postDelayed((Runnable) this,50);
        }

    };
}

package com.example.finalprojectapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProductFragment extends Fragment {

    public  AddProductFragment(){

    }

    private EditText et1, et2, et3;
    private ImageView b1;
    private Button b;
    private  StorageReference sref;
    private  FirebaseFirestore ff;
    private Uri uri;
    private  MediMartDbHelper db;

    public View onCreateView(LayoutInflater inflater, ViewGroup Container, Bundle savedInstanceState){
        View vv= inflater.inflate(R.layout.fragment_abouts, Container, false);
        b1=vv.findViewById(R.id.btnimgup);
        b=vv.findViewById(R.id.baddproduct);
        et1=vv.findViewById(R.id.etprodname);
        et2=vv.findViewById(R.id.etprodprice);
        et3=vv.findViewById(R.id.etpcat);
        ff= FirebaseFirestore.getInstance();
        b1.setOnClickListener((v) -> {
            Intent intent =new Intent((Intent.ACTION_PICK);
            intent.setData((MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
            startActivityForResult(intent, 100);
        });


        b.setOnClickListener((v)-> {
            b.setEnabled(false);
            SplashScreen.plist.clear();
            final  String photo = new SimpleDateFormat("ddmmyyyyHHmmss").format(new Date()+".jpg");
            sref = FirebaseStorage.getInstance().getReference("products/"+photo);
            sref.putFile(uri)
                    .continueWithTask((task) -> {
                        if (task.isSuccessful())
                            return sref.getDownloadUrl();
                        else
                            throw task.getException();
                    })
                    .addOnCompleteListener((tadk)-> {
                        final String photoname = task.getResult().toString();
                        final String pname = et1.getText().toString();
                        final int price = Integer.parseInt(et2.getText().toString());
                        final String pcat = et3.getText().toString();
                        DocumentReference newpro = ff.collection("products").document();
                        Product p = new Product (pname, pcat, photoname, price);
                        p.setProdid(newpro.getId());
                        newpro.set(p).addonCompleteListener((task) ->{
                            et1.setText("");
                            et2.setText("");
                            et3.setText("");
                            b1.setImageResource(R.drawable.ic_launcher_background);
                            et1.requestFocus();
                            Toast.makeText((getContext(), "Product saved", Toast.LENGTH_LONG).show(););
                            b.setEnabled(true);
                            MediMartUtils.getList();
                        });

                    });
        });

        return  vv;

    }
    public void  OnActivityResult(int requestCode, int resultCode , @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode , data);
        if (requestCode==100 && resultCode==RESULT__OK){
            uri= data.getData();
            ba.setImageURI(uri);
        }
    }
}
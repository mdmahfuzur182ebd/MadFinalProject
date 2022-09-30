package com.example.finalprojectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegisterFragment extends Fragment {
    public RegisterFragment() {

    }

    private EditText et1, et2, et3, et4, et5;
    private RadioGroup rg;
    private FloatingActionButton b;
    private MediMartDbHelper db;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View vv = inflater.inflate(R.layout.fragment_abouts, container, false);
        et1 = vv.findViewById(R.id.etuname);
        et2 = vv.findViewById(R.id.etcity);
        et3 = vv.findViewById(R.id.etphone);
        et4 = vv.findViewById(R.id.etemail);
        et5 = vv.findViewById(R.id.etpwd2);
        rg = vv.findViewById(R.id.rbgender);
        db = new MediMartDbHelper(getContext());
        getActivity().setTitle("Customer Registration");
        b.setOnClickListener((v) -> {

            String uname = et1.getText().toString();
            String city = et2.getText().toString();
            String phone = et3.getText().toString();
            String email = et4.getText().toString();
            String pwd = et5.getText().toString();
            RadioButton rb = vv.findViewById(rg.getCheckedRadioButtonId());
            String gender = rb.getText().toString();
            db.addCustomer(uname, city, gender, email, phone, pwd);
            Toast.makeText(getContext(), "Customer Registered..", Toast.LENGTH_SHORT).show();
            MediMartUtils.loadwithoutHistoryFragment(getActivity(), new LoginFragment());

        });
        return vv;

    }
}


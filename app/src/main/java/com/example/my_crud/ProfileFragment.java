package com.example.my_crud;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ProfileFragment extends Fragment {


    private Button logout;
    private TextView textViewUsername, textViewUserEmail, fullname, notlp, nik;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for getContext() fragment
        View r = inflater.inflate(R.layout.fragment_profile, container, false);

        if (!SharedPrefManager.getInstance(getContext()).isLoggedIn()){
            startActivity(new Intent(getContext(),LoginActivity.class));

        }

        logout = r.findViewById(R.id.bt_logout);
        nik = (TextView) r.findViewById(R.id.nik);
        fullname = (TextView) r.findViewById(R.id.fullname);
        notlp = (TextView) r.findViewById(R.id.notlp);
        textViewUsername = (TextView) r.findViewById(R.id.textViewUsername);
        textViewUserEmail = (TextView) r.findViewById(R.id.textViewUserEmail);


        nik.setText(SharedPrefManager.getInstance(getContext()).getNik());
        fullname.setText(SharedPrefManager.getInstance(getContext()).getNama());
        notlp.setText(SharedPrefManager.getInstance(getContext()).getTelpon());
        textViewUserEmail.setText(SharedPrefManager.getInstance(getContext()).getUserEmail());
        textViewUsername.setText(SharedPrefManager.getInstance(getContext()).getUsername());



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(getContext()).logout();
                startActivity(new Intent(getContext(),LoginActivity.class));

            }
        });
        
        return r;
    }
}
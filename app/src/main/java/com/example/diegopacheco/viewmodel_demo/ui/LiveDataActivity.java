package com.example.diegopacheco.viewmodel_demo.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.diegopacheco.viewmodel_demo.R;
import com.example.diegopacheco.viewmodel_demo.User;
import com.example.diegopacheco.viewmodel_demo.viewmodel.LiveDataUserViewModel;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity {

    private TextView tvLiveData;
    private Button btnGuardar;
    private int numero = 0;
    private LiveDataUserViewModel liveDataUserViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        configView();
    }

    private void configView(){
        liveDataUserViewModel = ViewModelProviders.of(this).get(LiveDataUserViewModel.class);
        tvLiveData = findViewById(R.id.tvLiveDataUser);
        btnGuardar = findViewById(R.id.btnLiveDataGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numero == 0){
                    User user = new User();
                    user.setNombre("Diego");
                    user.setEdad("22");
                    user.setEmail("diego@gmail.com");
                    liveDataUserViewModel.addUser(user);
                }
                if( numero == 1){
                    User user = new User();
                    user.setNombre("Hugo");
                    user.setEdad("26");
                    user.setEmail("hugo@gmail.com");
                    liveDataUserViewModel.addUser(user);
                }
                if(numero == 2){
                    User user = new User();
                    user.setNombre("Alex");
                    user.setEdad("22");
                    user.setEmail("alex@gmail.com");
                    liveDataUserViewModel.addUser(user);
                }
                numero++;
            }
        });

        final android.arch.lifecycle.Observer<List<User>> listObserver = new android.arch.lifecycle.Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> userList) {
                String texto = "";
                for(int i=0;i<userList.size();i++){
                    texto += userList.get(i).getNombre() + " " + userList.get(i).getEdad() + " "+ userList.get(i).getEmail() + "\n";
                }

                tvLiveData.setText(texto);
            }
        };

        liveDataUserViewModel.getUserList().observe(this,listObserver);
    }
}

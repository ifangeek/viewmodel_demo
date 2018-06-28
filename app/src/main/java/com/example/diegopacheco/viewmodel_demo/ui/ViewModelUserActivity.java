package com.example.diegopacheco.viewmodel_demo.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.diegopacheco.viewmodel_demo.R;
import com.example.diegopacheco.viewmodel_demo.User;
import com.example.diegopacheco.viewmodel_demo.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewModelUserActivity extends AppCompatActivity {

    private EditText etNombre,etEdad,etEmail;
    private Button btnGuardar,btnVer;
    private TextView tvUser,tvUserViewModel;

    private List<User> userList;
    private UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_user);
        configView();
    }

    private void configView(){
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userList = new ArrayList<>();

        tvUser = findViewById(R.id.tvUser);
        tvUserViewModel = findViewById(R.id.tvUserViewModel);

        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        etEmail = findViewById(R.id.etEmail);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setNombre(etNombre.getText().toString());
                user.setEdad(etEdad.getText().toString());
                user.setEmail(etEmail.getText().toString());
                userList.add(user);
                userViewModel.addUser(user);
            }
        });

        btnVer = findViewById(R.id.btnVer);
        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "";
                for(int i=0;i<userList.size();i++){
                    texto += userList.get(i).getNombre() +" "+ userList.get(i).getEdad() +" "+ userList.get(i).getEmail() + "\n";
                }
                tvUser.setText(texto);
                texto = "";
                for(User user : userViewModel.getUserList()){
                    texto += user.getNombre() + " " + user.getEdad() + " "+ user.getEmail() + "\n";
                }
                tvUserViewModel.setText(texto);
            }
        });
    }
}

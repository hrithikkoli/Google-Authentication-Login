package com.example.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    TextView tvUserName,tvUserEmail;
    ImageView userImageView;
    Button logout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences preferences = this.getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String userName = preferences.getString("username","");
        String userEmail = preferences.getString("useremail", "");
        String userImageUrl = preferences.getString("userPhoto","");

        mAuth = FirebaseAuth.getInstance();
        tvUserName = findViewById(R.id.userName);
        tvUserEmail = findViewById(R.id.userEmail);
        userImageView = findViewById(R.id.userImage);
        logout = findViewById(R.id.logout);


        tvUserName.setText(userName);
        tvUserEmail.setText(userEmail);
        Glide.with(this).load(userImageUrl).into(userImageView);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity2.this,MainActivity.class));

            }
        });

    }
}
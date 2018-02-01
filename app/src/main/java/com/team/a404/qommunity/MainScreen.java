package com.team.a404.qommunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Sergio Cuadrado on 25/01/2018.
 */

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button boton_logout;
    private ImageButton settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        settings = (ImageButton)findViewById(R.id.imageButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this,SettingsActivity.class);
                startActivity(intent);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            Intent intent = new Intent(MainScreen.this, Log_inActivity.class);
            startActivity(intent);
        }
        boton_logout = (Button) findViewById(R.id.boton_logout);

        boton_logout.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View view) {
        if (view == boton_logout) {
            finish();
            firebaseAuth.signOut();
            Intent intent = new Intent(MainScreen.this, Log_inActivity.class);
            startActivity(intent);
        }
    }
}

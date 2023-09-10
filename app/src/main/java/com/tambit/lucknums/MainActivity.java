package com.tambit.lucknums;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sbhi ko apni id se initialize kr diya
        t1 = findViewById(R.id.textView);
        b1 = findViewById(R.id.btn);
        et1 = findViewById(R.id.edt);

        // click pr perform hone wale actions
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // string leli jo user enter krega
                String username = et1.getText().toString();

                // Explicit Intent
                Intent i = new Intent(getApplicationContext(), secondact.class);

                // passing values to second intent
                i.putExtra("name",username);
                startActivity(i);
            }
        });
    }
}
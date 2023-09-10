package com.tambit.lucknums;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class secondact extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondact);

        tv1 = findViewById(R.id.textView2);
        tv2 = findViewById(R.id.textView3);
        btn = findViewById(R.id.btn1);

        // recieve data from main activity
        Intent i = getIntent();
        String getuser = i.getStringExtra("name");
        // call generate rand func
        int number = generatenum();
        tv2.setText(""+number);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedata(getuser,number);
            }
        });
    }
        // generate random number
        public int generatenum()
        {
            Random random = new Random();
            int high = 1000;
            int randnum = random.nextInt(high);
            return randnum;
        }
        public void sharedata(String getuser,int number)
        {
            // implicit intent
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");

            // additional info
            i.putExtra(Intent.EXTRA_SUBJECT,getuser+" got lucky today ");
            i.putExtra(Intent.EXTRA_TEXT, " His lucky number is "+number);
            startActivity(Intent.createChooser(i,"Choose a platform"));

    }
}
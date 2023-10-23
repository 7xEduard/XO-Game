package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void d(View view)
    {
        Button button=(Button) view;
        MainActivity2.di=Integer.parseInt(button.getTag().toString());
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}
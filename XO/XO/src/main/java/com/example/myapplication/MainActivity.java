package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final   PDB pdb=new PDB(this);
    final   CDB cdb=new CDB(this);
    static boolean f=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(f)
        {
            f=false;
            pdb.fetch();
            cdb.fetch();
          }
     }
    /* @Override
     public boolean onCreateOptionsMenu(@NonNull Menu menu) {
         getMenuInflater().inflate(R.menu.menu,menu);
         return true;
     }*/
    public void players(View view)
    {
        Intent intent ;
        Button b=(Button)view;
        MainActivity2.way =Integer.parseInt(b.getTag().toString());

        if(MainActivity2.way==0)
        {intent = new Intent(MainActivity.this, MainActivity2.class);}
        else if(MainActivity2.way==1) {
            intent = new Intent(MainActivity.this, MainActivity4.class);
        }
        else
        {
            intent = new Intent(MainActivity.this, MainActivity3.class);

        }
        startActivity(intent);
    }





}
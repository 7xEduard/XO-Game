package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
static boolean c=false;

    final   PDB pdb=new PDB(this);
    final   CDB cdb=new CDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView t = (TextView) findViewById(R.id.textView5);

t.setText(Integer.toString(MainActivity2.players.size()));
    }

    public void add(View view)
    {if (!c)
    {
        EditText name=findViewById(R.id.name);
        TextView t = (TextView) findViewById(R.id.textView5);
        if(!(name.getText().toString().equals("")))
        {
            boolean add =MainActivity2.players.contains(name.getText().toString());
            if(!add)
            {
                pdb.add(name.getText().toString());
           MainActivity2.players.add(name.getText().toString());
            Toast.makeText(this,"Name added",Toast.LENGTH_SHORT).show();
            name.setText("");
            t.setText(Integer.toString(MainActivity2.players.size()));}
        }
        else
        {
            Toast.makeText(this,"please enter name",Toast.LENGTH_SHORT).show();
        }}
    }
    public void enter(View view) {

if(c&&MainActivity2.players.size()!=0)
{
    Intent intent = new Intent(this, MainActivity2.class);
    startActivity(intent);
}else
{
        if ( ( MainActivity2.players.size()==0||(MainActivity2.players.size())%4!=0)) {
            Toast.makeText(this, "please enter number can be divide by 4", Toast.LENGTH_SHORT).show();
        } else {
cdb.delete();
            cdb.add(true);
c=true;
            Intent intent = new Intent(this, MainActivity2.class);

            startActivity(intent);
        } }}



        public void home(View view)
        {
            Intent home=new Intent(this,MainActivity.class);
            startActivity(home);
        }
    }
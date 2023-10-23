package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.ArraySet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class MainActivity2 extends AppCompatActivity {
char[][]s={{'-','-','-'},{'-','-','-'},{'-','-','-',}};
int player=1;
int win=0;
int loss=0;
int draw=0;
public static int di;
public static List<String> players=new ArrayList<>();;
public static int way;
boolean w= false;
boolean d=false;
   final PDB pdb=new PDB(this);
  final CDB cdb=new CDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

            TextView t = findViewById(R.id.textView);
            if (way == 2) {
                t.setText(players.get(0) + " VS " + players.get(1));
            } else {
                t.setText("X VS O");
            }


        }
    @Override
    protected void onRestart() {
        TextView t=findViewById(R.id.textView);
        if (way==2)
        { t.setText(players.get(0) + " VS " + players.get(1));
        }
        else
        {
            t.setText("X VS O");
        }
        super.onRestart();
    }

    public void tap(View view)  {

        ImageView i=(ImageView)view;
        int cell=Integer.parseInt(i.getTag().toString());
        int r=cell/10;
        int c=cell%10;
        if (!w)
        {
        if (s[r][c]=='-')
        {
        if (player%2==1)
        {
            i.setImageResource(R.drawable.x);
            s[r][c]='x';
            if(win(r,c))
            {win++;
                w=true;
                Toast.makeText(this,"x wins",Toast.LENGTH_LONG).show();

            }


            if (way==1&&!w&&player<9)
                computerplay();
        }

        else
        {

            i.setImageResource(R.drawable.o);
           s[r][c]='o';
            if(win(r,c))
            {
                w=true;loss++;
                Toast.makeText(this,"o wins",Toast.LENGTH_LONG).show();

            }
        }


       player++;
        if (!w&&player==10)
        {
            d=true;
            draw++;
            Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show();
        }

        if(way==2&&players.size()==2&&w)
        {
           cdb.uptade(false);
MainActivity3.c=false;
               Intent o = new Intent(this, MainActivity.class);
               startActivity(o);
               pdb.sdelete(players.get(0));
               pdb.sdelete(players.get(1));
                players.clear();
            }
        else if (way==2&&(w||d))
        {

            r();
        }
        }
        else{
            Toast.makeText(this,"please tap in an empty cell",Toast.LENGTH_LONG).show();
        }}

    }

    public void Home1(View view)
    {
//players.clear();
Intent i= new Intent(this,MainActivity.class);
        startActivity(i);
    }
public void r()
{
    new Handler().postDelayed(new Runnable() {

        @Override
        public void run() {

    if(w)
    {
                    pdb.sdelete(players.get(0));
                    pdb.sdelete(players.get(1));
        if(player%2==0)
        {

            pdb.add(players.get(0));
            players.add(players.get(0));

        }
        else
        {pdb.add(players.get(1));
            players.add(players.get(1));}
players.remove(0);
        players.remove(0);
    }

    TextView t=findViewById(R.id.textView);
    t.setText(players.get(0) + " VS " + players.get(1));
    ImageView imageView11=findViewById(R.id.imageView11);
    ImageView imageView12=findViewById(R.id.imageView12);
    ImageView imageView13=findViewById(R.id.imageView13);
    ImageView imageView21=findViewById(R.id.imageView21);
    ImageView imageView22=findViewById(R.id.imageView22);
    ImageView imageView23=findViewById(R.id.imageView23);
    ImageView imageView31=findViewById(R.id.imageView31);
    ImageView imageView32=findViewById(R.id.imageView32);
    ImageView imageView33=findViewById(R.id.imageView33);
    imageView11.setImageResource(0);
    imageView12.setImageResource(0);
    imageView13.setImageResource(0);
    imageView21.setImageResource(0);
    imageView22.setImageResource(0);
    imageView23.setImageResource(0);
    imageView31.setImageResource(0);
    imageView32.setImageResource(0);
    imageView33.setImageResource(0);

    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
        {
            s[i][j]='-';
        }
    }

    player=1;
    w=false;
    d=false;
}
}, 200 );

        }
    public void replay(View view)
    { ImageView imageView11=findViewById(R.id.imageView11);
        ImageView imageView12=findViewById(R.id.imageView12);
        ImageView imageView13=findViewById(R.id.imageView13);
        ImageView imageView21=findViewById(R.id.imageView21);
        ImageView imageView22=findViewById(R.id.imageView22);
        ImageView imageView23=findViewById(R.id.imageView23);
        ImageView imageView31=findViewById(R.id.imageView31);
        ImageView imageView32=findViewById(R.id.imageView32);
        ImageView imageView33=findViewById(R.id.imageView33);
        imageView11.setImageResource(0);
        imageView12.setImageResource(0);
        imageView13.setImageResource(0);
        imageView21.setImageResource(0);
        imageView22.setImageResource(0);
        imageView23.setImageResource(0);
        imageView31.setImageResource(0);
        imageView32.setImageResource(0);
        imageView33.setImageResource(0);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                s[i][j]='-';
            }
        }

         player=1;
         w=false;
         d=false;

    }

    public boolean win(int r, int c)
    {
        if (s[r][0]!='-'&&s[r][0]==s[r][1]&&s[r][1]==s[r][2])
        {
          return true;
        }
        if (s[0][c]!='-'&&s[0][c]==s[1][c]&&s[1][c]==s[2][c])
        {
          return true;
        }
        if (s[0][0]!='-'&&s[1][1]==s[2][2]&&s[0][0]==s[1][1])
        {
          return true;
        }
         if (s[2][0]!='-'&&s[0][2]==s[1][1]&&s[1][1]==s[2][0])
        {
          return true;
        }

return false;
    }
    public void computerplay()   {int r=0;
        int c=0;
        int rc=0;
        if(!w)
        {Map<Character,Integer> rw=generaterc();
            if (rw.containsKey('o')) {
                rc=rw.get('o');
            }
            else if (rw.containsKey('x'))
            {
                rc=rw.get('x');
            }
            else
            {rc=rw.get('r');}
           r=rc/10;
           c=rc%10;
        }

       /* int r;
        int c;
        do {
            Random random=new Random();
            r=random.nextInt(3);
            c=random.nextInt(3);
        }while(s[r][c]!='-');*/
String s1="imageView"+Integer.toString((r+1)*10+(c+1));
        int  id=getResources().getIdentifier(s1,"id",this.getPackageName()) ;


        ImageView imageView=findViewById(id);

        imageView.setImageResource(R.drawable.o);
        s[r][c]='o';
        if(win(r,c))
        {
            w=true;loss++;
            Toast.makeText(this,"o wins",Toast.LENGTH_LONG).show();
        }
        player++;
    }
    public Map<Character, Integer> generaterc() {

        Map<Character,Integer>ow=new HashMap<>();
        if(di==1)
        {
            ow=easy();
        }
        else if(di==2)
        {
            ow=meduim();
           ow.putAll(easy());

        }
        else
        {
            ow=hard();
            ow.putAll(meduim());
            ow.putAll(easy());
        }


        return ow ;
    }
    public Map<Character, Integer> easy()
    { Map<Character,Integer>ow=new HashMap<>();
        for(int i=0;i<3;i++)
        {
            if (s[i][2]=='-'&&s[i][0]!='-'&&s[i][0]==s[i][1])
                ow.put(s[i][0],i*10+2);
            else if(s[i][0]=='-'&&s[i][2]!='-'&&s[i][2]==s[i][1])
                ow.put(s[i][2],i*10);
            if (s[2][i]=='-'&&s[0][i]!='-'&&s[0][i]==s[1][i])
                ow.put(s[0][i],i+20);
            else if(s[0][i]=='-'&&s[2][i]!='-'&&s[2][i]==s[1][i])
                ow.put(s[2][i],i);

            if (s[i][1]=='-'&&s[i][0]==s[i][2]&&s[i][0]!='-')
            {
                ow.put(s[i][0],  i*10+1);

            }
            if (s[1][i]=='-'&&s[0][i]==s[2][i]&&s[0][i]!='-')
            {ow.put(s[0][i],10+i);
            }
        }
        if(s[2][2]=='-'&&s[0][0]==s[1][1]&&s[0][0]!='-')
        {ow.put(s[0][0],22);

        }
        else if(s[0][0]=='-'&&s[1][1]==s[2][2]&&s[1][1]!='-')
        {ow.put(s[1][1],0);

        }
        else if(s[2][0]=='-'&&s[0][2]==s[1][1]&&s[0][2]!='-')
        {
            ow.put(s[0][2],20);

        }
        else if(s[0][2]=='-'&&s[2][0]==s[1][1]&&s[2][0]!='-')
        {ow.put(s[2][0],2);

        }
        else if(s[1][1]=='-'&&((s[2][2]==s[0][0]&&s[0][0]!='-')||(s[2][0]==s[0][2]&&s[2][0]!='-')))
        {
            ow.put('x',11);

        }
        int a;
        int b;
        do {
            Random random=new Random();
            a=random.nextInt(3);
            b=random.nextInt(3);
        }while(s[a][b]!='-');
        ow.put('r',a*10+b);

        return ow ;
    }
    public Map<Character, Integer> meduim()
    {
        Map<Character,Integer>ow=new HashMap<>();
        if (player==1&&(s[0][0]!='-'||s[0][2]!='-'||s[2][0]!='-'||s[2][2]!='-'))
        {

            ow.put('o',11);

        }
        if(player==3&&((s[0][0]==s[2][2]&&s[2][2]=='x')||s[2][0]==s[0][2]&&s[0][2]=='x'))
        {
            ow.put('o',10);
        }  return ow;
    }
    public Map<Character, Integer> hard()
    {
        Map<Character,Integer>ow=new HashMap<>();
        if (player==1&&s[1][1]=='x')
        {
            ow.put('o',0);
        }
        else if(player==3&&s[2][2]=='x')
        {
            ow.put('o',20);
        }
         return ow;
    }
}
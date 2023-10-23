package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PDB extends SQLiteOpenHelper {

    private static final String name ="pdb";
    private static final String TABLE ="person";
    private static final String COU ="NAME";
    private static final String CT ="CREATE TABLE "+TABLE +" ("+COU+" TEXT PRIMARY KEY )";
    static   SQLiteDatabase pdb;


    public PDB(@Nullable Context context) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL( CT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists "+TABLE);
        onCreate(sqLiteDatabase);
    }
    public void fetch()
    {
        pdb=getReadableDatabase();
        String getall="select * from "+TABLE;

        Cursor cursor=pdb.rawQuery(getall,null);
        if (cursor!=null)
            cursor.moveToFirst();
        pdb.close();

        while (!cursor.isAfterLast())
        {
            MainActivity2.players.add(cursor.getString(0));
            cursor.moveToNext();
        }
    }

    public void add(String name)
    {
        ContentValues row=new ContentValues();
        row.put(COU,name);

        pdb=getWritableDatabase();
        pdb.insert(TABLE,null,row);
        pdb.close();
    }

    public void delete()
    {
        pdb=getWritableDatabase();
        pdb.delete(TABLE,null,null);
        pdb.close();
    }
    public void sdelete(String name)
        {String[]g={name};
        pdb=getWritableDatabase();
        pdb.delete(TABLE,COU+"=?",g);
        pdb.close();
    }
}

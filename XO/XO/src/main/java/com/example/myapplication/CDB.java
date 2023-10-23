package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CDB extends SQLiteOpenHelper {

    private static final String name ="cdb";
    private static final String TABLE ="continue";
    private static final String COU ="c";
    private static final String CT ="CREATE TABLE "+TABLE +" ("+COU+" TEXT )";
    static SQLiteDatabase cdb;

    public CDB(@Nullable Context context) {

        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists "+TABLE);
        onCreate(sqLiteDatabase);
    }
    public void fetch()
    {
        cdb=getReadableDatabase();
        String getall="select * from "+TABLE;
        Cursor cursor=cdb.rawQuery(getall,null);
        if(cursor!=null)
        cursor.moveToFirst();
        cdb.close();


        while (!cursor.isAfterLast()) {
            if(cursor.getString(0).equals("1"))
                MainActivity3.c=true;
            else
                MainActivity3.c=false;
            cursor.moveToNext();
        }
    }
    public void add(boolean name) {
        String b;
        if(name )
           b ="1";
        else
             b="0"  ;
        ContentValues row=new ContentValues();
        row.put(COU,b);
        cdb=getWritableDatabase();
        cdb.insert(TABLE,null,row);
        cdb.close();
    }
    public void uptade(boolean c) {
        cdb=getWritableDatabase();
        ContentValues s=new ContentValues();
        if(c)
        {
            s.put(COU,"1");
        }
        else
        {
            s.put(COU,"0");
        }

         cdb.update(TABLE,s,null,null);
         cdb.close();
    }

    public void delete() {

        cdb=getWritableDatabase();
        cdb.delete(TABLE,null,null);
        cdb.close();

    }
}

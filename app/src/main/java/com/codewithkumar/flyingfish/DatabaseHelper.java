package com.codewithkumar.flyingfish;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Myscores.db";
    public static final String TABLE_NAME="Myscore";
    public static final String COL_NAME="score";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME ,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(score INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

onCreate(db);
    }
    public Cursor alldata(){

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT  MAX(score) FROM "+TABLE_NAME,null);

        return  cursor;


    }


}

package com.example.gungdeaditya.samplesqliteapps.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gungdeaditya.samplesqliteapps.utils.UserContract;

/**
 * Created by Gungde Aditya on 05/02/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1 ;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ UserContract.TABLE_NAME
            +"("+ UserContract.USER_NAME
            +" TEXT," + UserContract.USER_MOB
            +" TEXT," + UserContract.USER_EMAIL
            +" TEXT);";

    public UserDbHelper(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
        Log.e("DATABASE OPERATION","DATABASE created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","TABLE created...");
    }

    public void addInformation(String name, String mob, String email, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.USER_NAME, name);
        contentValues.put(UserContract.USER_MOB, mob);
        contentValues.put(UserContract.USER_EMAIL, email);
        db.insert(UserContract.TABLE_NAME, null, contentValues);
        Log.e("Database OPERATION","One row inserted...");
    }

    public Cursor getInformation(SQLiteDatabase db){
        Cursor cursor;
        String[] projections = {UserContract.USER_NAME, UserContract.USER_MOB,
                UserContract.USER_EMAIL};
        cursor = db.query(UserContract.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

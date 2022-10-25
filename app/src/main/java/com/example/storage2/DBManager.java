package com.example.storage2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBManager {
    private SQLiteDatabase sqlDB;
    static final String DBName="Student";
    static final String TableName="Logins";
    static final String ColUserName="UserName";
    static final String ColPassword="Password";
    static final int DBVersion=1;
    // create table Logins(ID integer primary key, auto increment, userName text, Password text)
    static final String CreateTable="CREATE TABLE IF NOT EXISTS "+TableName+
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            +ColUserName+"TEXT,"+ColPassword+"TEXT);";
    static class DatabaseHelperUser extends SQLiteOpenHelper{

        Context context;
        DatabaseHelperUser(Context context){
            super(context,DBName,null,DBVersion);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CreateTable);
            Toast.makeText(context,"Table is created",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table IF  EXISTS "+ TableName);
            onCreate(db);

        }
    }

    public DBManager(Context context){

        DatabaseHelperUser db=new DatabaseHelperUser(context);
        sqlDB=db.getWritableDatabase();
    }
}

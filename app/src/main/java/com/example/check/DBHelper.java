package com.example.check;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.jackylibrary.LogUtils;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName = "TEST_DB.db";
    public static final String TableName = "TEST_TABLE";
    public static final String TableName2 = "TEST_TABLE2";
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("DBHelper", "onCreate " + sqLiteDatabase.getVersion());
//        final String SQL = "CREATE TABLE IF NOT EXISTS "+ TableName +"( _id INTEGER PRIMARY KEY " +
//                "AUTOINCREMENT, "+"_TITLE VARCHAR(50), " +"_CONTENT TEXT, "+"_KIND VARCHAR(10)"+
//                ");";
        final String SQL = "CREATE TABLE IF NOT EXISTS "+ TableName +"( _id INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, "+"Name TEXT, age integer, sex TEXT, date DATETIME DEFAULT (datetime('now','localtime'))"+  ");";
        sqLiteDatabase.execSQL(SQL);

        final String SQL2 = "CREATE TABLE IF NOT EXISTS "+ TableName2 +"( _id INTEGER PRIMARY KEY " +
                "AUTOINCREMENT, "+"Title TEXT, price integer, date DATETIME "+  ");";
        sqLiteDatabase.execSQL(SQL2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.e("DBHelper", "onUpgrade " + sqLiteDatabase.getVersion() + " " + i + " " + i1);
        //下面會刪除db裡面所有的資料表
        Cursor cursor = sqLiteDatabase.rawQuery(
                "SELECT name FROM sqlite_master WHERE type ='table' AND name != 'sqlite_sequence'", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                sqLiteDatabase.execSQL("DROP TABLE " + cursor.getString(0));
                Log.d("123", "delete table: " + cursor.getString(0));
            }
            cursor.close();
        }
        //然後呼叫 onCreate 重新建立資料表
        onCreate(sqLiteDatabase);
    }


}

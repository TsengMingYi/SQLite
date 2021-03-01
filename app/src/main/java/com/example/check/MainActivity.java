package com.example.check;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;

import static com.example.check.DBHelper.DBName;
import static com.example.check.DBHelper.TableName;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private ArrayList<Content> arrayList = new ArrayList();
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter = new MainAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        mainAdapter.refreshUI(arrayList);
////        DBHelper2.initial(this);
        dbHelper = new DBHelper(this, DBName, null, 10);

        practice();
        // todo test add data
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("_TITLE", "Hi4");
//        //contentValues.put("_Name", "曾名藝");
////        contentValues.put("_CONTENT","Hello");
////        contentValues.put("_KIND","first");
//        dbHelper.getWritableDatabase().insert(TableName, null, contentValues);
//        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
//                "SELECT _TITLE FROM " + TableName, null);
//
////        ArrayList<A> arr = new ArrayList<>();
//
//        while(cursor.moveToNext()){
//            //Log.e("test123", "test: " + cursor.getString(0));
//            Log.e("test111","test:"+cursor.getString(cursor.getColumnIndex("_TITLE")));
//            Content content = new Content();
//            content.setName(cursor.getString(cursor.getColumnIndex("_TITLE")));
//            arrayList.add(content);
////            A a = new A();
////            a.setName(cursor.getString(0))
////            arr.add(a);
//        }
////        class A{
////            String name;
////        }
//        dbHelper.getWritableDatabase().close();
//        //dbHelper.getReadableDatabase().query(TableName);
    }

    private void practice() {
        // 插入用
//        dbHelper.getWritableDatabase().execSQL("INSERT INTO "+ TableName +
//                " ( \"Name\", \"age\" , \"sex\") VALUES ( \"王\" , 19 , \"男\" );");
//        dbHelper.getWritableDatabase().execSQL("INSERT INTO "+ TableName +
//                " ( \"Name\", \"age\" , \"sex\") VALUES ( \"王\" , 20 , \"女\" );");
//        dbHelper.getWritableDatabase().execSQL("INSERT INTO "+ TableName +
//                " ( \"Name\", \"age\" , \"sex\") VALUES ( \"陈\" , 21 , \"女\" );");
//        dbHelper.getWritableDatabase().execSQL("INSERT INTO "+ TableName +
//                " ( \"Name\", \"age\" , \"sex\") VALUES ( \"王\" , 22 , \"男\" );");

        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                "SELECT  \"Name\" , \"age\" FROM "+TableName +" WHERE age > 20;",null);
        while(cursor.moveToNext()){
            Log.e("test111","test:"+cursor.getString(0)+ " " + cursor.getInt(1));
        }


//        dbHelper.getWritableDatabase().close();
        dbHelper.getReadableDatabase().close();
    }


    private void findView() {
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        linearLayoutManager.setSmoothScrollbarEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainAdapter);
    }
}

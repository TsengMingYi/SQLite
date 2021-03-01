package com.example.check;

import android.content.Context;

import com.jackylibrary.JackyDBHelper;
import com.jackylibrary.LogUtils;
import com.jackylibrary.model.JackyApplication;
import com.jackylibrary.model.JackyEntity;

import java.util.ArrayList;

public class DBHelper2 {

    public static void initial(Context context){
        LogUtils.prepare(context);
        JackyDBHelper.registerDao(TestDao.class);
        JackyDBHelper.getDao(TestDao.class).addColumnInfosByEntity(TestEntity.class);
        JackyDBHelper.prepare(context, "hello.db",4);

        JackyDBHelper.getDao(TestDao.class).insertData(
                new String[]{"name"},
                new String[]{"Hi"});
        ArrayList<TestEntity> allData = (ArrayList<TestEntity>)JackyDBHelper.getDao(TestDao.class).queryAllData(TestEntity.class);
        LogUtils.i("DBHelper2", allData.size() + " " + allData.get(0).getName());

        ArrayList<TestEntity> searchData =
                (ArrayList<TestEntity>)JackyDBHelper.getDao(TestDao.class).queryData(
                new String[]{"name"},
                new String[]{"Hi"}, TestEntity.class);
    }
}

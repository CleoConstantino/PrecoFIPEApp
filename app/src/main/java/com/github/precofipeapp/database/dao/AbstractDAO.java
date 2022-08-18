package com.github.precofipeapp.database.dao;

import android.database.sqlite.SQLiteDatabase;

import com.github.precofipeapp.database.DBOpenHelper;

public class AbstractDAO {

    protected DBOpenHelper db_helper;
    protected SQLiteDatabase db;

    public final void Open() {

        db = db_helper.getWritableDatabase();

    }

    public final void Close() {
        db_helper.close();

    }
}

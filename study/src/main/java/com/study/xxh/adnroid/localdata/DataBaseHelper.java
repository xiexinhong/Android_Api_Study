package com.study.xxh.adnroid.localdata;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xiexinhong on 16/2/2.
 */
public class DataBaseHelper extends SQLiteOpenHelper {


    private final static String data_base_name = "local_data_test.db";
    private final static int mCurrentVersion = 2;

    public DataBaseHelper(Context context) {
        super(context,data_base_name, null, mCurrentVersion);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS person (id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(50),age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion && newVersion == mCurrentVersion) {
            db.execSQL("ALTER TABLE person ADD phone VARCHAR(12) NULL");
        }
    }
}

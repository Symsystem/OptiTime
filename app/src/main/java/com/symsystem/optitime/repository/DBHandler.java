package com.symsystem.optitime.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.symsystem.optitime.exception.FailureException;

/**
 * @author sym
 */

public final class DBHandler extends SQLiteOpenHelper {

    private static DBHandler db = null;

    private static final String DATABASE_NAME = "NAME";
    private static final int DATABASE_VERSION = 1;

    private DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DBHandler getDBHandler(Context context) {
        if (db == null) {
            db = new DBHandler(context);
        }
        return db;
    }

    public static DBHandler getDBHandler() {
        if (db == null) {
            throw new FailureException("Try to get DBHandler that is not yet initialized");
        }
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

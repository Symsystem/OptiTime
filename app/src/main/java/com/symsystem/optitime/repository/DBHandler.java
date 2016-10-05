package com.symsystem.optitime.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.symsystem.optitime.R;
import com.symsystem.optitime.exception.FailureException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author sym
 */

public final class DBHandler extends SQLiteOpenHelper {

    private static DBHandler db = null;

    private static final String DATABASE_NAME = "NAME";
    private static final int DATABASE_VERSION = 1;

    private final Context context;

    private DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static DBHandler getDBHandler(Context context) {
        if (db == null) {
            db = new DBHandler(context);
        }
        return db;
    }

    public static DBHandler getDBHandler() {
        if (db == null) {
            throw new FailureException("Try to get DBHandler that is not yet " +
                    "initialized");
        }
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Open the resource
        InputStream insertsStream =
                context.getResources().openRawResource(
                        context.getResources().getIdentifier(
                                "create", "raw", context.getPackageName()));
        BufferedReader insertReader = new BufferedReader(
                new InputStreamReader(insertsStream));

// Iterate through lines (assuming each insert has its own line and theres no
// other stuff)
        String insertStmt = "";
        int result = 0;
        try {
            while (insertReader.ready()) {
                insertStmt += insertReader.readLine();
                result++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            insertReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db.execSQL(insertStmt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Plus tard :)

    }
}

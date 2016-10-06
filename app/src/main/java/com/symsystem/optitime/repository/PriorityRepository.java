package com.symsystem.optitime.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.symsystem.optitime.common.IdentityGenerator;
import com.symsystem.optitime.domain.location.LocationId;
import com.symsystem.optitime.domain.priority.Priority;
import com.symsystem.optitime.domain.priority.PriorityId;
import com.symsystem.optitime.domain.task.Duration;
import com.symsystem.optitime.domain.template.Template;
import com.symsystem.optitime.domain.template.TemplateId;

/**
 * @author pie :)
 */

public final class PriorityRepository implements Repository<Priority, PriorityId> {

    private static final String CODE = "PRI";
    private static String TABLE_NAME = "PRIORITY";
    private final DBHandler db;

    public PriorityRepository() {
        this.db = DBHandler.getDBHandler();
    }

    @Override
    public String nextIdentity() {

        return IdentityGenerator.getInstance().newIdentity(CODE);
    }

    @Override
    public void save(Priority entity) {

        // Gets the data repository in write mode
        SQLiteDatabase dataBase = db.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("ID", entity.id().id());
        values.put("PRIORITY", entity.name());


        if (exists(entity.id())) {
            dataBase.update(TABLE_NAME, values, "ID = ?",
                    new String[]{entity.id().id()});
        }
        // Insert the new row, returning the primary key value of the new row
        else {
            dataBase.insert(TABLE_NAME, null, values);
        }

        dataBase.close();
    }

    @Override
    public boolean exists(PriorityId entity) {
        // Gets the data repository in write mode
        SQLiteDatabase dataBase = db.getReadableDatabase();
        Cursor cursor = dataBase.rawQuery(String.format("SELECT ID FROM PRIORITY " +
                "where id = %s", entity.id()), null);

        return cursor.getCount() == 1;

    }

    @Override
    public Priority find(PriorityId id) {
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT ID FROM ? where id = ?",
                new String[]{TABLE_NAME, id.id()});

        if (cursor.getCount() == 1) {
            Priority priority = new Priority(id, cursor.getString(1));


            return priority;
        }
        return null;
    }

}

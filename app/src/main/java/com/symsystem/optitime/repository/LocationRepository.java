package com.symsystem.optitime.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.symsystem.optitime.domain.location.Location;
import com.symsystem.optitime.domain.location.LocationId;
import com.symsystem.optitime.domain.priority.Priority;
import com.symsystem.optitime.domain.priority.PriorityId;

/**
 * @author sym
 */

public final class LocationRepository implements Repository<Location, LocationId> {

    private final DBHandler db;

    private static String TABLE_NAME = "Location" ;

    public LocationRepository() {
        this.db = DBHandler.getDBHandler();
    }

    @Override
    public void save(Location entity) {

        // Gets the data repository in write mode
        SQLiteDatabase dataBase = db.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("ID", entity.locationId().id());
        values.put("NAME", entity.getName());


        if (exists(entity.locationId())) {
            dataBase.update(TABLE_NAME, values, "ID = ?",
                    new String[]{entity.locationId().id()}) ;
        }
        // Insert the new row, returning the primary key value of the new row
        else {
            dataBase.insert(TABLE_NAME, null, values);
        }

        dataBase.close();
    }

    @Override
    public boolean exists(LocationId entity) {
        // Gets the data repository in write mode
        SQLiteDatabase dataBase = db.getReadableDatabase();
        Cursor cursor = dataBase.rawQuery(String.format("SELEC ID FROM Location " +
                "where id = %s", entity.id()) , null);

        return cursor.getCount() == 1;

    }

    @Override
    public Location find(LocationId id) {
        return null;
    }
}
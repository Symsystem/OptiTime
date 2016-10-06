package com.symsystem.optitime.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.symsystem.optitime.common.IdentityGenerator;
import com.symsystem.optitime.domain.State;
import com.symsystem.optitime.domain.location.LocationId;
import com.symsystem.optitime.domain.priority.PriorityId;
import com.symsystem.optitime.domain.task.Date;
import com.symsystem.optitime.domain.task.Duration;
import com.symsystem.optitime.domain.task.Task;

import com.symsystem.optitime.domain.template.Template;
import com.symsystem.optitime.domain.template.TemplateId;

import java.util.Calendar;

import static java.lang.Math.round;

/**
 * @author sym
 */

public final class TemplateRepository implements Repository<Template, TemplateId> {

    private static final String CODE = "TEM";
    private static String TABLE_NAME = "Template" ;
    private final DBHandler db;

    public TemplateRepository() {
        this.db = DBHandler.getDBHandler();
    }

    @Override
    public String nextIdentity() {
        return IdentityGenerator.getInstance().newIdentity(CODE);
    }

    @Override
    public void save(Template entity) {

        // Gets the data repository in write mode
        SQLiteDatabase dataBase = db.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("ID", entity.templateId().id());
        values.put("NAME", entity.name());


        if (entity.duration() != null) {
            values.put("DURATION", entity.duration().getHours()*60 +
                    entity.duration().getMin());
        }

        if (entity.priority() != null) {
            values.put("PRIORITY", entity.priority().id());
        }


        if (entity.location() != null){
            values.put("PRIORITY", entity.location().id());}


        if (exists(entity.templateId())) {
            dataBase.update(TABLE_NAME, values, "ID = ?",
                    new String[]{entity.templateId().id()}) ;
        }
        // Insert the new row, returning the primary key value of the new row
        else {
            dataBase.insert(TABLE_NAME, null, values);
        }

        dataBase.close();
    }

    @Override
    public boolean exists(TemplateId entity) {
        // Gets the data repository in write mode
        SQLiteDatabase dataBase = db.getReadableDatabase();
        Cursor cursor = dataBase.rawQuery(String.format("SELECT ID FROM Template " +
                "where id = %s", entity.id()) , null);

        return cursor.getCount() == 1;

    }

    @Override
    public Template find(TemplateId id) {

        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT ID FROM ? where id = ?",
                new String[]{TABLE_NAME, id.id()});

        if (cursor.getCount() == 1) {
            Template template = new Template(id, cursor.getString(1));


            if (!cursor.isNull(cursor.getColumnIndex("DURATION"))) {
                int duration = Integer.parseInt(cursor.getString(2));
                template.setDuration(new Duration(duration % 60, duration / 60));
            }

            if (!cursor.isNull(cursor.getColumnIndex("PRIORITY"))) {
                template.priority(new PriorityId(
                        cursor.getString(cursor.getColumnIndex("PRIORITY"))));
            }

            if (!cursor.isNull(cursor.getColumnIndex("LOCATION"))) {
                template.setLocation(new LocationId(
                        cursor.getString(cursor.getColumnIndex("LOCATION"))));
            }

            return template;
        }
        return null;
    }
}

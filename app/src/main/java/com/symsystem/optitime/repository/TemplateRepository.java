package com.symsystem.optitime.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.symsystem.optitime.domain.task.Task;

import com.symsystem.optitime.domain.template.Template;
import com.symsystem.optitime.domain.template.TemplateId;

/**
 * @author sym
 */

public final class TemplateRepository implements Repository<Template, TemplateId> {

    private final DBHandler db;

    private static String TABLE_NAME = "Template" ;

    public TemplateRepository() {
        this.db = DBHandler.getDBHandler();
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
        Cursor cursor = dataBase.rawQuery(String.format("SELEC ID FROM Template " +
                "where id = %s", entity.id()) , null);

        return cursor.getCount() == 1;

    }

    @Override
    public Template find(TemplateId id) {
        return null;
    }
}

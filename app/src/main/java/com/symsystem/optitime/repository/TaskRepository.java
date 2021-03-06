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
import com.symsystem.optitime.domain.task.TaskId;

import java.util.Calendar;

/**
 * A TaskRepository represents the adapter communicating with the SQLite
 * database.
 *
 * @author sym
 */

public final class TaskRepository implements Repository<Task, TaskId> {

    private static TaskRepository taskRepository = null;
    private static final String TABLE_NAME = "Task" ;
    private static final String CODE = "TAS";

    private final DBHandler db;

    private TaskRepository() {
        this.db = DBHandler.getDBHandler();
    }

    public static TaskRepository getInstance() {
        if (taskRepository == null) {
            taskRepository = new TaskRepository();
        }
        return taskRepository;
    }

    @Override
    public String nextIdentity() {
        return IdentityGenerator.getInstance().newIdentity(CODE);
    }

    @Override
    public void save(Task task) {

        SQLiteDatabase database = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ID", task.id().id());
        values.put("NAME", task.name());
        values.put("STATE", task.state().ordinal());

        if (task.limitDate() != null) {
            values.put("LIMIT_DATE", task.limitDate().date());
        }

        if (task.duration() != null) {
            values.put("DURATION",
                    task.duration().getHours() * 60
                            + task.duration().getMin());
        }

        if (task.priority() != null) {
            values.put("PRIORITY", task.priority().id());
        }

        if (task.location() != null){
            values.put("LOCATION", task.location().id());}

        if (exists(task.id())) {
            database.update(TABLE_NAME, values, "ID = ?",
                    new String[]{task.id().id()}) ;
        } else {
            database.insert(TABLE_NAME, null, values);
        }

        database.close();
    }

    @Override
    public boolean exists(TaskId id) {
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT ID FROM ? where id = ?",
                new String[]{TABLE_NAME, id.id()});

        cursor.close();
        return cursor.getCount() == 1;
    }

    @Override
    public Task find(TaskId id) {

        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT ID FROM ? where id = ?",
                new String[]{TABLE_NAME, id.id()});

        if (cursor.getCount() == 1) {
            Task task = new Task(id, cursor.getString(1));
            task.setState(State.values()[cursor.getInt(2)]);

            if (!cursor.isNull(cursor.getColumnIndex("LIMIT_DATE"))) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(cursor.getLong(
                        cursor.getColumnIndex("LIMIT_DATE")));
                task.setlimiteDate(new Date(cal));
            }

            if (!cursor.isNull(cursor.getColumnIndex("DURATION"))) {
                int duration = cursor.getInt(cursor.getColumnIndex("DURATION"));
                task.setDuration(new Duration(duration % 60, duration / 60));
            }

            if (!cursor.isNull(cursor.getColumnIndex("PRIORITY"))) {
                task.setPriority(new PriorityId(
                        cursor.getString(cursor.getColumnIndex("PRIORITY"))));
            }

            if (!cursor.isNull(cursor.getColumnIndex("LOCATION"))) {
                task.setLocation(new LocationId(
                        cursor.getString(cursor.getColumnIndex("LOCATION"))));
            }

            return task;
        }
        return null;
    }
}

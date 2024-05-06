package com.example.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

class DatabaseTables {
    public SQLiteDatabase database;
    public DatabaseHelper databaseHelper;

    static class Mountain {

        static final String TABLE_NAME = "mountain";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_HEIGHT = "height";

        public Mountain(long aLong, String string, int anInt) {

        }
    }

    static final String SQL_CREATE_TABLE_MOUNTAIN =
            // "CREATE TABLE mountain (id INTEGER PRIMARY KEY, name TEXT, height INT)"
            "CREATE TABLE " + Mountain.TABLE_NAME + " (" +
                    Mountain.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    Mountain.COLUMN_NAME_NAME + " TEXT," +
                    Mountain.COLUMN_NAME_HEIGHT + " INT)";

    static final String SQL_DELETE_TABLE_MOUNTAIN =
            // "DROP TABLE IF EXISTS mountain"
            "DROP TABLE IF EXISTS " + Mountain.TABLE_NAME;

    public List<Mountain> getMountains() {
        Cursor cursor = database.query(DatabaseTables.Mountain.TABLE_NAME, null, null, null, null, null, null);
        List<Mountain> mountains = new ArrayList<>();
        while (cursor.moveToNext()) {
            Mountain mountain = new Mountain(
                    cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseTables.Mountain.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Mountain.COLUMN_NAME_NAME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTables.Mountain.COLUMN_NAME_HEIGHT))
            );
            mountains.add(mountain);
        }
        cursor.close();
        return mountains;
    }

    public int deleteMountain(long id) {
        String selection = DatabaseTables.Mountain.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        return database.delete(DatabaseTables.Mountain.TABLE_NAME, selection, selectionArgs);
    }
    public long addMountain(String name, int height) {
        Log.d("asdasdasdasd","It calls");
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Mountain.COLUMN_NAME_NAME, name);
        values.put(DatabaseTables.Mountain.COLUMN_NAME_HEIGHT, height);
        Log.d("asdasdasdasd",""+values);
        return database.insert(DatabaseTables.Mountain.TABLE_NAME, null, values);
    }



}
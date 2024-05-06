package com.example.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

class DatabaseTables {
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

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

    private List<Mountain> getMountains() {
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

    private int deleteMountain(long id) {
        String selection = DatabaseTables.Mountain.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        return database.delete(DatabaseTables.Mountain.TABLE_NAME, selection, selectionArgs);
    }
    private long addMountain(String name, int height) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Mountain.COLUMN_NAME_NAME, name);
        values.put(DatabaseTables.Mountain.COLUMN_NAME_HEIGHT, height);
        return database.insert(DatabaseTables.Mountain.TABLE_NAME, null, values);
    }



}
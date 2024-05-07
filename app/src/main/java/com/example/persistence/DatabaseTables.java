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

    static class Icecream {

        static final String TABLE_NAME = "icecream";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_FOBONE = "fobone";
        static final String COLUMN_NAME_FOBTWO = "fobtwo";
        static final String COLUMN_NAME_FOBTHREE = "fobthree";
        static final String COLUMN_NAME_SIZE = "size";
        public final long id;
        public final String fob1;
        public final String fob2;
        public final String fob3;
        public final int size;


        public Icecream(long id, String fob1, String fob2, String fob3, int size) {
            this.id = id;
            this.fob1 = fob1;
            this.fob2 = fob2;
            this.fob3 = fob3;
            this.size = size;
        }
    }

    static final String SQL_CREATE_TABLE_MOUNTAIN =
            // "CREATE TABLE mountain (id INTEGER PRIMARY KEY, name TEXT, height INT)"
            "CREATE TABLE " + Icecream.TABLE_NAME + " (" +
                    Icecream.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    Icecream.COLUMN_NAME_FOBONE + " TEXT," +
                    Icecream.COLUMN_NAME_FOBTWO + " TEXT," +
                    Icecream.COLUMN_NAME_FOBTHREE + " TEXT," +
                    Icecream.COLUMN_NAME_SIZE + " INT)";

    static final String SQL_DELETE_TABLE_MOUNTAIN =
            // "DROP TABLE IF EXISTS mountain"
            "DROP TABLE IF EXISTS " + Icecream.TABLE_NAME;

    public List<Icecream> getIcecreams() {
        Cursor cursor = database.query(DatabaseTables.Icecream.TABLE_NAME, null, null, null, null, null, null);
        List<Icecream> mountains = new ArrayList<>();
        while (cursor.moveToNext()) {
            Icecream mountain = new Icecream(
                    cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseTables.Icecream.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Icecream.COLUMN_NAME_FOBONE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Icecream.COLUMN_NAME_FOBTWO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Icecream.COLUMN_NAME_FOBTHREE)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTables.Icecream.COLUMN_NAME_SIZE))
            );
            mountains.add(mountain);
        }
        cursor.close();
        return mountains;
    }

    public int deletIceream(long id) {
        String selection = DatabaseTables.Icecream.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        return database.delete(DatabaseTables.Icecream.TABLE_NAME, selection, selectionArgs);
    }
    public long addIcecream(String fob1,String fob2,String fob3, int size) {

        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Icecream.COLUMN_NAME_FOBONE, fob1);
        values.put(DatabaseTables.Icecream.COLUMN_NAME_FOBTWO, fob2);
        values.put(DatabaseTables.Icecream.COLUMN_NAME_FOBTHREE, fob3);
        values.put(DatabaseTables.Icecream.COLUMN_NAME_SIZE, size);


        return database.insert(DatabaseTables.Icecream.TABLE_NAME, null, values);
    }



}
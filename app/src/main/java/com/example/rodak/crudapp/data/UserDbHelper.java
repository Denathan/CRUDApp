package com.example.rodak.crudapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rodak.crudapp.data.UserContract.UserEntry;

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "usersDb.db";

    private static final int DATABASE_VERSION = 1;

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_BOOKS_TABLE = "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + UserEntry.COLUMN_USERNAME + " TEXT NOT NULL UNIQUE, "
                + UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL, "
                + UserEntry.COLUMN_FIRST_NAME + " TEXT, "
                + UserEntry.COLUMN_LAST_NAME + " TEXT, "
                + UserEntry.COLUMN_PICTURE + " BLOB, "
                + UserEntry.COLUMN_AGE + " INTEGER DEFAULT 0, "
                + UserEntry.COLUMN_DATE + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

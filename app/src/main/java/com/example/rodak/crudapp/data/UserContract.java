package com.example.rodak.crudapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class UserContract {

    private UserContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.rodak.crudapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_USERS = "users";

    public static final class UserEntry implements BaseColumns {

        public final static String TABLE_NAME = "users";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_USERNAME = "username";
        public final static String COLUMN_PASSWORD = "password";
        public final static String COLUMN_FIRST_NAME = "firstname";
        public final static String COLUMN_LAST_NAME = "lastname";
        public static final String COLUMN_PICTURE = "picture";
        public final static String COLUMN_AGE = "age";
        public final static String COLUMN_DATE = "date";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_USERS);
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USERS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USERS;
    }

}

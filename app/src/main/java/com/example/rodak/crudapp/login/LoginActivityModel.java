package com.example.rodak.crudapp.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.Toast;

import com.example.rodak.crudapp.data.UserContract.UserEntry;
import com.example.rodak.crudapp.data.UserDbHelper;
import com.example.rodak.crudapp.root.App;
import com.example.rodak.crudapp.root.ApplicationModule;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivityModel extends AppCompatActivity implements LoginActivityMVP.Model {

    private LoginRepository repository;
    private ApplicationModule applicationModule;
    private Uri currentUserUri;
    private UserDbHelper mDbHelper;

    public LoginActivityModel(LoginRepository repository) {
        this.repository = repository;
    }

    /**TODO: create two methods, one method to check correct input when trying to log in
     * TODO: and one more to add or update user*/

    /**
     * {@link LoginActivityMVP.Model#sendUserToDb(String, String, Uri)} is only for first tests
     */
    @Override
    public void sendUserToDb(String username, String password, Uri currentUserUri) {
        ContentValues values = new ContentValues();

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        values.put(UserEntry.COLUMN_USERNAME, username);
        values.put(UserEntry.COLUMN_PASSWORD, password);
        values.put(UserEntry.COLUMN_DATE, date);

        db.insert(UserEntry.TABLE_NAME, null, values);
//        if (currentUserUri != null) {
//            getSupportLoaderManager().initLoader(0, null, this);
//        }
//
//        Uri newUri = applicationModule.provideContext().getContentResolver().insert(UserEntry.CONTENT_URI, values);
//        if (newUri == null) {
//            Toast.makeText(applicationModule.provideContext(), "failed",
//                    Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(applicationModule.provideContext(), "succeed",
//                    Toast.LENGTH_SHORT).show();
//        }
    }

    private String imageToBlob(Context context, Bitmap bitmap, int resourceId) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
        byte[] byte_arr = stream.toByteArray();
        return Base64.encodeToString(byte_arr, Base64.DEFAULT);
    }

//    @NonNull
//    @Override
//    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
//        String[] projection = {
//                UserEntry._ID,
//                UserEntry.COLUMN_USERNAME,
//                UserEntry.COLUMN_FIRST_NAME,
//                UserEntry.COLUMN_LAST_NAME,
//                UserEntry.COLUMN_PICTURE,
//                UserEntry.COLUMN_AGE,
//                UserEntry.COLUMN_DATE};
//
//        return new CursorLoader(applicationModule.provideContext(),
//                currentUserUri,
//                projection,
//                null,
//                null,
//                null);
//    }
//
//    @Override
//    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
//
//    }
//
//    @Override
//    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
//
//    }
}

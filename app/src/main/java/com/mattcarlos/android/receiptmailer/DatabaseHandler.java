package com.mattcarlos.android.receiptmailer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "emailManager";

    // Email table name
    private static final String TABLE_EMAIL = "emailAddress";

    // email Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "email";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EMAIL_TABLE = "CREATE TABLE " + TABLE_EMAIL + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_EMAIL_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMAIL);
 
        // Create tables again
        onCreate(db);
    }
    
    // Adding new email
    public void addEmailAddress(EmailAddress email) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, email.getEmail()); // Email Name
     
        // Inserting Row
        db.insert(TABLE_EMAIL, null, values);
        db.close(); // Closing database connection
    }
    
    public EmailAddress getEmail() {
        SQLiteDatabase db = this.getReadableDatabase();
     
        Cursor cursor = db.rawQuery("SELECT * FROM emailAddress", null);
        if (cursor != null)
            cursor.moveToFirst();
        EmailAddress email = new EmailAddress(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        // return email
        return email;
    }
    
    public void deleteContact(EmailAddress email) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMAIL, KEY_ID + " = ?",
                new String[] { String.valueOf(email.getID()) });
        db.close();
    } 
    
    public int updateEmail(EmailAddress email) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, email.getEmail());
     
        // updating row
        return db.update(TABLE_EMAIL, values, KEY_ID + " = ?",
                new String[] { String.valueOf(email.getID()) });
    }
}

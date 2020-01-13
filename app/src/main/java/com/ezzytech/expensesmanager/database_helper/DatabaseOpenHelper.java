package com.ezzytech.expensesmanager.database_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "ExpenseManager.db";
    public static int VERSION = 1;
    public static  String TABLE_NAME = "Expense Manager";
    public static String COL_ID = "Id";
    public static String COL_Input = "Input";
    public static String COL_Category = "Purpose";
    public static String COL_Amount = "Amount";
    public static String COL_DATE = "Date";
    public static String COL_TIME = "Time";
    public static String COL_BalanceType = "BalanceType";
    public static String COL_Note = "Note";

    private SQLiteDatabase database;

    public static String create_Table = " create table "+TABLE_NAME+ " (Id integer primary key,Input text, Purpose text, Amount text, Date text, Tome text, BalanceType text, Note text)";


    public DatabaseOpenHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    public void openDatabase() {database = getWritableDatabase();}

    public void closeDatabase () {database = getReadableDatabase();}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(String input, String category, String amount, String date, String time, String type, String note){
        openDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_Input,input);
        values.put(COL_Category,category);
        values.put(COL_Amount,amount);
        values.put(COL_DATE,date);
        values.put(COL_TIME,time);
        values.put(COL_BalanceType,type);
        values.put(COL_Note,note);

        long id = database.insert(TABLE_NAME,null,values);
        closeDatabase();
        return id;
    }

    public Cursor getData(){
        openDatabase();
        String data ="Select * From "+TABLE_NAME;
        Cursor cursor = database.rawQuery(data,null);
        return cursor;
    }

    public void deleteData (){
        getWritableDatabase().delete(TABLE_NAME,"Id=?",new String[]{String.valueOf(id)});
    }
}

package com.health.healthapp.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.health.healthapp.main.note_model;

import java.util.ArrayList;


public    class DatabaseHelper {
        myDbHelper myhelper;
        public DatabaseHelper(Context context)
        {
            myhelper = new myDbHelper(context);
        }

        public long insertData(note_model note)
        {
            final String Notes = "CREATE TABLE NOTES(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "CATEGORY VARCHAR(255),SUBCATEGORY VARCHAR(255)," +
                    "NAME VARCHAR(225),VALUE VARCHAR(225), DATE VARCHAR(20)," +
                    "TIME VARCHAR(10), STATUS VARCHAR(2), NOTE VARCHAR(250));";
            SQLiteDatabase dbb = myhelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("CATEGORY", note.getCategory());
            contentValues.put("SUBCATEGORY", note.getSubcategory());
            contentValues.put("NAME", note.getName());
            contentValues.put("VALUE", note.getValue());
            contentValues.put("DATE",note.getDate());
            contentValues.put("TIME", note.getTime());
            contentValues.put("STATUS", note.getStatus());
            contentValues.put("NOTE", note.getNote());
            long id = dbb.insert("NOTES", null , contentValues);
            return id;
        }

        public ArrayList<note_model> getData()
        {
            ArrayList<note_model> list=new ArrayList<>();
            SQLiteDatabase db = myhelper.getWritableDatabase();
            String[] columns = {"ID","CATEGORY","SUBCATEGORY","NAME","VALUE","DATE","TIME", "STATUS","NOTE"};
            Cursor cursor =db.query("NOTES",columns,null,null,null,null,null);
            StringBuffer buffer= new StringBuffer();
             note_model note;
            while (cursor.moveToNext())
            {          note=new note_model();
                       note.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                       note.setCategory(cursor.getString(cursor.getColumnIndex("CATEGORY")));
                       note.setSubcategory(cursor.getString(cursor.getColumnIndex("SUBCATEGORY")));
                       note.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                       note.setTime(cursor.getString(cursor.getColumnIndex("TIME")));
                       note.setDate(cursor.getString(cursor.getColumnIndex("DATE")));
                       note.setStatus(cursor.getString(cursor.getColumnIndex("STATUS")));
                       note.setValue(cursor.getString(cursor.getColumnIndex("VALUE")));
                 list.add(note);
            }
            return list;
        }
/*
        public  int delete(String uname)
        {
            SQLiteDatabase db = myhelper.getWritableDatabase();
            String[] whereArgs ={uname};

            int count =db.delete(myDbHelper.TABLE_NAME ,myDbHelper.NAME+" = ?",whereArgs);
            return  count;
        }

        public int updateName(String oldName , String newName)
        {
            SQLiteDatabase db = myhelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(myDbHelper.NAME,newName);
            String[] whereArgs= {oldName};
            int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" = ?",whereArgs );
            return count;
        }
*/
        static class myDbHelper extends SQLiteOpenHelper
        {
            private static final String DATABASE_NAME = "Health";    // DatabaseHelper Name
            private static final int DATABASE_Version = 1;    // DatabaseHelper Version
            //Tables
            //People
                final String People = "CREATE TABLE PEOPLE(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " GROUPS VARCHAR(100) ,NAME VARCHAR(225),EMAIL VARCHAR(225));";
                //GROUP
                final String Groups = "CREATE TABLE  GROUPS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(255));";
                //REMINDER

                final String Reminder = "CREATE TABLE REMINDER( ID INTEGER PRIMARY KEY AUTOINCREMENT, CATEGORY VARCHAR(255) ,NAME VARCHAR(225)," +
                        "   STATUS VARCHAR(2), FREQUENCY VARCHAR(255),STARTDATE VARCHAR(20), ENDDATE VARCHAR(20),TIME VARCHAR(10) );";


                //NOTES
                final String Notes = "CREATE TABLE NOTES(ID INTEGER PRIMARY KEY AUTOINCREMENT, CATEGORY VARCHAR(255),SUBCATEGORY VARCHAR(255)," +
                        "NAME VARCHAR(225),VALUE VARCHAR(225), DATE VARCHAR(20),TIME VARCHAR(10), STATUS VARCHAR(2), NOTE VARCHAR(250));";
                // SUBCATEGORIES
                final String SubCategories = "CREATE TABLE SUBCATEGORIES(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " CATEGORY VARCHAR(100) ,NAME VARCHAR(225),POPULAR VARCHAR(225), USED VARCHAR(10));";



                final String DROP_TABLE_1="DROP TABLE IF EXISTS PEOPLE";
                final String DROP_TABLE_2="DROP TABLE IF EXISTS GROUPS";
                final String DROP_TABLE_3="DROP TABLE IF EXISTS REMINDER";
                final String DROP_TABLE_4="DROP TABLE IF EXISTS NOTES";
                final String DROP_TABLE_5="DROP TABLE IF EXISTS SUBCATEGORIES";



            private Context context;

            public myDbHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_Version);
                this.context=context;
            }

            public void onCreate(SQLiteDatabase db) {

                try {
                    db.execSQL(People);
                    db.execSQL(Groups);
                    db.execSQL(Reminder);
                    db.execSQL(Notes);
                    db.execSQL(SubCategories);
                } catch (Exception e) {

                }
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                try {

                    db.execSQL(DROP_TABLE_1);
                    db.execSQL(DROP_TABLE_2);
                    db.execSQL(DROP_TABLE_3);
                    db.execSQL(DROP_TABLE_4);
                    db.execSQL(DROP_TABLE_5);
                    onCreate(db);
                }catch (Exception e) {

                }
            }
        }
    }


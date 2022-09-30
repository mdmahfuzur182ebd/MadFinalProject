package com.example.finalprojectapp;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MediMartDbHelper extends SQLiteOpenHelper {
   public  MediMartDbHelper(@Nullable Context context){
       super(context, "medimart.db", null, 1);
   }

   public void  onCreate(SQLiteDatabase db){
       db.execSQL("CREATE TABLE IF NOT EXISTS user(_id integer primary key autoincrement,"+
               "userid varchar(100), pwd varchar(30), role varchar(20))");

       db.execSQL("CREATE TABLE IF NOT EXISTS customers(_id integer primary key autoincrement,"+
               "userid varchar(100), city varchar(100), gender varchar(20)," + "email varchar(100), phone varchar(20))");

       db.execSQL("CREATE TABLE IF NOT EXISTS cart(_id integer primary key autoincrement,"+
               "userid varchar(100), product varchar(100), role varchar(20),qty int)");

       db.execSQL("CREATE TABLE IF NOT EXISTS orders(_id int primary key, "+
               "userid varchar(100), orderdate date, status varchar(20), total int)");

       db.execSQL("INSERT INTO users(userid,pwd,role)"+ "VALUES ('admin', 'admin', 'admin')");
   }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addCustomer(String cname, String city, String gender, String email, String phone, String pwd){
       SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cname", cname);
        cv.put("city", city);
        cv.put("gender", gender);
        cv.put("email", email);
        cv.put("phone ", phone);
        db.insert("customers", null, cv);
        ContentValues cv2 = new ContentValues();
        cv2.put("userid", phone);
        cv2.put("pwd", pwd);
        cv2.put("role", "customer");
        db.insert("users", null,cv2);
    }

    public  Cursor getCustomer (String userid){
       SQLiteDatabase db = getReadableDatabase();
       Cursor c =db.rawQuery("SELECT * FROM customers WHERE phone=?", new String[]{userid});
       return c;
    }


}

package com.example.pt_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class mySQLite extends SQLiteOpenHelper {

    public  static  final String  nonOB= "data.db";
    public  static  final  int versionDB= 1;
    public mySQLite(Context context){
        super(context,nonOB,null,versionDB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table vetements (id INTEGER PRIMARY KEY  AUTOINCREMENT ," +
                "Article TEXT ," +
                "Prix TEXT)");
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS vetements ");
//        DROP TABLE IF EXISTS your_table_name;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL( "DROP TABLE IF EXISTS vetements");
        this.onCreate(db);
    }
    @SuppressLint("Range")
    public ArrayList getvetements(){
        ArrayList<String> liste = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from vetements",null);
        cs.moveToFirst();
        //On boucle sur les resultats
        while (cs.isAfterLast() == false) {
            String n, p, f;
            n = cs.getString(cs.getColumnIndex("Article"));
            p = cs.getString(cs.getColumnIndex("Prix"));
            liste.add(n +"  -  "+ p);
            cs.moveToNext();
        } cs.close();
        return liste;
    }
    public Boolean Ajouter(String Article, String Prix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Article", Article);
        cv.put("Prix", Prix);
        //execution de la requête d'ajout
        if (db.insert("vetements", null, cv) == -1)
            return false;
        else
            return  true;

    }
    public  int get_count(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM vetements",null);
        return cursor.getCount();
    }
    @SuppressLint("Range")
    public ArrayList Recharche(String value){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from vetements where Article like ?",new String[]{"%"+value+"%"});
        ArrayList<String> liste = new ArrayList();
        cs.moveToFirst();
        //On boucle sur les resultats
        while (cs.isAfterLast() == false) {
            String n, p;
            n = cs.getString(cs.getColumnIndex("Article"));
            p = cs.getString(cs.getColumnIndex("Prix"));
            liste.add(n +"  -  "+ p);
            cs.moveToNext();
        }
        cs.close();
        return liste;
    }

    @SuppressLint("Range")
    public ArrayList modification(int value ,String value1){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("UPDATE vetements SET Article= 'value1' WHERE id = 'value'",null);

        ArrayList<String> liste = new ArrayList();
        cs.moveToFirst();
        //On boucle sur les resultats
        while (cs.isAfterLast() == false) {
            String n, p;
            n = cs.getString(cs.getColumnIndex("Article"));
            p = cs.getString(cs.getColumnIndex("Prix"));
            liste.add(n +"  -  "+ p);
            cs.moveToNext();
        }
        cs.close();
        return liste;
    }
//
}

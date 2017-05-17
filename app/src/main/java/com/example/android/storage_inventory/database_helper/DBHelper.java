package com.example.android.storage_inventory.database_helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lenovo on 5/17/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    /**deklarasi konstanta2 yang digunakan pada database spt
     * nama2 kolom,nama database, dan versi dari database **/
    public static final String TABLE_NAME= "data_inventori_barang";
    public static final String COLUMN_ID= "_id";
    public static final String COLUMN_NAME= "nama_barang";
    public static final String COLUMN_MERK= "merk_barang";
    public static final String COLUMN_HARGA= "harga_barang";
    public static final String db_name= "inventori.db";
    public static final int db_version = 1;

    //Perintah SQL utk membuat tabel database baru
    private static final String db_create = "create table"
            + TABLE_NAME + "("
            +COLUMN_ID+ "integer primary key auto increment,"
            +COLUMN_NAME+ "varchar(50) not null,"
            +COLUMN_MERK+ "varchar(50) not null,"
            +COLUMN_HARGA+ "varchar(50) not null);";

    public DBHelper(Context context){
        super(context,db_name,null,db_version);
        //Auto generated
    }
    //utk mengeksekusi perintah SQL diatas utk membuat tabel database baru
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(db_create);
    }
    //dieksekusi apabila ingin mengupgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(DBHelper.class.getName(),"Upgrading database from version" + oldVersion + "to"
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}

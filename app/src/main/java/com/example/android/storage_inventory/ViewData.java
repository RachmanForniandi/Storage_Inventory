package com.example.android.storage_inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.android.storage_inventory.controller.DBDataSource;
import com.example.android.storage_inventory.model.Barang;

import java.util.ArrayList;

public class ViewData extends ListActivity {
    //inisialisasi kontroller
    private DBDataSource dataSource;

    //inisialisasi arraylist
    private ArrayList<Barang>values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdata);
        dataSource =new DBDataSource(this);

        //buka kontroller
        dataSource.open();

        //ambil semua data barang
        values = dataSource.getAllBarang();

        //masukan data barang ke array adapter
        ArrayAdapter<Barang>adapter = new ArrayAdapter<Barang>(this,
                android.R.layout.simple_list_item_1,values);

        //set adapter pada list
        setListAdapter(adapter);
    }
}

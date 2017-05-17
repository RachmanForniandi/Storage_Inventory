package com.example.android.storage_inventory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends Activity implements View.OnClickListener {
    private Button bTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        bTambah = (Button)findViewById(R.id.button_tambah);
        bTambah.setOnClickListener(this);
    }
   @Override
    public void onClick(View view){
       switch(view.getId()){
           case R.id.button_tambah:
               Intent i = new Intent(this, CreateData.class);
               startActivity(i);
               break;
       }
   }
}

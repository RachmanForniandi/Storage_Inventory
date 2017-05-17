package com.example.android.storage_inventory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.storage_inventory.controller.DBDataSource;
import com.example.android.storage_inventory.model.Barang;

public class CreateData extends Activity implements View.OnClickListener{

    //inisialisasi elemen-elemen pada layout
    private Button buttonSubmit;
    private EditText edNama;
    private EditText edMerk;
    private EditText edHarga;
    private DBDataSource dataSource;

    //inisialisasi kontroller/dataSource
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_data);

        buttonSubmit = (Button)findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(this);
        edNama =(EditText)findViewById(R.id.nama_barang);
        edHarga = (EditText)findViewById(R.id.harga_barang);
        edMerk = (EditText)findViewById(R.id.merk_barang);

        //inisialisasi kelas DBDataSource
        dataSource = new DBDataSource(this);

        //membuat sambungan baru ke database
        dataSource.open();
    }

    //Ketika Tombol submit diklik
    @Override
    public void onClick(View v){
        //Inisialisasi data barang
        String nama = null;
        String merk = null;
        String harga = null;
        @SuppressWarnings("unused")

        //inisialisasi barang baru (masih kosong)
        Barang barang = null;
        if(edNama.getText()!=null && edMerk.getText()!=null && edHarga.getText()!=null){
            /*jika field nama, merk dan harga tidak kosong
            * maka masukan ke dalam data barang*/
            nama = edNama.getText().toString();
            merk= edMerk.getText().toString();
            harga = edHarga.getText().toString();
        }switch (v.getId()){
            case R.id.button_submit:
                //insert data barang baru
                barang =dataSource.createBarang(nama,merk,harga);

                //konfirmasi kesuksesan
                Toast.makeText(this,"masuk Barang\n" +
                        "nama"+ barang.getNama_barang()+
                        "merk"+barang.getMerk_barang()+
                        "harga"+barang.getHarga_barang(), Toast.LENGTH_LONG).show();
                break;
        }
    }
}

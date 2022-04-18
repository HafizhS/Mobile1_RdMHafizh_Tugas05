package com.example.mobile1_rdmhafizh_tugas05;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobile1_rdmhafizh_tugas05.models.DataPenduduk;
import com.example.mobile1_rdmhafizh_tugas05.utils.DatePickerUtils;

public class DetailDataPendudukActivity extends AppCompatActivity {

    TextView tvNik, tvNama, tvTempatLahir, tvTanggalLahir, tvAlamat, tvJenisKelamin, tvPekerjaan, tvStatusPerkawinan;
    Button btnBack, btnDaftar;

    DataPenduduk dataPenduduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data_penduduk);

        dataPenduduk = (DataPenduduk)getIntent().getParcelableExtra("dataPenduduk");
        if (dataPenduduk == null) {
            Toast.makeText(getBaseContext(),"Failed",Toast.LENGTH_LONG).show();
            finish();
        }

        init();
    }

    private void init() {
        tvNik = findViewById(R.id.tvNik);
        tvNama = findViewById(R.id.tvNama);
        tvTempatLahir = findViewById(R.id.tvTempatLahir);
        tvTanggalLahir = findViewById(R.id.tvTanggalLahir);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvJenisKelamin = findViewById(R.id.tvJenisKelamin);
        tvPekerjaan = findViewById(R.id.tvPekerjaan);
        tvStatusPerkawinan = findViewById(R.id.tvStatusPerkawinan);

        tvNik.setText(dataPenduduk.nik);
        tvNama.setText(dataPenduduk.nama);
        tvTempatLahir.setText(dataPenduduk.tempatLahir);
        tvTanggalLahir.setText(DatePickerUtils.longToString(DatePickerUtils.pattern1,dataPenduduk.tanggalLahir));
        tvAlamat.setText(dataPenduduk.alamat);
        tvJenisKelamin.setText(dataPenduduk.jenisKelamin);
        tvPekerjaan.setText(dataPenduduk.pekerjaan);
        tvStatusPerkawinan.setText(dataPenduduk.statusPerkawinan);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            finish();
        });

        btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(view -> {
            Toast.makeText(DetailDataPendudukActivity.this,"Daftar!",Toast.LENGTH_SHORT).show();
        });
    }
}
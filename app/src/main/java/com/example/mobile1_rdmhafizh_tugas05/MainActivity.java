package com.example.mobile1_rdmhafizh_tugas05;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mobile1_rdmhafizh_tugas05.models.DataPenduduk;
import com.example.mobile1_rdmhafizh_tugas05.utils.DatePickerUtils;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtTanggalLahir, edtNik, edtNama, edtTempatLahir, edtAlamat;
    RadioGroup rgJenisKelamin, rgStatusPerkawinan;
    AutoCompleteTextView acPekerjaan;
    Button btnBerikutnya;

    MaterialDatePicker<Long> datePicker;
    RadioButton selectedRadioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        edtNik = findViewById(R.id.edtNik);
        edtNama = findViewById(R.id.edtNama);
        edtTempatLahir = findViewById(R.id.edtTempatLahir);
        edtTanggalLahir = findViewById(R.id.edtTanggalLahir);
        edtAlamat = findViewById(R.id.edtAlamat);
        rgJenisKelamin = findViewById(R.id.rgJenisKelamin);
        rgStatusPerkawinan = findViewById(R.id.rgStatusPerkawinan);
        acPekerjaan = findViewById(R.id.acPekerjaan);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);

        datePicker = DatePickerUtils.buildBasicDatePicker("Tanggal Lahir");
        datePicker.addOnPositiveButtonClickListener(selection -> {
            edtTanggalLahir.setText(DatePickerUtils.longToString(DatePickerUtils.pattern1, selection));
        });

        edtTanggalLahir.setOnClickListener(view -> {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag("DATE_PICKER");
            if (fragment != null && fragment.isAdded()) {
                Log.d("FRAGMENT","Nope");
                return;
            };
            datePicker.show(getSupportFragmentManager(), "DATE_PICKER");
        });

        String[] listPekerjaan = {"Pegawai Negeri", "Pegawai Swasta", "Pelajar", "Wiraswasta"};
        ArrayAdapter<String> pekerjaanAdapter = new ArrayAdapter<>(this, R.layout.dropdown_menu_popup_item, listPekerjaan);
        acPekerjaan.setAdapter(pekerjaanAdapter);

        btnBerikutnya.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DetailDataPendudukActivity.class);
            DataPenduduk dataPenduduk = DataPenduduk.CREATOR.createFromParcel(Parcel.obtain());
            dataPenduduk.nik = edtNik.getText().toString();
            dataPenduduk.nama = edtNama.getText().toString();
            dataPenduduk.tempatLahir = edtTempatLahir.getText().toString();
            dataPenduduk.tanggalLahir = datePicker.getSelection();
            dataPenduduk.alamat = edtAlamat.getText().toString();
            dataPenduduk.pekerjaan = acPekerjaan.getText().toString();
            dataPenduduk.jenisKelamin = getSelectedRadioBtn(rgJenisKelamin).getText().toString();
            dataPenduduk.statusPerkawinan = getSelectedRadioBtn(rgStatusPerkawinan).getText().toString();

            intent.putExtra("dataPenduduk", (Parcelable) dataPenduduk);
            startActivity(intent);
        });
    }

    private RadioButton getSelectedRadioBtn(RadioGroup group) {
        return findViewById(group.getCheckedRadioButtonId());
    }

}
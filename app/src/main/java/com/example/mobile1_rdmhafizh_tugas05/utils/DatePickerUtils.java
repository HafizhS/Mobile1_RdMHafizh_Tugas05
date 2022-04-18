package com.example.mobile1_rdmhafizh_tugas05.utils;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DatePickerUtils {

    public static String pattern1 = "dd/MM/yyyy";
    public static String pattern2 = "yyyy/MM/dd";

    public static MaterialDatePicker<Long> buildBasicDatePicker(String title) {
        return MaterialDatePicker.Builder
                .datePicker()
                .setTitleText(title)
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
    }

    public static String longToString(String pattern,long value) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(value);
    }
}

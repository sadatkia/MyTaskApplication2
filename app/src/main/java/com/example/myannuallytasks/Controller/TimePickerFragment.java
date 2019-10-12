package com.example.myannuallytasks.Controller;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.myannuallytasks.R;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment {
    // View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_time_picker, null, false);

    private static final String ARG_TASK_TIME = "taskTime";
    public static final String EXTRA_TASK_Time = "com.example.myannuallytasks.taskTime";

    private DatePicker mDatePicker;
    private String mTime;
    private TimePicker mTimePicker;

    public TimePickerFragment() {
        // Required empty public constructor
    }


    public static TimePickerFragment newInstance(Date time) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_TIME, time);


        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mTime = (String) getArguments().getSerializable(ARG_TASK_TIME);/////اطلاعات دراه میاد برای date peaker مون خودش رندم با garigory calender بصورت رندم داده یود یهش
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater
                .inflate(R.layout.fragment_time_picker, null, false);////اینجا نقاشی  دیت پییییکر پیاده سازی شد

        mTimePicker = view.findViewById(R.id.id_button_Time);
        // mDatePicker.init(   نال   و     روز   و   ماه  و  سال)

        //initDTimePicker();

        return new AlertDialog.Builder(getActivity())

                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendResult();
                    }
                })
                .setView(view)
                .create();
    }


    private void sendResult() {
        int year = mDatePicker.getYear();
        int monthOfYear = mDatePicker.getMonth();
        int dayOfMonth = mDatePicker.getDayOfMonth();

        GregorianCalendar calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        Date date = calendar.getTime();

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TASK_Time, date);

        Fragment fragment = getTargetFragment();
        fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
    }

    private void initTimePicker() {
        Calendar calendar = Calendar.getInstance();///getInstance نشلنه ی singletone
        //calendar.setTime(mTime);

        int year = calendar.get(Calendar.YEAR);////از اینترنت گزفتیم
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        mDatePicker.init(year, monthOfYear, dayOfMonth, null);

        calendar = Calendar.getInstance();
        int hour = mTimePicker.getCurrentHour();
        int min = mTimePicker.getCurrentMinute();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        SimpleDateFormat mSDF = new SimpleDateFormat("hh:mm a");
        mTime = mSDF.format(calendar.getTime());
       // sendResult(mTime);
    }



}

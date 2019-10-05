package com.example.myannuallytasks.Controller;


import android.app.Dialog;
import android.app.PendingIntent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myannuallytasks.R;
import com.example.myannuallytasks.Repasitory.Repasitory_Task;
import com.example.myannuallytasks.model.Task;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener{
    public static final String BUNDLE_TASK = "Bundle Task";
    public static final int REQUEST_CODE_DATE_PICKER = 0;
    public static final String TAG_DATE_PICKER = "DatePicker";
    private Button mButton_Delete;
    private Button mButton_Save;
    private Button mButton_Edite;
    private Button mButton_Date;
    private Button mButton_Time;
    private EditText mEditeTexe_Title;
    private EditText mEditeTexe_Description;

    String item_todo_spinner;
    private  Task task=new Task();

    public AddDialogFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return super.onCreateView(inflater, container, savedInstanceState);


    }

    //////////////////////////////////////newInstance Section////////////////
    public static AddDialogFragment newInstance(Task task) {

        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_TASK, (Serializable) task);

        AddDialogFragment fragment = new AddDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }
////////////////////////////////////////////////////////////////
private String[] state= {"Doing","Done" ,"ToDo"};


    @NonNull
    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater
                .inflate(R.layout.fragment_add_dialog, null, false);

        Spinner spinner = view. findViewById(R.id.id_spinner);




        mButton_Delete=view.findViewById(R.id.id_Delete_Task);
        mButton_Edite=view.findViewById(R.id.id_Edit_Task);
        mButton_Save=view.findViewById(R.id.id_Save);
        mButton_Date=view.findViewById(R.id.id_button_Date);
        mButton_Time=view.findViewById(R.id.id_button_Time);
        mEditeTexe_Title=view.findViewById(R.id.id_editText_title);
        mEditeTexe_Description=view.findViewById(R.id.id_Discrption);
        spinner.setOnItemSelectedListener(this);

//////////////Spiner Section
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Spinner click listener


        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //String text = spinner.getSelectedItem().toString();




        ///////////////////////////////////////
        mButton_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

task=new Task();
             //   Task G= getArguments().getSerializable(BUNDLE_TASK);
task.setmTitle(mEditeTexe_Title.getText().toString());
task.setmDitaile(mEditeTexe_Description.getText().toString());
State s=State.TODO;
                if (item_todo_spinner=="ToDo")
                {

                    s =State.TODO;
                }
                if (item_todo_spinner=="Doing")
                {
                    s =State.DOING;
                }
                if (item_todo_spinner=="Done")
                {
                    s =State.DONE;
                }


                ((To_Do_Fragment) getTargetFragment()).updateUI();////////////////////مهسا گفتهههههههههههه برای کست کردن و استفاده ی اپدیتتتتتتت    تابع واسمون دوباره اضافه کنه تسک ها راااااااا

                 task.setmState(s);


                Repasitory_Task.getInstance().insertTask(task);
               // getActivity().getSupportFragmentManager().popBackStackImmediate();


getDialog().dismiss();
            }
        });

        mButton_Edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        mButton_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mButton_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerFragment datePickerFragment = DatePickerFragment.newInstance(task.getmDate());
                datePickerFragment.setTargetFragment(AddDialogFragment.this, REQUEST_CODE_DATE_PICKER);
                datePickerFragment.show(getFragmentManager(), TAG_DATE_PICKER);



            }
        });

        mButton_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//////////////////////////////////////////////////Return Section/////////////////////////////
        return new AlertDialog.Builder( getActivity() )
                .setCancelable(true)
                .setMessage("")

                .setView(view)
                .create();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item_todo_spinner = adapterView.getItemAtPosition(i).toString();



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


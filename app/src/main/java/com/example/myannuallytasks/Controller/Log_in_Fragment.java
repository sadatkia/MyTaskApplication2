package com.example.myannuallytasks.Controller;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myannuallytasks.R;
import com.example.myannuallytasks.model.Task;


/**
 * A simple {@link Fragment} subclass.
 */
public class Log_in_Fragment extends Fragment {
    public static final String ARG_PASS = "arg_pass";
    public static final String ARG_USER = "arg_user";
    public static final String PAS = "pas";
    public static final String USE = "use";
    public static final String USERNAME_LOGIN = "username_Login";
    public static final String PASS_WORD_LOGIN = "PassWord_Login";
    ////////////////////////////////]initialaise Section//////////
    private EditText mEditText_userName;
    private EditText mEditText_passWord;
    private Button mButton_Log_in;


    ////////////////////////////////////
    public Log_in_Fragment() {
        // Required empty public constructor
    }

    ///////////////////////////////////////NewInstance Section for Intent/////////////////////

    public static Log_in_Fragment newInstance(String MyUser, Integer MyPass) {
        Log_in_Fragment fragment = new Log_in_Fragment();
         Bundle args = new Bundle();

         args.putInt(ARG_PASS, MyPass);
         args.putString(ARG_USER, MyUser);

         fragment.setArguments(args);
          return fragment;
     }

//////////////////////////////////////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_log_in, container, false);
        mEditText_userName=view.findViewById(R.id.id_UserName_Log_In);
        mEditText_passWord=view.findViewById(R.id.id_Password_Log_in);
        mButton_Log_in=view.findViewById(R.id.id_button_login);

       int pass=getArguments().getInt(ARG_PASS );
        String user=getArguments().getString(ARG_USER);

        mEditText_passWord.setText(String.valueOf(pass));
        mEditText_userName.setText(user);

      mButton_Log_in.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

             int pass=getArguments().getInt(ARG_PASS );
              String user=getArguments().getString(ARG_USER);

              if((String.valueOf(pass).equals(mEditText_passWord.getText().toString()))&&(user.equals(mEditText_userName.getText().toString()))){

                  Toast.makeText(getActivity(),"wellcome",Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(getActivity(), TaskActivity.class);
                  int number = Integer.parseInt(mEditText_passWord.getText().toString());
                  intent.putExtra(USERNAME_LOGIN,  mEditText_userName.getText().toString());
                  intent.putExtra(PASS_WORD_LOGIN, number);
                  startActivity(intent);
              }
              else
              Toast.makeText(getActivity()," At First You have to Sing Up.please do it . ",Toast.LENGTH_SHORT).show();

              ////////////////////////////
              Task task=new Task();
              task.setmUserName( mEditText_userName.getText().toString());
              task.setmPassWord(Integer.parseInt(mEditText_passWord.getText().toString()));



          }
      });
        return view;
    }

}

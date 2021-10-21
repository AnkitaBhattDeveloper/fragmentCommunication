package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstFragment extends Fragment {

private Button buttton;
private EditText editText;
SendDatainterface sendDatainterface;
    public FirstFragment() {
        // Required empty public constructor
    }

public interface SendDatainterface
{
    public  void sendData(String a);
}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_1, container, false);

       buttton = view.findViewById(R.id.button);
      editText = view.findViewById(R.id.editText);

       buttton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String data = editText.getText().toString();
              sendDatainterface.sendData(data);
           }
       });


       return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        try {
            sendDatainterface =(SendDatainterface) activity;
        }
        catch (RuntimeException re)
        {
            throw new RuntimeException(activity.toString()+ "Must implement method");
        }

    }
}
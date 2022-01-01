package com.example.randompicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    EditText etItem, etNPC;
    Button btnRdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etItem = findViewById(R.id.etItem);
        etNPC = findViewById(R.id.etNPC);
        btnRdm = findViewById(R.id.btnRandom);

        btnRdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listCheck().equals(true)){
                    String data = etItem.getText().toString();
                    String [] array = data.split(",");
                    ArrayList<String> sList = new ArrayList<String>();

                    for(int i = 0; i < array.length; i++){
                       array[i] = array[i].trim();
                       sList.add(array[i]);
                    }

                    int index = (int)(Math.random() * sList.size());
                    etNPC.setText(sList.get(index));

                }
            }
        });

    }


    private Boolean listCheck() {
        if(etItem.getText().toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }


}
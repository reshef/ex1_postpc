package com.example.owner.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.text.DateFormat;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;
import java.util.Date;

public class ex1 extends AppCompatActivity {

    Button bmSend;
    ArrayList<String> messages = new ArrayList<String>();
    EditText txtMessage;
    EditText userId;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //was given
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ex1);

        bmSend = findViewById(R.id.bmSend); //the button get the input from id
        txtMessage = findViewById(R.id.txtMessage);
        userId = findViewById(R.id.userId);
        list = findViewById(R.id.list);
        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(ex1.this, android.R.layout.simple_list_item_1, messages);

        bmSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String currentMessage = txtMessage.getText().toString();
                String id = userId.getText().toString();
                if (!currentMessage.trim().equals("")) {
                    String time =  DateFormat.getDateInstance().format(new Date());
                    messages.add(id + " " + currentMessage + " at "+time);
                    list.setAdapter(listAdapter);
                    listAdapter.notifyDataSetChanged();//very important dont know why
                    txtMessage.setText("");//reset the the
                    userId.setText("");

                }
            }
        });
    }


}
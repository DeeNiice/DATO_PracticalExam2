package com.example.dato.dato_practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    EditText subjects, comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        subjects = findViewById(R.id.editText2);
        comments = findViewById(R.id.editText3);
    }

    public void ViewData(View v){
        //SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE);

       /* String c1SP = sp.getString("course1", null); //from file
        String c2SP = sp.getString("course2", null);
        String c3SP = sp.getString("course3", null);
        String c4SP = sp.getString("course4", null);
        String c5SP = sp.getString("course5", null);
        String c6SP = sp.getString("course6", null);
        String c7SP = sp.getString("course7", null);
        String c8SP = sp.getString("course8", null);
        String commSP = sp.getString("comments", null);*/

       StringBuffer msg=null;

        /*subjects.setText(c1SP + " " + c2SP + " " + c3SP + " " + c4SP + " " + c5SP + " " + c6SP + " " + c7SP + " " + c8SP);
        comments.setText(commSP);*/

        /*if(dualcamera1.isChecked())
            m++; // you can save this as checked somewhere*/

        int token;
        msg = new StringBuffer();
        try {
            FileInputStream reader = openFileInput("data.txt");

            while ((token = reader.read()) != -1){
                msg.append((char)token);

            }
        } catch (FileNotFoundException e) {
            Log.d("error", "IO ERROR");
        } catch (IOException e) {
            Log.d("error", "IO ERROR");
        }

        Toast.makeText(this, "Request Sent", Toast.LENGTH_LONG).show();
    }

    public void PrevPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

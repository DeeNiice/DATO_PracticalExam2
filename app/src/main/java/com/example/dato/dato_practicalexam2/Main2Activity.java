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
        FileInputStream fis = null;

        try {
            fis = openFileInput("data.txt");
            int token;
            String temp = "";
            while ((token = fis.read()) != -1){
                temp = temp + ((char)token);
            }
            fis.close();
            try {
                String[] list = temp.split("_");
                String[] list2 = list[0].split(",");
                for(int i=0; i < list2.length; i++) {
                    subjects.append(list2[i] + "\n");
                }

            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis = openFileInput("data2.txt");
            int token;
            String temp = "";
            while ((token = fis.read()) != -1){
                temp = temp + ((char)token);
            }
            fis.close();
            try {
                String[] list = temp.split("_");
                comments.setText(list[0]);

            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            Log.d("error", "IO ERROR");
        }






    }



    public void PrevPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

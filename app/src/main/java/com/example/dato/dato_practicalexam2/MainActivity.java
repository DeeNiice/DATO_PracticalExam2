package com.example.dato.dato_practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    CheckBox course1, course2, course3, course4, course5, course6, course7, course8;
    EditText comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course1 = findViewById(R.id.checkBox);
        course2 = findViewById(R.id.checkBox2);
        course3 = findViewById(R.id.checkBox3);
        course4 = findViewById(R.id.checkBox4);
        course5 = findViewById(R.id.checkBox5);
        course6 = findViewById(R.id.checkBox6);
        course7 = findViewById(R.id.checkBox7);
        course8 = findViewById(R.id.checkBox8);
        comments = findViewById(R.id.editText);
    }

    public void saveData(View v){
        //SharedPreferences sp = getSharedPreferences("myData", MODE_PRIVATE);
        //SharedPreferences.Editor editor = sp.edit();
        String c1 = course1.getText().toString();
        String c2 = course2.getText().toString();
        String c3 = course3.getText().toString();
        String c4 = course4.getText().toString();
        String c5 = course5.getText().toString();
        String c6 = course6.getText().toString();
        String c7 = course7.getText().toString();
        String c8 = course8.getText().toString();
        String comm = comments.getText().toString();

        /* editor.putString("course1",c1);
        editor.putString("course2",c2);
        editor.putString("course3",c3);
        editor.putString("course4",c4);
        editor.putString("course5",c5);ssdsds
        editor.putString("course6",c6);
        editor.putString("course7",c7);
        editor.putString("course8",c8);
        editor.putString("comments", comm);
        editor.commit(); */
        //String data = input.getText().toString();



        FileOutputStream fos=null;

        try {
            fos=openFileOutput("data.txt",MODE_PRIVATE);
            fos.write(c1.getBytes());
            fos.write(c2.getBytes());
            fos.write(c3.getBytes());
            fos.write(c4.getBytes());
            fos.write(c5.getBytes());
            fos.write(c6.getBytes());
            fos.write(c7.getBytes());
            fos.write(c8.getBytes());
            //fos.write(comm.getBytes());


        } catch (FileNotFoundException e) {
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            Log.d("error", "IO ERROR");

        }finally{
            try{
                fos.close();
            }catch(IOException e){
                Log.d("error", "IO ERROR");
            }
        }

        try {
            fos=openFileOutput("data2.txt",MODE_PRIVATE);
            fos.write(comm.getBytes());


        } catch (FileNotFoundException e) {
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            Log.d("error", "IO ERROR");

        }finally{
            try{
                fos.close();
            }catch(IOException e){
                Log.d("error", "IO ERROR");
            }
        }


        Toast.makeText(this, "Data Was Saved", Toast.LENGTH_LONG).show();
    }

    public void NextPage(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    /* private String convertSetString(Set<String> set){
        StringBuilder sb = new StringBuilder();
        for (String s: set) {
            sb.append(s).append("-");
        }
        return sb.toString();
    }*/
}

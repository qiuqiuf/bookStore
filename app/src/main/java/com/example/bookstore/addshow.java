package com.example.bookstore;

import android.app.Activity;
import android.content.Context;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.Provider;

public class addshow  {
    public  String handle(String source,Context context) {
        try {
//Return an AssetManager instance for your application's package


            InputStream is =context.getAssets().open(source);
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "GB2312");
            // Finally stick the string into the text view.


            FileOutputStream out = null;

            BufferedWriter writer = null;
            out = context.openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
            writer.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = context.openFileInput("data");

            reader = new BufferedReader(new InputStreamReader(in));

            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            String nm = content.toString();
            return nm;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "出错";
    }



}



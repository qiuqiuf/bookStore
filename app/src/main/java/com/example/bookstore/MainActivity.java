package com.example.bookstore;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.ScriptGroup;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("天游图书");
        LinearLayout linear=findViewById(R.id.imagemana);
        ImageView ima=new ImageView(this);
        ima.setId(R.id.pto1+1);
        ima.setImageResource(R.drawable.pt2);
        linear.addView(ima);
        ViewGroup.LayoutParams params= ima.getLayoutParams();
        params.height=500;
        params.width=500;


        final TextView textView2=findViewById(R.id.showText2);
       /* try {
//Return an AssetManager instance for your application's package
            InputStream is = getAssets().open("gkb.txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "GB2312");
            // Finally stick the string into the text view.
            TextView textView = (TextView) findViewById(R.id.showText);
            textView.setText(text);
            FileOutputStream out = null;

            BufferedWriter writer = null;
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
            writer.close();

        }catch (IOException e) {
                e.printStackTrace();
            }
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try{
            in=openFileInput("data");

            reader=new BufferedReader(new InputStreamReader(in));

            String line="";
            while((line=reader.readLine())!=null){
                content.append(line);
            }
            String nm=content.toString();

            textView2.setText(nm);

        }catch (IOException e) {
            e.printStackTrace();
        }*/
       addshow add=new addshow();
       File sceneFile=new File("D:\\bookStore\\app\\src\\main\\assets");
       File[] files=sceneFile.listFiles();
        if (files == null){Log.e("error111","空目录");}
       if(null!=files){
           for(int i=0;i<files.length;i++){
               String abc=add.handle(files[i].getName(),this);;
               Log.d("dad",abc);
               textView2.setText(abc);
           }
       }

      // String abc=add.handle("gkb.txt",this);
      // Log.d("dadada",abc);
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());

        //textView2.setText(abc);

        final ImageView imageView = (ImageView)findViewById(R.id.book);

        imageView.setImageResource(R.drawable.pt1);

        imageView.setLayoutParams(params);
        ima.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
}
@Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.backup:
               TextView textView2=findViewById(R.id.showText2);
                LinearLayout linearLayout=findViewById(R.id.imagemana);
                linearLayout.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
        }
        return true;
}


    @Override
    public void onClick(View view) {
        LinearLayout linearLayout=findViewById(R.id.imagemana);
        TextView textView2=findViewById(R.id.showText2);
        switch (view.getId()){
            case R.id.book:
                linearLayout.setVisibility(View.GONE);
                textView2.setVisibility(View.VISIBLE);
            case R.id.pto1+1:
                linearLayout.setVisibility(View.GONE);
                textView2.setVisibility(View.VISIBLE);
        }
    }
}












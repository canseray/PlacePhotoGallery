package com.example.favoriteplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);


        Intent intent = getIntent();

        String name  = intent.getStringExtra("name");

        textView.setText(name);   //önceki aktiviteden aktarılan ismi burdaki textViewımızda göster(fotonun altında)

        imageView.setImageBitmap(MainActivity.selectedImage);
    }
}

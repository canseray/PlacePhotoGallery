package com.example.favoriteplaces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;  //main2den de ulaşabilmek için static

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        final ArrayList<String> FavoritePlacesNames = new ArrayList<>();
        FavoritePlacesNames.add("Florida");
        FavoritePlacesNames.add("Mısır");
        FavoritePlacesNames.add("Saturn");


        //imageları liste text gibi atamadıgımız için önce bitmap oluşyuruyoruz

        Bitmap florida = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.florida);
        Bitmap misir = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.misir);
        Bitmap saturn = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.saturn);

        final ArrayList <Bitmap> FavoritePlacesImages = new ArrayList<>();
        FavoritePlacesImages.add(florida);
        FavoritePlacesImages.add(misir);
        FavoritePlacesImages.add(saturn);



        //listWiev ve Arrayi arrayAdapter ile birbirine bağladık

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,FavoritePlacesNames);
        listView.setAdapter(arrayAdapter);



        //liste elemanlarını diğer sayfaya baglıyoruz
        //int pozition: kaçıncı sıra
        //long id:

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  //diğer sayfaya geçiş için inten objesi oluştur,fonksonunu ta
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("name",FavoritePlacesNames.get(position));  //pozisyon numarasına göre ismi alıp diğer aktiviteye aktarıcak

                selectedImage = FavoritePlacesImages.get(position);

                startActivity(intent);
            }
        });
    }
}

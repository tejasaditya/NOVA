package com.example.tejas.nova;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    public static final int WEATHER = 0;
    public static final int MESSENGER = 1;
    public static final int RESET_DATA = 2;

    private String[] mMenu = {"Weather", "Movies", "Reset Data"};


    protected String[] gettMenu() {
        return mMenu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListView menuList = findViewById(R.id.menu_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, mMenu);
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case WEATHER:
                        intent = new Intent(MainActivity.this, WeatherBot.class);
                        startActivity(intent);
                        break;
                    case MESSENGER:
                        intent = new Intent(MainActivity.this, MovieBot.class);
                        startActivity(intent);
                        break;
                    case RESET_DATA:
                        AppData.reset(MainActivity.this);
                        break;
                    default:
                        return;
                }

            }
        });



    }
}


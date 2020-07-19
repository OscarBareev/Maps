package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private String data = "";
    private String uriData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button findBtn = findViewById(R.id.button);
        text = findViewById(R.id.editText);

        findBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            data = text.getText().toString().trim();

            if (data.isEmpty()) {
                Toast.makeText(MainActivity.this, "Введите данные", Toast.LENGTH_LONG).show();
            } else {
                makeUri();
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse(uriData));
                startActivity(mapIntent);
            }
        }
    };


    private void makeUri() {
        if (Character.isLetter(data.charAt(0))) {
            uriData = "geo:?q=" + data;
        } else {
            uriData = "geo:" + data;
        }
    }
}
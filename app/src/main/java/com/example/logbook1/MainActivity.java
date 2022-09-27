package com.example.logbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    TextView imageLink;
    ImageView imageView;
    Button previous,next,addLink,capturePhoto;
    private String list[] =
            {
                    "https://images.unsplash.com/photo-1663524789640-09950e318dac?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzfHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60",
                    "https://images.unsplash" +
                            ".com/photo-1663443525887-f2ef0cfc7684?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxOHx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60",
                    "https://images.unsplash.com/photo-1663501981668-e3b19f8dada3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzOXx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60",
                    "https://images.unsplash.com/photo-1663495744270-5664bb19da67?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw0MHx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60",
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLink  = findViewById(R.id.textView);
        imageView  = findViewById(R.id.imageView);
        previous  = findViewById(R.id.button);
        next  = findViewById(R.id.button2);
        addLink  = findViewById(R.id.button3);
        capturePhoto  = findViewById(R.id.button4);

        config();
    }

    private void config() {
        Glide.with(this).load(list[counter]).into(imageView);
        imageLink.setText(list[counter]);
        next.setOnClickListener(this::onClick);
        previous.setOnClickListener(v -> {
            changePhoto(true);
        });
    }

    void changePhoto(Boolean isPrevious) {
        if (isPrevious) {
            if (counter == 0) {
                Toast.makeText(this, "min limit reached", Toast.LENGTH_LONG).show();
            } else {
                counter = counter - 1;
                Glide.with(this).load(list[counter]).into(imageView);
                imageLink.setText(list[counter]);
            }
        } else {
            if (counter == list.length - 1) {
                Toast.makeText(this, "Max limit reached", Toast.LENGTH_LONG).show();
            } else {
                counter = counter + 1;
                Glide.with(this).load(list[counter]).into(imageView);
                imageLink.setText(list[counter]);
            }
        }
    }

    private void onClick(View v) {
        changePhoto(false);
    }
}
package com.gmail.mateendev3.userinteractions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import io.github.muddz.styleabletoast.StyleableToast;

public class CustomToast extends AppCompatActivity {
    Button normalToast;
    Button customToast;
    Button thirdPartyToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        normalToast = findViewById(R.id.normal_toast);
        customToast = findViewById(R.id.custom_toast);
        thirdPartyToast = findViewById(R.id.third_party_toast);

        normalToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(CustomToast.this, "Hello", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.START | Gravity.BOTTOM, 30, 30);
                toast.show();
            }
        });

        customToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(CustomToast.this);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);

                LayoutInflater inflater = getLayoutInflater();
                View toastLayout = inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.root));

                toast.setView(toastLayout);
                toast.show();
            }
        });

        thirdPartyToast.setOnClickListener(v -> {
            StyleableToast.makeText(CustomToast.this, "Hello", R.style.customToast).show();
        });
    }
}
package com.gmail.mateendev3.userinteractions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button btnSnackBar, btnDialog;
    ConstraintLayout parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSnackBar = findViewById(R.id.btn_snack_bar);
        btnDialog = findViewById(R.id.btn_dialog);
        parentLayout = findViewById(R.id.parent_layout);

        btnSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Mateen";
                Snackbar.make(parentLayout, "Thanks " + name, Snackbar.LENGTH_INDEFINITE).
                        setTextColor(Color.WHITE).
                        setBackgroundTint(Color.DKGRAY).
                        setAction("Retry", new View.OnClickListener() {
                            @SuppressLint("ResourceAsColor")
                            @Override
                            public void onClick(View v) {

                                //setBackground color me hum sirf Color. use kartay hain
                                parentLayout.setBackgroundColor(Color.RED);
                                //setBackResource me hum drawable k color use kartay
                                parentLayout.setBackgroundResource(R.color.black);
                                //setBackgroundTintList me hum valueOf() method call kar k sath Color. use kartay
                                parentLayout.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                            }
                        }).
                        setActionTextColor(Color.WHITE).
                        show();
            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete");
                builder.setMessage("Do you really want to delete?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        parentLayout.setBackgroundColor(Color.BLUE);
                    }
                });
                builder.create();
                builder.show();
            }
        });

    }
}
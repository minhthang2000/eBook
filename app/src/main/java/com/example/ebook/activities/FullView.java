package com.example.ebook.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ebook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class FullView extends AppCompatActivity {
    String fileName;
    Intent intent;
    PDFView pdfView;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);
        pdfView = (PDFView)findViewById(R.id.pdfView);
        intent = getIntent();
        fileName = intent.getStringExtra("fileName");
        //Toast.makeText(FullView.this,fileName, Toast.LENGTH_LONG).show();
        pdfView.fromAsset(fileName).load();
        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FullView.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
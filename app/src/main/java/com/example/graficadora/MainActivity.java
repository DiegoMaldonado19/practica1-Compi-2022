package com.example.graficadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.*;
import analizadores.*;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;


public class MainActivity extends AppCompatActivity {

    private Lexer graficasLexer;
    private Parser graficasParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.defineButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendText();
            }
        });
    }

    private void sendText(){
        EditText data = findViewById(R.id.editText);

        Reader reader = new StringReader(data.getText().toString());
        graficasLexer = new Lexer(reader);
        graficasParser = new Parser(graficasLexer);

        try {
            graficasParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
           System.out.println("Error encontrado en parseo");
        }

    }
}
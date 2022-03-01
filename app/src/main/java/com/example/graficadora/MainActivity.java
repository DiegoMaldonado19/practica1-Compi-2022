package com.example.graficadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.*;
import analizadores.*;
import java.util.*;
import controlador.Manejador;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;


public class MainActivity extends AppCompatActivity {

    private Lexer graficasLexer;
    private Parser graficasParser;
    private ArrayList<Manejador> tokenList;
    private ArrayList<String> errorList;

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
            this.tokenList = graficasParser.getClavesList();
            this.errorList = graficasParser.getErrorList();
            showTokens(this.tokenList);
            showErrors(this.errorList);
        } catch (Exception e) {
            e.printStackTrace();
           System.out.println("Error encontrado en parseo");
        }

    }

    private void showTokens(ArrayList<Manejador> lista){
        for (Manejador manejador: lista) {
            System.out.println(manejador.toString());
        }
    }

    private void showErrors(ArrayList<String> errors){
        for (String s: errors) {
            System.out.println(s);
        }
    }
}
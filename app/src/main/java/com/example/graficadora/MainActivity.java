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

import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;


public class MainActivity extends AppCompatActivity {

    private Lexer chartLexer;
    private Parser chartParser;
    private ArrayList<Manejador> tokenList;
    private ArrayList<String> chartNameList;
    private ArrayList<String> chartTitleList;
    private ArrayList<String> chartXAxisValuesList;
    private ArrayList<Integer> chartYAxisValuesList;
    private ArrayList<Integer> chartValuesList;
    private ArrayList<Integer> chartLinkList;
    private ArrayList<String> chartHashtagList;
    private ArrayList<String> chartTypeList;
    private ArrayList<String> chartExtraList;
    private BarChart barChart;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.defineButton);
        barChart = (BarChart)findViewById(R.id.barChart);
        pieChart = (PieChart)findViewById(R.id.pieChart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendText();
            }
        });
    }

    private void sendText(){
        EditText data = findViewById(R.id.editText);

        Reader reader = new StringReader(data.getText().toString());
        chartLexer = new Lexer(reader);
        chartParser = new Parser(chartLexer);

        try {
            chartParser.parse();
            this.tokenList = chartParser.getClavesList();
            divideTokens(this.tokenList);
        } catch (Exception e) {
            e.printStackTrace();
           System.out.println("Error encontrado en parseo");
        }

    }

    /* Metodos de Graficas*/
    private Chart getSameChart(Chart chart, String description, int textColor, int backgroundColor, int animateY){
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(backgroundColor);
        chart.animateY(animateY);
        return chart;
    }

    private void axisX(XAxis axis, String[] ejex){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(ejex));
    }

    private void axisLeft(YAxis axis){
       axis.setSpaceTop(30);
       axis.setAxisMinimum(0);
    }

    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }

    public void createCharts(){
        /*Aqui crearia mis graficas pero ya no me dio tiempo*/
        /*
        barChart = (BarChart) getSameChart(barChart);
        barChart.setDrawGridBackground(true);
        axisX(barChart.getXAxis(), );
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());


        pieChart=(PieChart) getSameChart(pieChart,);
        pieChart.setHoleRadius(10);
        pieChart.setTransparentCircleRadius(12);
         */
    }


    /*Metodo para dividir la lista de tokens y poder crear las graficas*/
    private void divideTokens(ArrayList<Manejador> lista){
        for (Manejador manejador: lista) {
            switch (manejador.getTipo()){
                case 1:
                     this.chartNameList.add(manejador.getLexeme());
                    break;
                case 2:
                    this.chartTitleList.add(manejador.getLexeme());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    this.chartTypeList.add(manejador.getLexeme());
                    break;
                case 6:
                    this.chartExtraList.add(manejador.getLexeme());
                    break;
                default:
                    break;
            }
        }
    }
}
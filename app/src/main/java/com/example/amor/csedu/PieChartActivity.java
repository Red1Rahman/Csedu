package com.example.amor.csedu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
    }

    public void show_piechart(View view)
    {
        Intent i = new Intent(view.getContext(), ShowPiechartActivity.class);
        startActivity(i);
    }
}

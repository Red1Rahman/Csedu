package com.example.amor.csedu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void xy_plot(View view)
    {
        Intent i = new Intent(view.getContext(), XYPlotActivity.class);
        startActivity(i);
    }

    public void pie_chart(View view)
    {
        Intent i = new Intent(view.getContext(), PieChartActivity.class);
        startActivity(i);
    }

    public void scatter_plot(View view)
    {
        Intent i = new Intent(view.getContext(), ScatterPlotActivity.class);
        startActivity(i);
    }

    public void bar_chart(View view)
    {
        Intent i = new Intent(view.getContext(), BarChartActivity.class);
        startActivity(i);
    }

    public void bubble_chart(View view)
    {
        Intent i = new Intent(view.getContext(), BubbleChartActivity.class);
        startActivity(i);
    }

    public void test(View view)
    {
        Intent i = new Intent(view.getContext(), Test.class);
        startActivity(i);
    }
}

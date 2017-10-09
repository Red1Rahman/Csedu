package com.example.amor.csedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.RectRegion;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.List;

public class ShowScatterPlotActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scatter_plot);

        XYPlot plot = (XYPlot) findViewById(R.id.scatterplot);
        LineAndPointFormatter[] seriesFormat = new LineAndPointFormatter[4];
        seriesFormat[0] = new LineAndPointFormatter(this, R.xml.point_formatter1);
        seriesFormat[1] = new LineAndPointFormatter(this, R.xml.point_formatter2);
        seriesFormat[2] = new LineAndPointFormatter(this, R.xml.point_formatter3);
        seriesFormat[3] = new LineAndPointFormatter(this, R.xml.point_formatter4);

        CSVFile csvfile = CSVFile.getInstance();
        List<String[]> myEntries = csvfile.readCSVFile();

        VisualizerFactory factory = new VisualizerFactory();
        Visualizer visualizer = factory.chooseScatterplotVisualizer(plot, seriesFormat);
        visualizer.visualize(myEntries);
    }

}

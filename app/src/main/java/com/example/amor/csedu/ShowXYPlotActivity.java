package com.example.amor.csedu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.XYPlot;

import java.util.*;

import static android.content.ContentValues.TAG;

/**
 * A simple XYPlot
 */
public class ShowXYPlotActivity extends Activity {

    XYPlot plot;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_xyplot);

        plot = (XYPlot)findViewById(R.id.plot);
        LineAndPointFormatter series1Format =
                new LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels);
        LineAndPointFormatter series2Format =
                new LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels_2);

        CSVFile csvfile = CSVFile.getInstance();
        List<String[]> myEntries = csvfile.readCSVFile();

        VisualizerFactory factory = new VisualizerFactory();
        Visualizer visualizer = factory.chooseXYVisualizer(plot, series1Format, series2Format);
        visualizer.visualize(myEntries);

    }

}


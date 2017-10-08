package com.example.amor.csedu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.*;

import static android.content.ContentValues.TAG;

/**
 * A simple XYPlot
 */
public class ShowXYPlotActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_xyplot);

        CSVFile csvfile = CSVFile.getInstance();
        List<String[]> myEntries = csvfile.readCSVFile();
        Log.d(TAG, "DHUR BALLLL");
        VisualizerFactory factory = new VisualizerFactory();
        Visualizer visualizer = factory.chooseXYVisualizer();
        visualizer.visualize(myEntries);

    }

}


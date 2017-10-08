package com.example.amor.csedu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.*;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.*;

import static android.content.ContentValues.TAG;

/**
 * A simple XYPlot
 */
public class XYPlotActivity extends Activity {

    private XYPlot plot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xyplot);

    }

    protected void show_xy_plot(View view)
    {
        CSVFile csvfile = CSVFile.getInstance();
        csvfile.reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.xy)));

        Intent i = new Intent(view.getContext(), ShowXYPlotActivity.class);
        startActivity(i);
    }

}


package com.example.amor.csedu;

import com.androidplot.Plot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYSeriesBundle;
import com.androidplot.xy.XYSeriesFormatter;
import com.androidplot.xy.XYSeriesRegistry;
import com.androidplot.xy.XYSeriesRenderer;

import java.util.List;

/**
 * Created by Amor on 10/8/2017.
 */

public interface Visualizer {

    public void visualize(List<String[]> entries, Plot<XYSeries, XYSeriesFormatter, XYSeriesRenderer, XYSeriesBundle, XYSeriesRegistry> plot );

}

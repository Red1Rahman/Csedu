package com.example.amor.csedu;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.XYPlot;

/**
 * Created by Amor on 10/8/2017.
 */

public class VisualizerFactory {

    Visualizer visualizer = null;

    public Visualizer chooseXYVisualizer(XYPlot plot, LineAndPointFormatter[] seriesFormat)
    {
        visualizer = new XYPlot_Visualizer(plot, seriesFormat);
        return visualizer;
    }

    public Visualizer chooseScatterplotVisualizer(XYPlot plot, LineAndPointFormatter[] seriesFormat)
    {
        visualizer = new Scatterplot_Visualizer(plot, seriesFormat);
        return visualizer;
    }
}

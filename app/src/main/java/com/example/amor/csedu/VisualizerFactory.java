package com.example.amor.csedu;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.XYPlot;

/**
 * Created by Amor on 10/8/2017.
 */

public class VisualizerFactory {

    Visualizer visualizer = null;

    public Visualizer chooseXYVisualizer(XYPlot plot, LineAndPointFormatter series1Format, LineAndPointFormatter series2Format)
    {
            visualizer = new XYPlot_Visualizer(plot, series1Format, series2Format);

        return visualizer;
    }
}

package com.example.amor.csedu;

/**
 * Created by Amor on 10/8/2017.
 */

public class VisualizerFactory {

    Visualizer visualizer = null;

    public Visualizer chooseXYVisualizer()
    {
            visualizer = new XYPlot_Visualizer();

        return visualizer;
    }
}

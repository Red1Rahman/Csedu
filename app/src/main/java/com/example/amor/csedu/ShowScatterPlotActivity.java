package com.example.amor.csedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.RectRegion;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

public class ShowScatterPlotActivity extends AppCompatActivity {

    private XYPlot plot;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scatter_plot);

        // initialize our XYPlot reference:

        plot = (XYPlot) findViewById(R.id.scatterplot);

        XYSeries series1 = generateScatter("series1", 80, new RectRegion(10, 50, 10, 50));
        XYSeries series2 = generateScatter("series2", 80, new RectRegion(30, 70, 30, 70));
        plot.setDomainBoundaries(0, 80, BoundaryMode.FIXED);
        plot.setRangeBoundaries(0, 80, BoundaryMode.FIXED);

        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        LineAndPointFormatter series1Format =
                new LineAndPointFormatter(this, R.xml.point_formatter1);
        LineAndPointFormatter series2Format =
                new LineAndPointFormatter(this, R.xml.point_formatter2);
        // add each series to the xyplot:
        plot.addSeries(series1, series1Format);
        plot.addSeries(series2, series2Format);
        // reduce the number of range labels
        plot.setLinesPerRangeLabel(3);

    }

    /**
     * Generate a XYSeries of random points within a specified region
     * @param title
     * @param numPoints
     * @param region
     * @return
     */
    private XYSeries generateScatter(String title, int numPoints, RectRegion region) {
        SimpleXYSeries series = new SimpleXYSeries(title);
        for(int i = 0; i < numPoints; i++) {
            series.addLast(
                    region.getMinX().doubleValue() + (Math.random() * region.getWidth().doubleValue()),
                    region.getMinY().doubleValue() + (Math.random() * region.getHeight().doubleValue())
            );
        }
        return series;
    }
}

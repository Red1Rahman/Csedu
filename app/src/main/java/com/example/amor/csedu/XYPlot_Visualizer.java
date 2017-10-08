package com.example.amor.csedu;

import android.app.Activity;
import android.graphics.DashPathEffect;
import android.util.Log;

import com.androidplot.Plot;
import com.androidplot.util.PixelUtils;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.*;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Amor on 10/8/2017.
 */

public class XYPlot_Visualizer extends Activity implements Visualizer{

    private XYPlot plot = null;
    LineAndPointFormatter series1Format;
    LineAndPointFormatter series2Format;
    public XYPlot_Visualizer(XYPlot plot, LineAndPointFormatter series1Format, LineAndPointFormatter series2Format){
        this.plot = plot;
        this.series1Format = series1Format;
        this.series2Format = series2Format;
    }
    public void visualize(List<String[]> myEntries )
    {
        int n = 0;
        if(myEntries.size()>0) {
            String s[] = myEntries.get(0);
            n = s.length;
        }
        ArrayList<Number[]> series = stringToNumber(n, myEntries);

        // initialize our XYPlot reference:

        // create a couple arrays of y-values to plot:

        final Number[] domainLabels = series.get(0);
        Number[] series1Numbers = series.get(1);
        Number[] series2Numbers = series.get(2);
        /*final Number[] domainLabels = {1, 2, 3, 6, 7, 8, 9, 10, 13, 14};
        Number[] series1Numbers = {1, 4, 2, 8, 4, 16, 8, 32, 16, 64};
        Number[] series2Numbers = {5, 2, 10, 5, 20, 10, 40, 20, 80, 40};*/

        // turn the above arrays into XYSeries':
        // (Y_VALS_ONLY means use the element index as the x value)
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");
        XYSeries series2 = new SimpleXYSeries(
                Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");

        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:




        // add an "dash" effect to the series2 line:
        series2Format.getLinePaint().setPathEffect(new DashPathEffect(new float[] {

                // always use DP when specifying pixel sizes, to keep things consistent across devices:
                PixelUtils.dpToPix(20),
                PixelUtils.dpToPix(15)}, 0));

        // just for fun, add some smoothing to the lines:
        // see: http://androidplot.com/smooth-curves-and-androidplot/
        series1Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        series2Format.setInterpolationParams(
                new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);
        plot.addSeries(series2, series2Format);

        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).floatValue());
                return toAppendTo.append(domainLabels[i]);
            }
            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
    }

    public ArrayList<Number[]> stringToNumber(int n, List<String[]> entries)
    {
        ArrayList<Number[]> series = new ArrayList<Number[]>();
        for(int i = 0; i < n; i++)
        {
            Number[] temp = new Number[entries.size()];
            for(int j=0; j<entries.size(); j++) {
                String[] a = entries.get(j);
                temp[j] = Float.parseFloat(a[i]);
            }
            series.add(i, temp);
        }
        return series;
    }
}

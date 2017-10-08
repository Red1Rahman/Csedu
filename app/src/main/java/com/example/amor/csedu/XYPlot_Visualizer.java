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
    LineAndPointFormatter[] seriesFormat;
    public XYPlot_Visualizer(XYPlot plot, LineAndPointFormatter[] seriesFormat){
        this.plot = plot;
        this.seriesFormat = seriesFormat;
    }
    public void visualize(List<String[]> myEntries )
    {
        int n = 0;
        if(myEntries.size()>0) {
            String s[] = myEntries.get(0);
            n = s.length;
        }
        ArrayList<Number[]> series = stringToNumber(n, myEntries);

        final Number[] domainLabels = series.get(0);
        Number[][] seriesNumbers = new Number[n][];
        for(int k = 1; k<n; k++)
            seriesNumbers[k-1] = series.get(k);

        XYSeries[] xySeries = new XYSeries[n];

        for(int k=0; k<n-1; k++)
            xySeries[k] = new SimpleXYSeries(
                    Arrays.asList(seriesNumbers[k]), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");



        // add an "dash" effect to the series2 line:
        seriesFormat[0].getLinePaint().setPathEffect(new DashPathEffect(new float[] {

                // always use DP when specifying pixel sizes, to keep things consistent across devices:
                PixelUtils.dpToPix(20),
                PixelUtils.dpToPix(15)}, 0));

        // just for fun, add some smoothing to the lines:
        // see: http://androidplot.com/smooth-curves-and-androidplot/
        for(int k = 0; k<n-1; k++)
            seriesFormat[k].setInterpolationParams(
                    new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));

        // add a new series' to the xyplot:
        for(int k=0; k<n-1; k++)
            plot.addSeries(xySeries[k], seriesFormat[k]);

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
            Number[] temp = new Number[entries.size()-1];
            for(int j=1; j<entries.size(); j++) {
                String[] a = entries.get(j);
                temp[j-1] = Float.parseFloat(a[i]);
            }
            series.add(i, temp);
        }
        return series;
    }
}

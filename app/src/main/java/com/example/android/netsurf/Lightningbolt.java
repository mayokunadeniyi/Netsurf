package com.example.android.netsurf;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class Lightningbolt extends AppCompatActivity {

    private LineChart mChart;

    private int nFillColor = Color.argb(150,51,181,229);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightningbolt);

        mChart = (LineChart) findViewById(R.id.linechart_id);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setGridBackgroundColor(Color.CYAN);
        mChart.setDrawGridBackground(false);


        mChart.setDrawBorders(true);
        mChart.getDescription().setEnabled(true);
        mChart.setPinchZoom(false);

        Legend l = mChart.getLegend();
        l.setEnabled(true);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setAxisMaximum(300);
        leftAxis.setAxisMinimum(50);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawGridLines(false);

        setData(150,150);
        }

        private void setData(int count,float range){

            ArrayList<Entry> yVals = new ArrayList<>();

            for (int i=0; i<count;i++){
                float val = (float) (Math.random()*range) + 50;
                yVals.add(new Entry(i,val));
            }

            ArrayList<Entry> yVals1 = new ArrayList<>();

            for (int i=0; i<count;i++){
                float val = (float) (Math.random()*range) + 150;
                yVals1.add(new Entry(i,val));
            }

            LineDataSet set1, set2;

            set1 = new LineDataSet(yVals, "Network Strength");
            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setColor(Color.RED);
            set1.setDrawCircles(false);
            set1.setLineWidth(1f);
            set1.setFillAlpha(255);
            set1.setDrawFilled(true);
            set1.setFillColor(Color.WHITE);

            set2 = new LineDataSet(yVals, "Data");
            set2.setAxisDependency(YAxis.AxisDependency.LEFT);
            set2.setColor(Color.BLACK);
            set2.setDrawCircles(false);
            set2.setLineWidth(1f);
            set2.setFillAlpha(255);
            set2.setDrawFilled(true);
            set2.setFillColor(Color.WHITE);

            LineData data = new LineData(set2,set1);
            data.setDrawValues(false);

            mChart.setData(data);

        }
}

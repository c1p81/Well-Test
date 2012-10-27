package com.luca.innocenti.well.test;

import java.util.Arrays;

import com.androidplot.series.XYSeries;
import com.androidplot.ui.AnchorPosition;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XLayoutStyle;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.YLayoutStyle;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.graphics.Color;

public class Grafico extends Activity {

    private XYPlot Grafico;
	private Double portata1,portata2,portata3,portata4,portata5;
	private Double soggiacenza1,soggiacenza2,soggiacenza3,soggiacenza4,soggiacenza5;
	private int gradini;
	private double max_portata;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
    
        
        Bundle da = getIntent().getExtras();
        gradini = da.getInt("gradini");
        
        portata1 = da.getDouble("portata1");
        soggiacenza1 = da.getDouble("soggiacenza1");
        portata2 = da.getDouble("portata2");
        soggiacenza2 = da.getDouble("soggiacenza2");
        portata3 = da.getDouble("portata3");
        soggiacenza3 = da.getDouble("soggiacenza3");
        portata4 = da.getDouble("portata4");
        soggiacenza4 = da.getDouble("soggiacenza4");
        portata5 = da.getDouble("portata5");
        soggiacenza5 = da.getDouble("soggiacenza5");

        
        Log.d("gradini",Integer.toString(gradini));
        //Log.d("portata",Double.toString(portata1));
        //Log.d("soggiacenza",Double.toString(soggiacenza1));
        
        //inizializza il grafico
        Grafico = (XYPlot) findViewById(R.id.Grafico);
        //definisce le coppie di valori X (portata) ed Y (soggiacenza)
        //Number[] portata = {0,1.0, 2, 3, 4, 5};
        //Number[] soggiacenza = {0, -2, -4, -6, -8, -12};
        
        Number[] portata = new Number[gradini];
        Number[] soggiacenza = new Number[gradini];
        portata[0] = 0.0;
        soggiacenza[0] = 0.0;
        
        max_portata = 0.0;
        
        if ((gradini-1) >= 1){
		        portata[1] = portata1;
		        soggiacenza[1] = -soggiacenza1;
		        }
        if ((gradini-1) >= 2){
		        portata[2] = portata2;
		        soggiacenza[2] = -soggiacenza2;
		        max_portata = portata2;
        }
        if ((gradini-1) >= 3){
		        portata[3] = portata3;
		        soggiacenza[3] = -soggiacenza3;
		        max_portata = portata3;
        }
        if ((gradini-1) >= 4){
		        portata[4] = portata4;
		        soggiacenza[4] = -soggiacenza4;
		        max_portata = portata4;
        }
        if ((gradini-1) == 5){
		        portata[5] = portata5;
		        soggiacenza[5] = -soggiacenza5;
		        max_portata = portata5;
        }
        
        
        //disegna la retta BQ
        Number[] bq_portata = new Number[2];
        Number[] bq_soggiacenza = new Number[2];
        
        bq_portata[0] = 0.0;
        bq_soggiacenza[0] = 0.0;
        
        bq_portata[1] = max_portata;
        bq_soggiacenza[1] = -((max_portata/portata1)*soggiacenza1);
        
        
        XYSeries dati = new SimpleXYSeries(Arrays.asList(portata),  Arrays.asList(soggiacenza), "Dati");
        XYSeries bq = new SimpleXYSeries(Arrays.asList(bq_portata),  Arrays.asList(bq_soggiacenza), "BQ");

        // crea lo stile per i punti
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0, 200, 0),                   // line color
                Color.rgb(0, 100, 0),                   // point color
                null);                                  // fill color (none)
        LineAndPointFormatter bqFormat = new LineAndPointFormatter(
                Color.rgb(255, 0, 0),                   // line color
                Color.rgb(255, 0, 0),                   // point color
                null);                                  // fill color (none)
 
        // aggiunge i dati al grafico
        Grafico.addSeries(dati, series1Format);
        Grafico.addSeries(bq, bqFormat);
  
        // AndroidPlot chiama Range l'asse X e Domain l'asse Y
        // riduce il numero di ticks su entrambi gli assi
        Grafico.setTicksPerRangeLabel(3);
        Grafico.setTicksPerDomainLabel(3);
        
        // mette il colore bianco in background
        Grafico.getGraphWidget().getGridBackgroundPaint().setColor(Color.WHITE);
        Grafico.getGraphWidget().setMarginTop(10);
        
        // cancella la legenda dal grafico
        Grafico.getLegendWidget().setVisible(false);
        
        //scrive le label sugli assi  
        Grafico.setDomainLabel("Pumping Rate");
        Grafico.getDomainLabelWidget().pack();
        Grafico.setRangeLabel("Drawdown");
        Grafico.getRangeLabelWidget().pack();
 
        Grafico.disableAllMarkup();
        
        Grafico.position(Grafico.getDomainLabelWidget(),0,XLayoutStyle.ABSOLUTE_FROM_CENTER,5, YLayoutStyle.ABSOLUTE_FROM_BOTTOM, AnchorPosition.CENTER);

        
        //Grafico.setGridPadding(15, 0, 15, 0);
    }
}

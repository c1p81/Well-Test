package com.luca.innocenti.well.test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btnsalva;
    private Button btngraph;
	private TextView txtportata;
	private TextView txtsoggiacenza;
	private TextView portata1;
	private TextView soggiacenza1;
	private TextView portata2;
	private TextView soggiacenza2;
	private TextView portata3;
	private TextView soggiacenza3;
	private int gradino = 1;
	private Button btncancella;
	private TextView portata4;
	private TextView soggiacenza4;
	private TextView portata5;
	private TextView soggiacenza5;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btngraph = (Button) findViewById(R.id.bnt_grafico);
        btnsalva = (Button) findViewById(R.id.btn_salva);
        btncancella = (Button) findViewById(R.id.btn_cancella);
        
        txtportata = (TextView) findViewById(R.id.txtportata);
        txtsoggiacenza = (TextView) findViewById(R.id.txtsoggiacenza);
        
        portata1 = (TextView) findViewById(R.id.portata2);
        soggiacenza1 = (TextView) findViewById(R.id.soggiacenza2);
        portata2 = (TextView) findViewById(R.id.portata3);
        soggiacenza2 = (TextView) findViewById(R.id.soggiacenza3);
        portata3 = (TextView) findViewById(R.id.portata4);
        soggiacenza3 = (TextView) findViewById(R.id.soggiacenza4);
        portata4 = (TextView) findViewById(R.id.portata5);
        soggiacenza4 = (TextView) findViewById(R.id.soggiacenza5);
        portata5 = (TextView) findViewById(R.id.portata6);
        soggiacenza5 = (TextView) findViewById(R.id.soggiacenza6);
        
        
        //salva i dati
        btnsalva.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if ((txtportata.getText().toString().length() > 0) && (txtsoggiacenza.getText().toString().length() > 0))
				{
					switch (gradino)
					{
					case 1:
						portata1.setText(txtportata.getText());
						soggiacenza1.setText(txtsoggiacenza.getText());
						txtportata.setText("");
						txtsoggiacenza.setText("");
						txtportata.requestFocus();
						gradino++;
						break;
					case 2:
						portata2.setText(txtportata.getText());
						soggiacenza2.setText(txtsoggiacenza.getText());
						txtportata.setText("");
						txtsoggiacenza.setText("");
						txtportata.requestFocus();
						gradino++;
						break;
					case 3:
						portata3.setText(txtportata.getText());
						soggiacenza3.setText(txtsoggiacenza.getText());
						txtportata.setText("");
						txtsoggiacenza.setText("");
						txtportata.requestFocus();
						gradino++;
						break;
					case 4:
						portata4.setText(txtportata.getText());
						soggiacenza4.setText(txtsoggiacenza.getText());
						txtportata.setText("");
						txtsoggiacenza.setText("");
						txtportata.requestFocus();
						gradino++;
						break;
					case 5:
						portata5.setText(txtportata.getText());
						soggiacenza5.setText(txtsoggiacenza.getText());
						txtportata.setText("");
						txtsoggiacenza.setText("");
						txtportata.requestFocus();
						gradino++;
						break;
						}
				}
				else
				{
					Toast toast = Toast.makeText(MainActivity.this, R.string.stringa_vuota, Toast.LENGTH_LONG);
    				toast.show();
				}
			}
		});
        
        // cancella un dato 
        btncancella.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (gradino)
				{
				case 2:
					portata1.setText("0");
					soggiacenza1.setText("0");
					gradino--;
					break;
				case 3:
					portata2.setText("0");
					soggiacenza2.setText("0");
					gradino--;
					break;
				case 4:
					portata3.setText("0");
					soggiacenza3.setText("0");
					gradino--;
					break;
				case 5:
					portata4.setText("0");
					soggiacenza4.setText("0");
					gradino--;
					break;
				case 6:
					portata5.setText("0");
					soggiacenza5.setText("0");
					gradino--;
					break;
				}
			}
		});
        
        // apre la finestra del grafico
         btngraph.setOnClickListener(new View.OnClickListener() {

				private Toast toast;

				public void onClick(View v) {
        			if (gradino >= 3)
		        			{
		        			// passa la matrice dei valori di portata al grafico
		        			Bundle dataBundle = new Bundle();
		        			dataBundle.putInt("gradini", gradino);
		        			
		        			dataBundle.putDouble("portata1", Double.parseDouble(portata1.getText().toString()));
		        			dataBundle.putDouble("soggiacenza1", Double.parseDouble(soggiacenza1.getText().toString()));
		        			dataBundle.putDouble("portata2", Double.parseDouble(portata2.getText().toString()));
		        			dataBundle.putDouble("soggiacenza2", Double.parseDouble(soggiacenza2.getText().toString()));
		        			dataBundle.putDouble("portata3", Double.parseDouble(portata3.getText().toString()));
		        			dataBundle.putDouble("soggiacenza3", Double.parseDouble(soggiacenza3.getText().toString()));
		        			dataBundle.putDouble("portata4", Double.parseDouble(portata4.getText().toString()));
		        			dataBundle.putDouble("soggiacenza4", Double.parseDouble(soggiacenza4.getText().toString()));
		        			dataBundle.putDouble("portata5", Double.parseDouble(portata5.getText().toString()));
		        			dataBundle.putDouble("soggiacenza5", Double.parseDouble(soggiacenza5.getText().toString()));
		
		        			Intent Intentdati = new Intent();
		        			Intentdati.setClass(MainActivity.this,Grafico.class);
		        			Intentdati.putExtras(dataBundle);
		        			startActivity(Intentdati);
		        			}
        			else
        			{
        				toast = Toast.makeText(MainActivity.this, R.string.errore, Toast.LENGTH_LONG);
        				toast.show();
        				
        			}
        			
        			}
        			});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
   
}

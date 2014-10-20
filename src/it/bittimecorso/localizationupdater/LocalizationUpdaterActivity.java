package it.bittimecorso.localizationupdater;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LocalizationUpdaterActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setPrompt("select language");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, languages);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Configuration config = new Configuration();
				switch (arg2) {
				case 0:
					config.locale = Locale.ENGLISH;
					break;
				case 1:
					config.locale = Locale.ITALIAN;
					break;
				case 2:
					config.locale = Locale.FRENCH;
					break;
				default:
					config.locale = Locale.ENGLISH;
					break;
				}
				getResources().updateConfiguration(config, null);
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});


	}
	
	public void onClick(View v) {
		startActivity(new Intent(getBaseContext(), TextActivity.class));
	}
	private String[] languages = { "Inglese", "Italiano", "Francese" };
}
package mvc.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class SmokeModel {

	public SmokeModel(){

	}
	

	public String ControllHeating(Double actualTemp,Integer soll){
		
		String Regelwert = "nix";
		
		if((double) soll>actualTemp){
			Regelwert = "Einschalten";
		}
		else{
			Regelwert = "Ausschalten";
		}
		
		System.out.println(Regelwert);

		return Regelwert;
		
	}

	public Double getTemperatureFromVZ() throws MalformedURLException, IOException, JSONException{

		String url = "http://vz.wiuhelmtell.ch/middleware.php/data/cabffab0-88a4-11e6-ac58-ebf10a5a3cb2.json";
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
		String from = "last second";
		String query;
		URLConnection connection;


		try {
			query = String.format("from=%s", URLEncoder.encode(from, charset));
		} catch (UnsupportedEncodingException e2) {
			query = "";
			e2.printStackTrace();
		}

		// Verbindung aufbauen und Werte als JSON auslesen
		connection = new URL(url + "?" + query).openConnection();
		connection.setRequestProperty("Accept-Charset", charset);
		InputStream response = connection.getInputStream();


		String Response;
		try (Scanner scanner = new Scanner(response)) {
			String responseBody = scanner.useDelimiter("\\A").next();
			Response = responseBody;
		}

		JSONObject json = new JSONObject(Response);


		double Temperatur = json.getJSONObject("data").getDouble("average");
		Double Min = 3.0;
		Double Max = 40.0;
		Temperatur = Min + (int)(Math.random() * ((Max - Min) + 1));
		return Temperatur;
		
		}



}

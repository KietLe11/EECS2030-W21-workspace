package model;

import model.*;

public class WeatherStation {

	protected String stationName;
	protected int maxApps;
	protected int noca; //number of connected apps
	protected WeatherApp[] wApps;
	protected int numOfSensors;
	protected int numOfForecasts;
	
	public WeatherStation(String stationName, int maxApps) {
		
		this.maxApps = maxApps;
		this.stationName = stationName;
		noca = 0;
		
		wApps = new WeatherApp[maxApps];
	}
	
	/*
	 * Mutators
	 */
	
	public void connect(WeatherApp app) {
		
		if(noca!= maxApps) {
			wApps[noca] = app;
			
			if(app instanceof SensorApp) {
				numOfSensors++;
			}
			else if(app instanceof ForecastApp) {
				numOfForecasts++;
			}
			noca++;
			
			app.connect(this);
		}
	}
	
	public void updateMeaurements(int temperature, int pressure) {
		int counter =0;
		for(int i =0; i<noca; i++) {
			if(counter!=numOfForecasts) {
				if(wApps[i] instanceof ForecastApp) {
					((ForecastApp)wApps[i]).updateMeasurement(this, temperature, pressure);
					counter++;
				}
			}
			else {
				break;
			}
		}
	}
	
	/*
	 * Accessors
	 */
	public String toString() {
		String s = "";
		if(noca==0) {
			s = String.format("%s has no connected apps.", stationName);
		}
		else {
			s = String.format("%s is connected by %d apps: <", stationName, noca);
			
			for(int i = 0; i<noca; i++) {
				s+= "Weather " + wApps[i].getClassType() +" ";
				s+= wApps[i].getAppName();
				if(i!=noca-1) {
					s+=", ";
				}
			}
			s+=">.";
		}
		return s;
	}
	
	public SensorApp[] getSensors() {
		SensorApp[] sensors = new SensorApp[numOfSensors];
		int counter =0;
		
			for(int i = 0; i<noca; i++) {
				if(wApps[i] instanceof SensorApp) {
					sensors[counter] = (SensorApp) wApps[i];
					counter++;
					if(counter==numOfSensors) {
						break;
					}
				}
			}
		
		return sensors;
	}
	
	public String getStationName() {
		return stationName;
	}
	
	public String[] getForecasters() {
		String s[] = new String[numOfForecasts];
		int counter = 0;
		for(int i =0; i<noca; i++) {
			if(wApps[i] instanceof ForecastApp) {
				s[counter] = wApps[i].getAppName()+ String.format(" at index %d", i);
				counter++;
				if(counter==numOfForecasts) {
					break;
				}
			}
		}
		return s;
	}
}

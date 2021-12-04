package junit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * The problem to solve for this test is described as comments within the test methods.
 */

public class Tests {
	/*
	 * 1. Do NOT create any new packages. 
	 * 		All classes you create must be in the `model` package.
	 * 
	 * 2. All attributes you declare in the classes must be *** private *** or ***protected***.
	 * 
	 * 3. You are free to create additional private, protected, or public helper methods.
	 * 
	 * 4. You must NOT create any class not indicated by the given JUnit tests.
	 * 
	 * 5. You must NOT put any System.out.print statements in the classes you create.
	 * 
	 * 6. Programming Requirements:
	 * 	- You are only allowed to use primitive arrays (e.g., int[], String[], Facility[]) 
	 * 		for declaring attributes and implementing methods.
	 * 	- Any use of a Java library class or method is forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format)
	 * 
	 * You will receive a penalty as specified on the test guide if this requirement is violated.
	 */
	
	/*
	 * Your expected workflow should be:
	 * 
	 * Step 1: Eliminate compilation errors. 
	 * 	Declare all the required classes and methods (returning default values if necessary), 
	 * 	so that the project contains no compilation errors (i.e., no red crosses shown on the Eclipse editor).
	 * 
	 * Step 2: Pass all unit tests. Add private or protected attributes and complete the method implementations accordingly, 
	 * 	so that executing all tests result in a green bar.
	 * 
	 * If necessary, you are free to declare (private, protected, or public) helper methods.
	 * 
	 * Any new classes that are ***not*** indicated by the given JUnit tests will be ***disregarded*** in grading. 
	 */

	@Test
	public void test_weather_station_01() {
		/*
		 * In this version of the test you are required to solve a weather station problem:
		 * 	A weather station has zero or more connected apps (each of which being a sensor app or a forecast app).
		 *  Symmetrically, each sensor app or forecast app has zero or more connected weather stations.    
		 */
		
		/* 
		 * Create a weather station with the specified name and maximum 50 apps to be connected. 
		 * No error handling is needed when a preset maximum is exceeded: let the ArrayIndexOutOfBoundsException occur.
		 */
		WeatherStation station = new WeatherStation("Station@NorthYork", 50);
		assertEquals("Station@NorthYork has no connected apps.", station.toString());
	}
	
	@Test
	public void test_weather_app_01() {
		/*
		 * Create a weather sensor app with the specified name and maximum 20 connected weather stations.
		 * No error handling is needed when a preset maximum is exceeded: let the ArrayIndexOutOfBoundsException occur.
		 */
		WeatherApp app = new SensorApp("Sensor1234", 20);
		assertEquals("Weather Sensor App Sensor1234 is connected to no stations.", app.toString());
	}
	
	@Test
	public void test_weather_app_02() {
		/*
		 * Create a weather forecast app with the specified name and maximum 20 connected weather stations.
		 * No error handling is needed when a preset maximum is exceeded: let the ArrayIndexOutOfBoundsException occur.
		 */
		WeatherApp app = new ForecastApp("Forecaster5678", 20);
		assertEquals("Weather Forecast App Forecaster5678 is connected to no stations.", app.toString());
	}
 
	@Test
	public void test_weather_station_02() { 
		/*
		 * Note that the two stations are set with different maximums for
		 * 	the allowed numbers of connected apps. 
		 */
		WeatherStation station1 = new WeatherStation("Station@NorthYork", 50);
		WeatherStation station2 = new WeatherStation("Station@Markham", 60);
		
		/*
		 * For each of station1 and station2, 
		 * 	retrieve all connected apps which are dynamically sensor apps.  
		 * 
		 * At the moment, both stations have no connected apps. 
		 */
		SensorApp[] sensors1 = station1.getSensors();
		assertTrue(sensors1.length == 0);
		SensorApp[] sensors2 = station2.getSensors();
		assertTrue(sensors2.length == 0);
		
		/*
		 * Note that the apps are set with different maximums for the allowed numbers of connected weather stations.
		 */
		WeatherApp app1 = new SensorApp("Sensor1234", 20);
		WeatherApp app2 = new ForecastApp("Forecaster5678", 60); 
		
		/* 
		 * Connect `app1` to `station1` (which symmetrically also connects `station1` to `app1`). 
		 * 
		 * You can assume that a weather app, once added to a weather station, will not be added to that station again.
		 * 
		 * For simplicity, in the return value of the toString method,
		 * 	spell `1 apps`, `2 apps`, `1 stations`, `2 stations`, and etc.
		 */
		station1.connect(app1);
		assertEquals("Station@NorthYork is connected by 1 apps: <Weather Sensor App Sensor1234>.", station1.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 1 stations: <Station@NorthYork>.", app1.toString());
		
		/*
		 * For each of station1 and station2, 
		 * 	retrieve all connected apps which are dynamically sensor apps.  
		 */
		sensors1 = station1.getSensors();
		assertTrue(sensors1.length == 1);
		assertSame(sensors1[0], app1);
		sensors2 = station2.getSensors();
		assertTrue(sensors2.length == 0);
		
		/* 
		 * Connect `app2` to`station1`. 
		 */
		station1.connect(app2);
		assertEquals("Station@NorthYork is connected by 2 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678>.", station1.toString());
		assertEquals("Weather Forecast App Forecaster5678 is connected to 1 stations: <Station@NorthYork>.", app2.toString());
		 
		sensors1 = station1.getSensors();
		assertTrue(sensors1.length == 1);
		assertSame(sensors1[0], app1);
		sensors2 = station2.getSensors();
		assertTrue(sensors2.length == 0);
		
		/* 
		 * Connect `app2` to `station2`. 
		 */
		station2.connect(app2);
		assertEquals("Station@Markham is connected by 1 apps: <Weather Forecast App Forecaster5678>.", station2.toString());
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", app2.toString());
		
		sensors1 = station1.getSensors();
		assertTrue(sensors1.length == 1);
		assertSame(sensors1[0], app1);
		sensors2 = station2.getSensors();
		assertTrue(sensors2.length == 0);
		
		/* 
		 * Connect `app1` to `station2`. 
		 */
		station2.connect(app1);
		assertEquals("Station@Markham is connected by 2 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1234>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", app1.toString());
		
		sensors1 = station1.getSensors();
		assertTrue(sensors1.length == 1);
		assertSame(sensors1[0], app1);
		sensors2 = station2.getSensors();
		assertTrue(sensors2.length == 1);
		assertSame(sensors2[0], app1);
	}
	
	@Test
	public void test_weather_station_03() { 
		WeatherStation station1 = new WeatherStation("Station@NorthYork", 50);
		WeatherStation station2 = new WeatherStation("Station@Markham", 60);
		
		SensorApp sensor1 = new SensorApp("Sensor1234", 20); 
		SensorApp sensor2 = new SensorApp("Sensor1983", 20);
		ForecastApp forecaster1 = new ForecastApp("Forecaster5678", 60);
		
		station1.connect(sensor1); 
		station1.connect(forecaster1);
		station1.connect(sensor2);
		
		station2.connect(forecaster1);
		station2.connect(sensor2);
		station2.connect(sensor1);
		
		/*
		 * Resulting symmetric connections between the weather stations and apps are as follows.
		 */
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 3 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", forecaster1.toString()); 
		
		/* 
		 * `sensor1` attempts to update the connected weather station `Station@Markham` with
		 * 		its new measurements: temperature (2nd argument, 20) and air pressure (3rd argument, 1025).
		 * 
		 * Consequently, the new temperature and pressure values are immediately used to 
		 * 	update the statistics of ***all*** of Station@Markham's connected forecast apps.
		 * 
		 * For simplicity, assume:
		 * 	- The string name (1st argument) denotes a weather station to which the sensor is connected.
		 * 	- Both temperature (2nd argument) and pressure (3rd argument) are integers.  
		 */
		sensor1.updateMeasurements("Station@Markham", 20, 1025);
		
		/* 
		 * Statistics for the new measurements is updated for `forecaster1`.
		 * 
		 * For the average temperature, display the value with 1 digit after the decimal point.
		 * 
		 * When there's only one reading of pressure (in this case, 1025), 
		 * 	the forecaster always predicts that it is unlikely to rain.
		 */ 
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham {max temperature: 20, avg temperature: 20.0, unlikely to rain}>.", forecaster1.toString());
		/* All other stations and sensors remain unchanged. */
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 3 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
		
		/* 
		 * `sensor2` attempts to update its connected weather station `Station@Markham` with
		 * 		its new measurements: temperature (30) and air pressure (1017).
		 * 
		 * Note that the new air pressure (1017) is decreased from the last reading (1025). 
		 * When the pressure has decreased from the last reading, the forecaster predicts that it's likely to rain. 
		 */
		sensor2.updateMeasurements("Station@Markham", 30, 1017);
		/* 
		 * Statistics is updated for `forecaster1`.
		 */
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham {max temperature: 30, avg temperature: 25.0, likely to rain}>.", forecaster1.toString());
		/* All other stations and sensors remain unchanged. */
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 3 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
		
		/* 
		 * `sensor1` attempts to update its connected weather station `Station@Markham` with
		 * 		its new measurements: temperature (27) and air pressure (1019).
		 * 
		 * Note that the new air pressure (1019) is increased from the last reading (1017). 
		 * When the pressure has stayed the same or increased from the last reading, the forecaster predicts that it's unlikely to rain. 
		 */
		sensor1.updateMeasurements("Station@Markham", 27, 1019);
		/* 
		 * Statistics is updated for `forecaster1`.
		 */
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham {max temperature: 30, avg temperature: 25.7, unlikely to rain}>.", forecaster1.toString());
		/* All other stations and sensors remain unchanged. */
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 3 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
	}
	
	@Test
	public void test_weather_station_04() { 
		WeatherStation station1 = new WeatherStation("Station@NorthYork", 50);
		WeatherStation station2 = new WeatherStation("Station@Markham", 60);
		
		SensorApp sensor1 = new SensorApp("Sensor1234", 20); 
		SensorApp sensor2 = new SensorApp("Sensor1983", 20);
		ForecastApp forecaster1 = new ForecastApp("Forecaster5678", 60);
		
		station1.connect(sensor1); 
		station1.connect(forecaster1);
		station1.connect(sensor2);
		
		station2.connect(forecaster1);
		station2.connect(sensor2);
		station2.connect(sensor1);
		
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 3 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", forecaster1.toString()); 
		
		/* 
		 * `sensor1` attempts to update its connected weather station `Station@Markham` with
		 * 		its new measurements: temperature (2nd argument, 20) and air pressure (3rd argument, 1025).  
		 */
		sensor1.updateMeasurements("Station@Markham", 20, 1025);
		
		/* 
		 * Statistics for the new measurements is updated for `forecaster1`.
		 * For the average temperature, display the value with 1 digit after the decimal point.
		 */ 
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham {max temperature: 20, avg temperature: 20.0, unlikely to rain}>.", forecaster1.toString());
		/* All other stations and sensors remain unchanged. */
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 3 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
		
		ForecastApp forecaster2 = new ForecastApp("Forcaster3330", 30);
		/*
		 * Connect `forcaster2` to `station2`, meaning that
		 * 	its statistics only covers the temperature and pressure readings from now on.
		 */
		station2.connect(forecaster2);
		assertEquals("Weather Forecast App Forcaster3330 is connected to 1 stations: <Station@Markham>.", forecaster2.toString());
		assertEquals("Station@Markham is connected by 4 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234, Weather Forecast App Forcaster3330>.", station2.toString());
		
		/* 
		 * `sensor2` attempts to update its connected weather station `Station@Markham` with
		 * 		its new measurements: temperature (30) and air pressure (1017).
		 * 
		 * Note that:
		 * 	- For forcatser1, the new air pressure (1017) is decreased from the last reading (1025). 
		 * 		When the pressure has decreased from the last reading, the forecaster predicts that it's likely to rain.
		 * 	- For forcaster2, the new temperature and pressure are its first reading.
		 * 		When there's only one reading of pressure (in this case, 1017), 
		 * 			the forecaster always predicts that it is unlikely to rain.
		 */
		sensor2.updateMeasurements("Station@Markham", 30, 1017);
		/* 
		 * Statistics is updated for `forecaster1` and `forecaster2`.
		 */
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham {max temperature: 30, avg temperature: 25.0, likely to rain}>.", forecaster1.toString());
		assertEquals("Weather Forecast App Forcaster3330 is connected to 1 stations: <Station@Markham {max temperature: 30, avg temperature: 30.0, unlikely to rain}>.", forecaster2.toString());
		/* All other stations and sensors remain unchanged. */
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 4 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234, Weather Forecast App Forcaster3330>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
		
		/* 
		 * `sensor1` attempts to update its connected weather station `Station@Markham` with
		 * 		its new measurements: temperature (27) and air pressure (1019).
		 * 
		 * Note that:
		 * 	- For both forecaster1 and forecaster2, 
		 * 		the new air pressure (1019) is increased from the last reading (1017). 
		 * 	  When the pressure has stayed the same or increased from the last reading, the forecaster predicts that it's unlikely to rain.
		 */
		sensor1.updateMeasurements("Station@Markham", 27, 1019);
		/* 
		 * Statistics is updated for `forecaster1` and `forecaster2`.
		 */
		assertEquals("Weather Forecast App Forecaster5678 is connected to 2 stations: <Station@NorthYork, Station@Markham {max temperature: 30, avg temperature: 25.7, unlikely to rain}>.", forecaster1.toString());
		assertEquals("Weather Forecast App Forcaster3330 is connected to 1 stations: <Station@Markham {max temperature: 30, avg temperature: 28.5, unlikely to rain}>.", forecaster2.toString());
		/* All other stations and sensors remain unchanged. */
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983>.", station1.toString());
		assertEquals("Station@Markham is connected by 4 apps: <Weather Forecast App Forecaster5678, Weather Sensor App Sensor1983, Weather Sensor App Sensor1234, Weather Forecast App Forcaster3330>.", station2.toString());
		assertEquals("Weather Sensor App Sensor1234 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor1.toString());
		assertEquals("Weather Sensor App Sensor1983 is connected to 2 stations: <Station@NorthYork, Station@Markham>.", sensor2.toString());
	}
	
	@Test
	public void test_weather_station_05() { 
		WeatherStation station1 = new WeatherStation("Station@NorthYork", 50); 
		
		SensorApp app1 = new SensorApp("Sensor1234", 20);
		ForecastApp app2 = new ForecastApp("Forecaster5678", 60);
		ForecastApp app3 = new ForecastApp("Forecaster3330", 60);
		
		/*
		 * Retrieve the name and index of each forecaster connected to the station with name `Station@Northork`.
		 *  
		 * app1 currently has no connected station with name `Station@NorthYork` 
		 */
		assertEquals("Weather Sensor App Sensor1234 is connected to no stations.", app1.toString());
		String[] forecasters = app1.getConnectedForcastersOf("Station@NorthYork");
		assertTrue(forecasters.length == 0);
		
		station1.connect(app1);
		/* 
		 * Retrieve the name and index of each forecaster connected to the station with name `Station@Northork`.
		 * 
		 * app1 currently has a connected station with name `Station@NorthYork`,
		 * 	which does not have any connected forecasters. 
		 * Note. At index 0 of Station@NorthYork's array of apps, there is the SensorApp object with name `Sensor1234`.
		 */
		assertEquals("Weather Sensor App Sensor1234 is connected to 1 stations: <Station@NorthYork>.", app1.toString());
		assertEquals("Station@NorthYork is connected by 1 apps: <Weather Sensor App Sensor1234>.", station1.toString());
		forecasters = app1.getConnectedForcastersOf("Station@NorthYork");
		assertTrue(forecasters.length == 0);
		
		station1.connect(app2);
		/* 
		 * Retrieve the name and index of each forecaster connected to the station with name `Station@Northork`.
		 * 
		 * app1 currently has a connected station with name `Station@NorthYork`,
		 * 	which has 1 connected forecaster (at index 1 of its array of WeatherApp objects). 
		 */
		assertEquals("Weather Sensor App Sensor1234 is connected to 1 stations: <Station@NorthYork>.", app1.toString());
		assertEquals("Station@NorthYork is connected by 2 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678>.", station1.toString());
		forecasters = app1.getConnectedForcastersOf("Station@NorthYork");
		assertTrue(forecasters.length == 1);
		assertEquals("Forecaster5678 at index 1", forecasters[0]);
		
		station1.connect(app3); 
		/* 
		 * Retrieve the name and index of each forecaster connected to the station with name `Station@Northork`.
		 * 
		 * app1 currently has a connected station with name `Station@NorthYork`,
		 * 	which has 2 connected forecasters (at index 1 and index 2 of its array of WeatherApp objects). 
		 */
		assertEquals("Weather Sensor App Sensor1234 is connected to 1 stations: <Station@NorthYork>.", app1.toString());
		assertEquals("Station@NorthYork is connected by 3 apps: <Weather Sensor App Sensor1234, Weather Forecast App Forecaster5678, Weather Forecast App Forecaster3330>.", station1.toString());
		forecasters = app1.getConnectedForcastersOf("Station@NorthYork");
		assertTrue(forecasters.length == 2);
		assertEquals("Forecaster5678 at index 1", forecasters[0]);
		assertEquals("Forecaster3330 at index 2", forecasters[1]);
		
		/*
		 * Retrieve the name and index of each forecaster connected to the station with name `Station@Markham`.
		 *  
		 * app1 currently has no connected station with name `Station@Markham` 
		 */
		assertEquals("Weather Sensor App Sensor1234 is connected to 1 stations: <Station@NorthYork>.", app1.toString());
		forecasters = app1.getConnectedForcastersOf("Station@Markham");
		assertTrue(forecasters.length == 0);
	}
}
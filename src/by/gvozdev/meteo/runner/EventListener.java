package by.gvozdev.meteo.runner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class EventListener implements SerialPortEventListener {

	int temperature;
	int pressure;
	int altitude;
	double realPressure;
	double realAltetude;

	@Override
	public void serialEvent(SerialPortEvent event) {
		if (event.isRXCHAR() && event.getEventValue() > 0) {
			try {
				String data = MainApp.serialPort.readString(event.getEventValue());			
				System.out.print(data);


				JsonParser parser = new JsonParser();
				JsonElement jsonTree = parser.parse(data);
				
				JsonObject jsonObject = jsonTree.getAsJsonObject();
				JsonElement f1 = jsonObject.get("Temperature");
				JsonElement f2 = jsonObject.get("Pressure");
				JsonElement f3 = jsonObject.get("Altitude");
				JsonElement f4 = jsonObject.get("RealPressure");
				JsonElement f5 = jsonObject.get("RealAltetude");
				
				System.out.println(f1);
				System.out.println(f2);
				System.out.println(f3);
				System.out.println(f4);
				System.out.println(f5);
				

			} catch (SerialPortException ex) {
				System.out.println(ex);
			}
		}
	}

}

package by.gvozdev.meteo.runner;

import jssc.SerialPort;
import jssc.SerialPortException;

public class MainApp {

	static SerialPort serialPort;

	public static void main(String[] args) {

		serialPort = new SerialPort("COM3");

		try {
			serialPort.openPort();
			serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			serialPort.setEventsMask(SerialPort.MASK_RXCHAR);
			serialPort.addEventListener(new EventListener());
		} catch (

		SerialPortException ex) {
			System.out.println(ex);
		}
	}

}

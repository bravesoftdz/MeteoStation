package by.gvozdev.meteo.bean;

public class DataMeteo {

	private double temperature;
	private double pressure;
	private int altitude;
	private int realAltitude;
	private double realPressude;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getRealAltitude() {
		return realAltitude;
	}

	public void setRealAltitude(int realAltitude) {
		this.realAltitude = realAltitude;
	}

	public double getRealPressude() {
		return realPressude;
	}

	public void setRealPressude(double realPressude) {
		this.realPressude = realPressude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + altitude;
		long temp;
		temp = Double.doubleToLongBits(pressure);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + realAltitude;
		temp = Double.doubleToLongBits(realPressude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(temperature);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataMeteo other = (DataMeteo) obj;
		if (altitude != other.altitude)
			return false;
		if (Double.doubleToLongBits(pressure) != Double.doubleToLongBits(other.pressure))
			return false;
		if (realAltitude != other.realAltitude)
			return false;
		if (Double.doubleToLongBits(realPressude) != Double.doubleToLongBits(other.realPressude))
			return false;
		if (Double.doubleToLongBits(temperature) != Double.doubleToLongBits(other.temperature))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DataMeteo [temperature=" + temperature + ", pressure=" + pressure + ", altitude=" + altitude
				+ ", realAltitude=" + realAltitude + "(calculated), realPressude=" + realPressude + "(calculated)]";
	}

}

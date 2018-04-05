#include <Wire.h>
#include <Adafruit_BMP085.h>

/*************************************************** 
  This is an example for the BMP085 Barometric Pressure & Temp Sensor

  Designed specifically to work with the Adafruit BMP085 Breakout 
  ----> https://www.adafruit.com/products/391

  These displays use I2C to communicate, 2 pins are required to  
  interface
  Adafruit invests time and resources providing this open source code, 
  please support Adafruit and open-source hardware by purchasing 
  products from Adafruit!

  Written by Limor Fried/Ladyada for Adafruit Industries.  
  BSD license, all text above must be included in any redistribution
 ****************************************************/

// Connect VCC of the BMP085 sensor to 3.3V (NOT 5.0V!)
// Connect GND to Ground
// Connect SCL to i2c clock - on '168/'328 Arduino Uno/Duemilanove/etc thats Analog 5
// Connect SDA to i2c data - on '168/'328 Arduino Uno/Duemilanove/etc thats Analog 4
// EOC is not used, it signifies an end of conversion
// XCLR is a reset pin, also not used here

Adafruit_BMP085 bmp;

int led = 9;
int p = 3;
  
void setup() {
  Serial.begin(9600);
  if (!bmp.begin()) {
	Serial.println("Could not find a valid BMP085 sensor, check wiring!");
	while (1) {}
  }
  pinMode(led, OUTPUT);
  pinMode(p, OUTPUT); 
}
  
void loop() {

    digitalWrite(led, HIGH);

    tone (p, 100); 
    
  /*
    Serial.print("Temperature = ");
    Serial.print(bmp.readTemperature());
    Serial.println(" *C");
    
    Serial.print("Pressure = ");
    Serial.print(bmp.readPressure());
    Serial.println(" Pa");
    
    Serial.print("Altitude = ");
    Serial.print(bmp.readAltitude());
    Serial.println(" meters");

    Serial.print("Pressure at sealevel (calculated) = ");
    Serial.print(bmp.readSealevelPressure());
    Serial.println(" Pa");

    Serial.print("Real altitude = ");
    Serial.print(bmp.readAltitude(101500));
    Serial.println(" meters");    
*/

    int temperature = bmp.readTemperature();
    int pressure = bmp.readPressure();
    int altetude = bmp.readAltitude();
    double realPressure = bmp.readSealevelPressure();
    double realAltetude = bmp.readAltitude(101500);

   
    Serial.println("{""\"Temperature""\": \""+String(temperature)+"\", ""\"Pressure""\": \""+String(pressure)+"\", ""\"Altitude""\": \""+String(altetude)
    +"\", ""\"realPressure""\": \""+String(realPressure)+"\", ""\"realAltetude""\": \""+String(realAltetude)+"\"}");

    noTone(p);
    digitalWrite(led, LOW);
    
    delay(1500);
}

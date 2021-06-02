# CarController

**This is a simple app to control an Arduino car via Bluetooth. The car has a HC-05 Bluetooth module.**

![Arduino1HC-05](https://user-images.githubusercontent.com/56250173/80868415-b2276580-8c9a-11ea-8b41-772eac3a82df.jpg)

**This is the sketch I uploaded to the Arduino board.**

```javascript
char t;

void setup() {
  //to run once:

  pinMode(13,OUTPUT);   //left motors forward
  pinMode(12,OUTPUT);   //left motors reverse
  pinMode(11,OUTPUT);   //right motors forward
  pinMode(10,OUTPUT);   //right motort reverse
  Serial.begin(9600);
}

void loop() {
  //to run repeatedly:
  if(Serial.available()){
    t = Serial.read();
    Serial.println(t);
  }
    
  if(t == 'F'){
    digitalWrite(13,HIGH);
    digitalWrite(11,HIGH);
  }

  else if(t == 'B'){
    digitalWrite(12,HIGH);
    digitalWrite(10,HIGH);
  }

  else if(t == 'L'){
    digitalWrite(11,HIGH);
  }

  else if(t == 'R'){
    digitalWrite(13, HIGH); 
  }

  else if(t == 'S'){
    digitalWrite(13,LOW);
    digitalWrite(12,LOW);
    digitalWrite(11,LOW);
    digitalWrite(10,LOW);
  }
}

```


## MainActivity  
**This is the main screen of the app, there are three buttons:**  
1."Play" button leads to the ControlActivity  
2."Connect to Device" leads to the list of available devices  
3.Bluetooth icon to disconnect 

![photo5866224486913782924](https://user-images.githubusercontent.com/56250173/80869191-44316d00-8c9f-11ea-9b75-64f63f4922f5.jpg)
 

## Devices Activity
**In this screen you'll find the list of all the available devices you can connect to**

![deviceslist](https://user-images.githubusercontent.com/56250173/80869885-2c5be800-8ca3-11ea-872b-a208cc3e3639.png)

## Control Activity
**In this screen you'll find the buttons to control the car**

![photo5866224486913782925](https://user-images.githubusercontent.com/56250173/80869987-d3d91a80-8ca3-11ea-9f25-d5f6fac10ed8.jpg)
  
   
     
Icons made by https://www.flaticon.com/authors/surang from https://www.flaticon.com/  

Icons made by https://www.flaticon.com/authors/phatplus from https://www.flaticon.com/  

Icons made by https://www.flaticon.com/authors/freepik from https://www.flaticon.com/   

m

import java.util.Random;

class Lights {
  static int LED_Length = 80;
  static double time = 0.0;
  static Random rand = new Random();
  
  static AddressableLED LED = new AddressableLED(0);
  static AddressableLEDBuffer LEDBuffer = new AddressableLEDBuffer(LED_Length);
  
  public static void rainbow () {
    while (true) {
      time += .005;
      for (int i = 0; i < LEDBuffer.getLength(); i++) {
      
        final double constant = i/(LEDBuffer.getLength()*(Math.PI/2));
        double green = Math.sin(time+(constant));
        double blue = Math.cos(time+(constant));
        double red = -Math.sin(time+(constant));

        green *= 255/2;
        blue *= 255/2;
        red *= 255/2;

        green += 255/2;
        blue += 255/2;
        red += 255/2;
        
        LEDBuffer.setRGB(i, (int) red, (int) green, (int) blue);
        LED.setData(LEDBuffer);
      }//for loop
    }//while loop
  }//function


  
  public static void changeColor (boolean outside) {
    if (outside) {
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
      
        for (int index = 0; index < LEDBuffer.getLength(); index++) {
          LEDBuffer.setRGB(index, red, green, blue);
       
        }//for loop
      LED.setData(LEDBuffer);
    } else {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        LEDBuffer.setRGB(index, red, green, blue);
      }//for loop
      LED.setData(LEDBuffer);
    }//if
  }//function

  public static void changeColor (int red, int green, int blue) {
    for (int index = 0; index < LEDBuffer.getLength(); index++) {
      LEDBuffer.setRGB(index, red, green, blue);
    }//for loop
  LED.setData(LEDBuffer);
  }//function

  public static void morseCode () {
        String message = "----. .---- ....- ----.";
    char[] character = message.toCharArray();
    int light = 0;
    while (true) {
      try{
        for (char char2 : character) {
          if (char2 == '-') {
            LEDBuffer.setRGB(light, 255, 255, 255);
            light ++;
            LEDBuffer.setRGB(light, 255, 255, 255);
            light ++;
          } else if (char2 == '.'){
            LEDBuffer.setRGB(light, 255, 255, 255);
            light ++;
          } 
          if (char2 == ' ') {
            LEDBuffer.setRGB(light, 0, 0, 0);
            light ++;
          } else {
            LEDBuffer.setRGB(light, 0, 0, 0);
            light ++;
          }
        }//for
      } catch (Exception e) {
        System.out.println("Ran out of LEDS");
        break;
      } 
    }
  }//function

  public static void morseCode (String message) {
    char[] character = message.toCharArray();
    int light = 0;
    while (true) {
      try{
        for (char char2 : character) {
          if (char2 == '-') {
            LEDBuffer.setRGB(light, 255, 255, 255);
            light ++;
            LEDBuffer.setRGB(light, 255, 255, 255);
            light ++;
          } else if (char2 == '.'){
            LEDBuffer.setRGB(light, 255, 255, 255);
            light ++;
          } 
          if (char2 == ' ') {
            LEDBuffer.setRGB(light, 0, 0, 0);
            light ++;
          } else {
            LEDBuffer.setRGB(light, 0, 0, 0);
            light ++;
          }
        }//for
      } catch (Exception e) {
        System.out.println("Ran out of LEDS");
        break;
      } 
    }
  }//function

  public static void checkard (int[] color1, int[] color2, boolean flashing) {
    if (!flashing) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
        if (index % 2 == 0) {
          LEDBuffer.setRGB(index, color1[0], color1[1], color1[2]);
        } else {
          LEDBuffer.setRGB(index, color2[0], color2[1], color2[2]);
        }//if
      }//for
    } else {
      int times = 0;
      boolean flash;
      while (true){
        if (times % 2 == 0) {
          flash = true;
        } else {
          flash = false;
        }
        for (int index = 0; index < LEDBuffer.getLength(); index++) {
          LEDBuffer.setRGB(index, flash ? color1[0] : color2[0], flash ? color1[1] : color2[1], flash ? color1[2] : color2[2]);
          flash ^= true;
        }//for
        times++;
        LED.setData(LEDBuffer);
      }//while
    }//flashing
  }//function
  
  public static void fotr (int flagIndex, boolean loop) {
    int colorIndex = 0;
    if (flagIndex == 0) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
        switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 88, 196, 236);
          case 1: LEDBuffer.setRGB(index, 240, 204, 220);
          case 2: LEDBuffer.setRGB(index, 240, 164, 196);
          case 4 :LEDBuffer.setRGB(index, 240, 164, 196);
          case 5: LEDBuffer.setRGB(index, 240, 204, 220);
          case 6: LEDBuffer.setRGB(index, 88, 196, 236);
        }
        colorIndex += colorIndex == 6 ? -6 : 1;
        flagIndex += loop ? 1 : 0;
      }//for
    } else if (flagIndex == 1) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
        switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 255, 138, 189);
          case 1: LEDBuffer.setRGB(index, 205, 245, 254);
          case 2: LEDBuffer.setRGB(index, 154, 235, 255);
          case 3: LEDBuffer.setRGB(index, 116, 223, 255);
          case 4: LEDBuffer.setRGB(index, 116, 223, 255);
          case 5:LEDBuffer.setRGB(index, 154, 235, 255);
          case 6: LEDBuffer.setRGB(index, 205, 245, 254);
        }
        colorIndex += colorIndex == 6 ? -6 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 2) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
        switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 91, 206, 250);
          case 1: LEDBuffer.setRGB(index, 245, 169, 184);
          case 2: EDBuffer.setRGB(index, 255, 255, 255);
          case 3: LEDBuffer.setRGB(index, 245, 169, 184);
          case 4: LEDBuffer.setRGB(index, 91, 206, 250);
        }
        colorIndex += colorIndex == 4 ? -4 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 3) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 127, 127, 127);
          case 1: LEDBuffer.setRGB(index, 196, 196, 196);
          case 2: LEDBuffer.setRGB(index, 253, 173, 200);
          case 3: LEDBuffer.setRGB(index, 255, 255, 255);
          case 4: LEDBuffer.setRGB(index, 253, 173, 200);
          case 5: LEDBuffer.setRGB(index, 196, 196, 196);
          case 6: LEDBuffer.setRGB(index, 127, 127, 127);
        }
        colorIndex += colorIndex == 6 ? -6 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 4) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 127, 127, 127);
          case 1: LEDBuffer.setRGB(index, 196, 196, 196);
          case 2: LEDBuffer.setRGB(index, 157, 215, 234);
          case 3: LEDBuffer.setRGB(index, 255, 255, 255);
          case 4: LEDBuffer.setRGB(index, 157, 215, 234);
          case 5:LEDBuffer.setRGB(index, 196, 196, 196);
          case 6: LEDBuffer.setRGB(index, 127, 127, 127);
        }
        colorIndex += colorIndex == 6 ? -6 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 5) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 252, 244, 52);
          case 1: LEDBuffer.setRGB(index, 255, 255, 255);
          case 2: LEDBuffer.setRGB(index, 156, 89, 209);
          case 3: LEDBuffer.setRGB(index, 44, 44, 44);
        }
        colorIndex += colorIndex == 3 ? -3 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 6) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
        switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 255, 33, 140);
          case 1: LEDBuffer.setRGB(index, 255, 216, 0);
          case 2: LEDBuffer.setRGB(index, 33, 177, 255);
        }
        colorIndex += colorIndex == 2 ? -2 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 7) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 214, 2, 112);
          case 1: LEDBuffer.setRGB(index, 155, 79, 150);
          case 2: LEDBuffer.setRGB(index, 0, 56, 168);
        }
        colorIndex += colorIndex == 2 ? -2 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 8) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 253, 139, 168);
          case 1: LEDBuffer.setRGB(index, 255, 255, 255);
          case 2: LEDBuffer.setRGB(index, 253, 139, 168);
        }
        colorIndex += colorIndex == 2 ? -2 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 9) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 152, 191, 220);
          case 1: LEDBuffer.setRGB(index, 241, 245, 226);
          case 2: LEDBuffer.setRGB(index, 152, 191, 220);
        }
        colorIndex += colorIndex == 6 ? -6 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 10) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 7, 141, 112);
          case 1: LEDBuffer.setRGB(index, 38, 206, 170);
          case 2: LEDBuffer.setRGB(index, 152, 232, 193);
          case 3: LEDBuffer.setRGB(index, 255, 255, 255);
          case 4: LEDBuffer.setRGB(index, 123, 173, 226);
          case 5: LEDBuffer.setRGB(index, 80, 73, 204);
          case 6: LEDBuffer.setRGB(index, 61, 26, 120);
        }
        colorIndex += colorIndex == 6 ? -6 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 11) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 213, 45, 0);
          case 1: LEDBuffer.setRGB(index, 239, 118, 39);
          case 2: LEDBuffer.setRGB(index, 255, 154, 86);
          case 3: LEDBuffer.setRGB(index, 255, 255, 255);
          case 4: LEDBuffer.setRGB(index, 209, 98, 164);
          case 5: LEDBuffer.setRGB(index, 181, 86, 144);
          case 6: LEDBuffer.setRGB(index, 163, 2, 98);
        }
        colorIndex += colorIndex == 6 ? -6 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 12) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 255, 255, 255);
          case 1: LEDBuffer.setRGB(index, 241, 187, 3);
          case 2: LEDBuffer.setRGB(index, 255, 255, 255);
          case 3: LEDBuffer.setRGB(index, 8, 158, 227);
          case 4: LEDBuffer.setRGB(index, 228, 5, 82);
          case 5: LEDBuffer.setRGB(index, 52, 12, 68);
        }
        colorIndex += colorIndex == 5 ? -5 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 13) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 254, 154, 206);
          case 1: LEDBuffer.setRGB(index, 255, 83, 191);
          case 2: LEDBuffer.setRGB(index, 32, 0, 68);
          case 3: LEDBuffer.setRGB(index, 103, 96, 254);
          case 4: LEDBuffer.setRGB(index, 142, 166, 255);
        }
        colorIndex += colorIndex == 4 ? -4 : 1;
        flagIndex += loop ? 1 : 0;
      }
    } else if (flagIndex == 14) {
      for (int index = 0; index < LEDBuffer.getLength(); index++) {
         switch (colorIndex) {
          case 0: LEDBuffer.setRGB(index, 255, 118, 164);
          case 1: LEDBuffer.setRGB(index, 255, 255, 255);
          case 2: LEDBuffer.setRGB(index, 192, 17, 215);
          case 3: LEDBuffer.setRGB(index, 0, 0, 0);
          case 4: LEDBuffer.setRGB(index, 47, 60, 190);
        }
      colorIndex += colorIndex == 3 ? -3 : 1;
      flagIndex += loop ? -flagIndex : 0;
      }
    }
  }//function
}

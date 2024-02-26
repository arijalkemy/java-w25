package org.example;


public class Main {
  public static void main(String[] args) {
    Carrera car = new Carrera(203.,2303.,"dubai", 2);
    car.darDeAltaAuto(1000,1000,1000., "djo231");
    car.darDeAltaAuto(1,1,1., "ejn293");
    System.out.println(car.ganador());
    }
  }

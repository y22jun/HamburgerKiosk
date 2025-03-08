package main.java;

import main.java.io.input.Input;
import main.java.kiosk.Kiosk;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.startKiosk();
        Input.close();
    }
}

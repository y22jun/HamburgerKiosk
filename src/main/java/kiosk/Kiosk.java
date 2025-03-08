package main.java.kiosk;

import main.java.io.input.Input;
import main.java.io.output.MenuOutput;
import main.java.root.Root;

public class Kiosk {

    public void startKiosk() {
        while (true) {
            MenuOutput.outputMenu();
            String inputMenuNumber = Input.nextLine();

            Root menu = Root.fromNumber(inputMenuNumber);
            menu.execute();

            if (menu == Root.EXIT) {
                break;
            }
        }
    }
}

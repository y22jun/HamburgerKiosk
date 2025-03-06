package kiosk;

import io.input.Input;
import io.output.MenuOutput;
import root.Root;

public class Kiosk {

    public void startKiosk() {
        while (true) {
            MenuOutput.outputMenu();
            String inputMenuNumber = Input.nextLine();
            Root menu = Root.fromNumber(inputMenuNumber);
            menu.execute();

            if (menu == Root.EXIT) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }
        }
    }
}

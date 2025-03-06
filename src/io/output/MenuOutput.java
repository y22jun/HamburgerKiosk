package io.output;

import root.Root;

public class MenuOutput {

    public static void outputMenu() {
        for (Root menu : Root.values()) {
            System.out.println(menu.getInputMenuNumber() + ". " + menu.getInputMenuDescription());
        }
    }
}

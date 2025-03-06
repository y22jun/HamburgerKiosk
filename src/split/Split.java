package split;

import separator.Separator;

public class Split {

    public static String[] splitInput(String input) {
        return input.split(Separator.COMMA);
    }
}

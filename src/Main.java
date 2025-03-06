import io.input.Input;
import kiosk.Kiosk;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.startKiosk();
        Input.close();
    }
}

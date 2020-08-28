import com.currency.controller.Controller;
import com.currency.model.CurrencyData;

// This class will invoke the controller class
public class MainClass {
    public static void main(String args[]) {
        Controller controller = new Controller();
        CurrencyData currencyData = controller.convertCurrencies("USD", "INR", 20);
        System.out.println(currencyData);
    }
}

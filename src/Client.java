import javax.swing.*;

public class Client {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalUI calUI = new CalUI();
                Logger logger = new TextFileLogger("calculator_logs.txt");
                calUI.addLogger(logger);
            }
        });
    }
}

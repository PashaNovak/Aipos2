package controller;

import org.apache.log4j.Logger;
import view.Main;
/**
 * Created by G710 on 25.03.2017.
 */
public class ClientPoint {
    final static Logger log = Logger.getLogger(controller.ClientPoint.class);
    public static void main(String[] args) {
        log.info("Logger");
        javax.swing.SwingUtilities.invokeLater(() -> new Main());
    }
}


package app;

import controller.DeviceController;
import java.awt.EventQueue;
import view.MainJFrame;

/**
 *
 * @author ADMIN
 */
public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                MainJFrame mf = new MainJFrame();
        
                DeviceController dc = new DeviceController(mf);
                dc.showDeviceView();
            }
        });
    }
}

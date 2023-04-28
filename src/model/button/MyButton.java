
package model.button;

import javax.swing.JButton;

/**
 *
 * @author ADMIN
 */
public class MyButton extends JButton{

    private String btnName;
    
    public MyButton(String btnName) {
        this.btnName = btnName;
        init();
    }
    
    private void init() {
        this.setText(btnName);
        this.setFocusable(false);
    }
}

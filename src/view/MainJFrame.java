
package view;

import model.button.MyButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionListener;
import model.Device;
import model.DeviceTableModel;
import model.Validation;

/**
 *
 * @author ADMIN
 */
public class MainJFrame extends JFrame{

    private JTable deviceTable;
    
    private MyButton addBtn;
    private MyButton editBtn;
    private MyButton saveBtn;
    private MyButton deleteBtn;
    private MyButton cancelBtn;
    
    private JTextField deviceID;
    private JTextField deviceName;
    private JTextField deviceQuantity;
    private JTextField devicePrice;
    
    public MainJFrame() {
        super("Device Management");
        initComponents();
//        setLookAndFeel();
    }
    
    private void initComponents() {
        
        deviceTable = new JTable(); 
        
        this.add(new JScrollPane(deviceTable), BorderLayout.CENTER); 
        this.add(creatWrapPanel(), BorderLayout.SOUTH);
        
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
    }
    
    private JPanel createControlPanel() {
        
        addBtn = new MyButton("Add");
        editBtn = new MyButton("Edit");
        saveBtn = new MyButton("Save");
        deleteBtn = new MyButton("Delete");
        cancelBtn = new MyButton("Cancel");
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.add(addBtn);
        controlPanel.add(editBtn);
        controlPanel.add(saveBtn);
        controlPanel.add(deleteBtn);
        controlPanel.add(cancelBtn);
        
        return controlPanel;
    }
    
    private JPanel createInputPanel() {
    
        JLabel idLabel = new JLabel("Device ID: ");
        deviceID = new JTextField();
        deviceID.setEditable(false);
        
        JLabel nameLabel = new JLabel("Device name: ");
        deviceName = new JTextField();
        
        JLabel quantityLabel = new JLabel("Quantity: ");
        deviceQuantity = new JTextField();
        
        JLabel priceLabel = new JLabel("Price per one device: ");
        devicePrice = new JTextField();
        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        
        inputPanel.add(idLabel);
        inputPanel.add(deviceID);
        
        inputPanel.add(nameLabel);
        inputPanel.add(deviceName);
        
        inputPanel.add(quantityLabel);
        inputPanel.add(deviceQuantity);
        
        inputPanel.add(priceLabel);
        inputPanel.add(devicePrice);
        
        return inputPanel;
    }
    
    private JPanel creatWrapPanel() {
        JPanel wrapPanel = new JPanel(new BorderLayout());
        wrapPanel.add(createControlPanel(), BorderLayout.CENTER);
        wrapPanel.add(createInputPanel(), BorderLayout.SOUTH);

        return wrapPanel;
    }
    
    private void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            JOptionPane.showConfirmDialog(this, e);
        }
    }
    
    // set table model
    public void showListDevice(DeviceTableModel tableModel) {
        deviceTable.setModel(tableModel);
    }
    
    public void addAddBtnListener(ActionListener listener) {
        addBtn.addActionListener(listener);
    }
    
    public void addEditBtnListener(ActionListener listener) {
        editBtn.addActionListener(listener);
    }
    
    public void addSaveBtnListener(ActionListener listener) {
        saveBtn.addActionListener(listener);
    }
    
    public void addDeleteBtnListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
    
    public void addCancelBtnListener(ActionListener listener) {
        cancelBtn.addActionListener(listener);
    }
    
    public void addTableMouseListener(ListSelectionListener listener) {
        deviceTable.getSelectionModel().addListSelectionListener(listener);
    }
    
    public Device getDeviceData() {
        String id = deviceID.getText();
        String name = deviceName.getText();
        String quantity = deviceQuantity.getText();
        String price = devicePrice.getText();
        Device d = Validation.checkDeviceInfo(id, name, quantity, price);
        if(d != null) {
           return d;
        }
        return null;
    }
    
    public void fillInputForm() {
        int seletedRow = deviceTable.getSelectedRow();
        if(seletedRow >= 0) {
            deviceID.setText(deviceTable.getValueAt(seletedRow, 0).toString());
            deviceName.setText(deviceTable.getValueAt(seletedRow, 1).toString());
            deviceQuantity.setText(deviceTable.getValueAt(seletedRow, 2).toString());
            devicePrice.setText(deviceTable.getValueAt(seletedRow, 3).toString());
        }
    }
    
    public void unfillInputForm() {
        deviceID.setText("");
        deviceName.setText("");
        deviceQuantity.setText("");
        devicePrice.setText("");
    }
    
    public MyButton getAddBtn() {
        return addBtn;
    }
    
    public JTable getTable() {
        return deviceTable;
    }
}

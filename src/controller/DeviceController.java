package controller;

import dao.DeviceDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Device;
import model.DeviceTableModel;
import view.MainJFrame;

/**
 *
 * @author ADMIN
 */
public class DeviceController {

    private DeviceDao deviceDao;
    private MainJFrame deviceView;
    private DeviceTableModel tableModel;


    public DeviceController(MainJFrame deviceView) {
        this.deviceView = deviceView;
        deviceDao = new DeviceDao();
        tableModel = new DeviceTableModel();
        
        deviceView.addAddBtnListener(new AddActionListener());
        deviceView.addTableMouseListener(new AddTableSelectionListener());
        deviceView.addEditBtnListener(new EditActionListener());
        deviceView.addDeleteBtnListener(new DeleteActionListener());
        deviceView.addSaveBtnListener(new SaveActionListener());
        deviceView.addCancelBtnListener(new CancelActionListener());
    }

    public void showDeviceView() {
        List<Device> devices = deviceDao.getListDevice();
        tableModel.setData(devices);
        deviceView.showListDevice(tableModel);
        deviceView.setVisible(true);
    }

    private class AddActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Device device = deviceView.getDeviceData();
            if (device != null) {
                boolean success = deviceDao.add(device);
                if (success) {
                    tableModel.setData(deviceDao.getListDevice());
                    JOptionPane.showMessageDialog(deviceView, "Added successfully!");
                } else {
                    JOptionPane.showMessageDialog(deviceView, "Added failed!");
                }
            } else {
                JOptionPane.showMessageDialog(deviceView, "Please select a row");
            }
        }

    }

    private class EditActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Device device = deviceView.getDeviceData();
            if (device != null) {
                boolean success = deviceDao.edit(device);
                if (success) {
                    tableModel.setData(deviceDao.getListDevice());
                    JOptionPane.showMessageDialog(deviceView, "Edited successfully!");
                    deviceView.getAddBtn().setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(deviceView, "Edited failed!");
                }
            } else {
                JOptionPane.showMessageDialog(deviceView, "Please select a row");
            }

        }

    }

    private class SaveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(deviceView, "null");
        }

    }

    private class DeleteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Device device = deviceView.getDeviceData();
            if (device != null) {
                boolean success = deviceDao.delete(device);
                if (success) {
                    tableModel.setData(deviceDao.getListDevice());
                    JOptionPane.showMessageDialog(deviceView, "Deleteted successfully!");
                } else {
                    JOptionPane.showMessageDialog(deviceView, "Deleteted failed!");
                }
            } else {
                JOptionPane.showMessageDialog(deviceView, "Please select a row");
            }
        }
    }

    public class AddTableSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            deviceView.fillInputForm();
            deviceView.getAddBtn().setEnabled(false);
        }

    }

    private class CancelActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deviceView.unfillInputForm();
            deviceView.getTable().clearSelection();
            deviceView.getAddBtn().setEnabled(true);
        }
    }
}

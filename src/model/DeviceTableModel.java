
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADMIN
 */
public class DeviceTableModel extends AbstractTableModel{

    private String[] columnNames = {"ID", "Device Name", "Quantity", "Price/1"};
    private List<Device> devices;
    
    public DeviceTableModel() {
        devices = new ArrayList<>();
    }
    
    public void setData(List<Device> devices) {
        this.devices = devices;
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }
    
    @Override
    public int getRowCount() {
        return devices.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Device d = devices.get(rowIndex);
        switch(columnIndex) {
            case 0 -> {
                return d.getDeviceId();
            } 
            case 1 -> {
                return d.getDeviceName();
            } 
            case 2 -> {
                return d.getDeviceQuantity();
            } 
            case 3 -> {
                return d.getDevicePrice();
            }
        }
        return null;
    }
    
}


package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Device;

/**
 *
 * @author ADMIN
 */
public class DeviceDao {
    
    public List<Device> getListDevice() {
        List<Device> devices = new ArrayList<>();
        String query = "SELECT * FROM devices";
        
        try (Connection conn = new ConnectDB().getConnection(); 
                Statement st = conn.createStatement(); 
                ResultSet rs = st.executeQuery(query)){
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Integer quantity = rs.getInt("quantity");
                Double price = rs.getDouble("price");
                devices.add(new Device(id, name, quantity, price));
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return devices;
    }
    
    public boolean add(Device device) {
        String query = "INSERT INTO devices(name, quantity, price) VALUES (?, ?, ?)";
        try (Connection conn = new ConnectDB().getConnection();
                PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, device.getDeviceName());
            ps.setString(2, device.getDeviceQuantity() + "");
            ps.setString(3, device.getDevicePrice() + "");
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
    public boolean edit(Device device) {
        String query = "UPDATE devices SET name = ?, quantity = ?, price = ? WHERE id = ?";
        try (Connection conn = new ConnectDB().getConnection();
                PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, device.getDeviceName());
            ps.setString(2, device.getDeviceQuantity() + "");
            ps.setString(3, device.getDevicePrice() + "");
            ps.setString(4, device.getDeviceId() + "");
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
    public boolean save(Device device) {
        String query = "UPDATE devices SET name = ?, quantity = ?, price = ? WHERE id = ?";
        try (Connection conn = new ConnectDB().getConnection();
                PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, device.getDeviceName());
            ps.setString(2, device.getDeviceQuantity() + "");
            ps.setString(3, device.getDevicePrice() + "");
            ps.setString(4, device.getDeviceId() + "");
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
    public boolean delete(Device device) {
        String query = "DELETE FROM devices WHERE id = ?";
        try (Connection conn = new ConnectDB().getConnection();
                PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, device.getDeviceId() + "");
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
}

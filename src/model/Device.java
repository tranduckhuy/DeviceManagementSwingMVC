
package model;

/**
 *
 * @author ADMIN
 */
public class Device {
    
    private int deviceId;
    private String deviceName;
    private int deviceQuantity;
    private double devicePrice;

    public Device() {
    }

    public Device(String deviceName, int deviceQuantity, double devicePrice) {
        this.deviceName = deviceName;
        this.deviceQuantity = deviceQuantity;
        this.devicePrice = devicePrice;
    }
    
    public Device(int deviceId, String deviceName, int deviceQuantity, double devicePrice) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceQuantity = deviceQuantity;
        this.devicePrice = devicePrice;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDeviceQuantity() {
        return deviceQuantity;
    }

    public void setDeviceQuantity(int deviceQuantity) {
        this.deviceQuantity = deviceQuantity;
    }

    public double getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(double devicePrice) {
        this.devicePrice = devicePrice;
    }
    
}

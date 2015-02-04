package sintef.android.controller.sensor;

/**
 * Created by samyboy89 on 03/02/15.
 */
public class SensorSession {

    private final String mConstantUniqueIdForDeviceLocationAndType;
    private final SensorType mSensorType;
    private final SensorLocation mSensorLocation;

    protected SensorSession(String constantUniqueIdForDeviceSessionLocationAndType, SensorType sensorType, SensorLocation sensorLocation) {
        mConstantUniqueIdForDeviceLocationAndType = constantUniqueIdForDeviceSessionLocationAndType;
        mSensorType = sensorType;
        mSensorLocation = sensorLocation;
    }

    protected SensorSession(String constantUniqueIdForDeviceSessionLocationAndType) {
        mConstantUniqueIdForDeviceLocationAndType = constantUniqueIdForDeviceSessionLocationAndType;
        mSensorType = null;
        mSensorLocation = null;
    }

    public String getId() {
        return mConstantUniqueIdForDeviceLocationAndType;
    }

    public SensorType getSensorType() {
        return mSensorType;
    }

    public SensorLocation getSensorLocation() {
        return mSensorLocation;
    }

    @Override
    public int hashCode() {
        return mConstantUniqueIdForDeviceLocationAndType.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SensorSession))
            return false;
        if (obj == this)
            return true;

        SensorSession rhs = (SensorSession) obj;
        return mConstantUniqueIdForDeviceLocationAndType.equals(rhs.mConstantUniqueIdForDeviceLocationAndType);
    }
}
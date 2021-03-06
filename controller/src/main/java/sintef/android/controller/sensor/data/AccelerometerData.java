/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

package sintef.android.controller.sensor.data;

public class AccelerometerData extends SensorDataObject {
    /**
     * <h4>{@link android.hardware.Sensor#TYPE_ACCELEROMETER Sensor.TYPE_ACCELEROMETER}:</h4>
     *
     * All values are in SI units (m/s^2)
     *
     * <ul>
     * <li> values[0]: Acceleration minus Gx on the x-axis </li>
     * <li> values[1]: Acceleration minus Gy on the y-axis </li>
     * <li> values[2]: Acceleration minus Gz on the z-axis </li>
     * </ul>
     *
     * <p>
     * A sensor of this type measures the acceleration applied to the device
     * (<b>Ad</b>). Conceptually, it does so by measuring forces applied to the
     * sensor itself (<b>Fs</b>) using the relation:
     * </p>
     *
     * <b><center>Ad = - &#8721;Fs / mass</center></b>
     *
     * <p>
     * In particular, the force of gravity is always influencing the measured
     * acceleration:
     * </p>
     *
     * <b><center>Ad = -g - &#8721;F / mass</center></b>
     *
     * <p>
     * For this reason, when the device is sitting on a table (and obviously not
     * accelerating), the accelerometer reads a magnitude of <b>g</b> = 9.81
     * m/s^2
     * </p>
     *
     * <p>
     * Similarly, when the device is in free-fall and therefore dangerously
     * accelerating towards to ground at 9.81 m/s^2, its accelerometer reads a
     * magnitude of 0 m/s^2.
     * </p>
     *
     * <p>
     * It should be apparent that in order to measure the real acceleration of
     * the device, the contribution of the force of gravity must be eliminated.
     * This can be achieved by applying a <i>high-pass</i> filter. Conversely, a
     * <i>low-pass</i> filter can be used to isolate the force of gravity.
     * </p>
     *
     * <pre class="prettyprint">
     *
     *     public void onSensorChanged(SensorEvent event) {
     *          // alpha is calculated as t / (t + dT)
     *          // with t, the low-pass filter's time-constant
     *          // and dT, the event delivery rate
     *
     *          final float alpha = 0.8;
     *
     *          gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
     *          gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
     *          gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
     *
     *          linear_acceleration[0] = event.values[0] - gravity[0];
     *          linear_acceleration[1] = event.values[1] - gravity[1];
     *          linear_acceleration[2] = event.values[2] - gravity[2];
     *     }
     * </pre>
     *
     * <p>
     * <u>Examples</u>:
     * <ul>
     * <li>When the device lies flat on a table and is pushed on its left side
     * toward the right, the x acceleration value is positive.</li>
     *
     * <li>When the device lies flat on a table, the acceleration value is
     * +9.81, which correspond to the acceleration of the device (0 m/s^2) minus
     * the force of gravity (-9.81 m/s^2).</li>
     *
     * <li>When the device lies flat on a table and is pushed toward the sky
     * with an acceleration of A m/s^2, the acceleration value is equal to
     * A+9.81 which correspond to the acceleration of the device (+A m/s^2)
     * minus the force of gravity (-9.81 m/s^2).</li>
     * </ul>
     */

    public AccelerometerData(float[] values) {
        super(values);
    }

    public AccelerometerData(float x, float y, float z) {
        super(new float[] {x, y, z});
    }

    public float getX() {
        return getValues()[0];
    }

    public float getY() {
        return getValues()[1];
    }

    public float getZ() {
        return getValues()[2];
    }
}

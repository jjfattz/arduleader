/**
 * Generated class : msg_hil_sensor
 * DO NOT MODIFY!
 **/
package org.mavlink.messages.ardupilotmega;
import org.mavlink.messages.MAVLinkMessage;
import org.mavlink.IMAVLinkCRC;
import org.mavlink.MAVLinkCRC;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/**
 * Class msg_hil_sensor
 * The IMU readings in SI units in NED body frame
 **/
public class msg_hil_sensor extends MAVLinkMessage {
  public static final int MAVLINK_MSG_ID_HIL_SENSOR = 107;
  private static final long serialVersionUID = MAVLINK_MSG_ID_HIL_SENSOR;
  public msg_hil_sensor(int sysId, int componentId) {
    messageType = MAVLINK_MSG_ID_HIL_SENSOR;
    this.sysId = sysId;
    this.componentId = componentId;
    length = 64;
}

  /**
   * Timestamp (microseconds, synced to UNIX time or since system boot)
   */
  public long time_usec;
  /**
   * X acceleration (m/s^2)
   */
  public float xacc;
  /**
   * Y acceleration (m/s^2)
   */
  public float yacc;
  /**
   * Z acceleration (m/s^2)
   */
  public float zacc;
  /**
   * Angular speed around X axis in body frame (rad / sec)
   */
  public float xgyro;
  /**
   * Angular speed around Y axis in body frame (rad / sec)
   */
  public float ygyro;
  /**
   * Angular speed around Z axis in body frame (rad / sec)
   */
  public float zgyro;
  /**
   * X Magnetic field (Gauss)
   */
  public float xmag;
  /**
   * Y Magnetic field (Gauss)
   */
  public float ymag;
  /**
   * Z Magnetic field (Gauss)
   */
  public float zmag;
  /**
   * Absolute pressure in millibar
   */
  public float abs_pressure;
  /**
   * Differential pressure (airspeed) in millibar
   */
  public float diff_pressure;
  /**
   * Altitude calculated from pressure
   */
  public float pressure_alt;
  /**
   * Temperature in degrees celsius
   */
  public float temperature;
  /**
   * Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature
   */
  public long fields_updated;
/**
 * Decode message with raw data
 */
public void decode(ByteBuffer dis) throws IOException {
  time_usec = (long)dis.getLong();
  xacc = (float)dis.getFloat();
  yacc = (float)dis.getFloat();
  zacc = (float)dis.getFloat();
  xgyro = (float)dis.getFloat();
  ygyro = (float)dis.getFloat();
  zgyro = (float)dis.getFloat();
  xmag = (float)dis.getFloat();
  ymag = (float)dis.getFloat();
  zmag = (float)dis.getFloat();
  abs_pressure = (float)dis.getFloat();
  diff_pressure = (float)dis.getFloat();
  pressure_alt = (float)dis.getFloat();
  temperature = (float)dis.getFloat();
  fields_updated = (int)dis.getInt()&0x00FFFFFFFF;
}
/**
 * Encode message with raw data and other informations
 */
public byte[] encode() throws IOException {
  byte[] buffer = new byte[8+64];
   ByteBuffer dos = ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN);
  dos.put((byte)0xFE);
  dos.put((byte)(length & 0x00FF));
  dos.put((byte)(sequence & 0x00FF));
  dos.put((byte)(sysId & 0x00FF));
  dos.put((byte)(componentId & 0x00FF));
  dos.put((byte)(messageType & 0x00FF));
  dos.putLong(time_usec);
  dos.putFloat(xacc);
  dos.putFloat(yacc);
  dos.putFloat(zacc);
  dos.putFloat(xgyro);
  dos.putFloat(ygyro);
  dos.putFloat(zgyro);
  dos.putFloat(xmag);
  dos.putFloat(ymag);
  dos.putFloat(zmag);
  dos.putFloat(abs_pressure);
  dos.putFloat(diff_pressure);
  dos.putFloat(pressure_alt);
  dos.putFloat(temperature);
  dos.putInt((int)(fields_updated&0x00FFFFFFFF));
  int crc = MAVLinkCRC.crc_calculate_encode(buffer, 64);
  crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
  byte crcl = (byte) (crc & 0x00FF);
  byte crch = (byte) ((crc >> 8) & 0x00FF);
  buffer[70] = crcl;
  buffer[71] = crch;
  return buffer;
}
public String toString() {
return "MAVLINK_MSG_ID_HIL_SENSOR : " +   "  time_usec="+time_usec+  "  xacc="+xacc+  "  yacc="+yacc+  "  zacc="+zacc+  "  xgyro="+xgyro+  "  ygyro="+ygyro+  "  zgyro="+zgyro+  "  xmag="+xmag+  "  ymag="+ymag+  "  zmag="+zmag+  "  abs_pressure="+abs_pressure+  "  diff_pressure="+diff_pressure+  "  pressure_alt="+pressure_alt+  "  temperature="+temperature+  "  fields_updated="+fields_updated;}
}

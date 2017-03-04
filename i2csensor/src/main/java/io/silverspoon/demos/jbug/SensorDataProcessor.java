package io.silverspoon.demos.jbug;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mjaros on 2.3.16.
 */
public class SensorDataProcessor implements Processor {
//   private Configuration config = Configuration.getInstance();
   private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   private static final String SENSOR_NAME = "Sensor@Fi";


//   @Override
   public void process(Exchange exchange) throws Exception {

      final Message in = exchange.getIn();
      final String body = (String) in.getBody();
      final SensorData sensorData = new SensorData();
      sensorData
            .sensorName(SENSOR_NAME)
            .temperature(Byte.decode("0x" + body.substring(0, 2)))
            .humidity(Byte.decode("0x" + body.substring(2, 4)))
            .timestamp(TIMESTAMP_FORMAT.format(new Date()));
      in.setBody(sensorData);
   }
}

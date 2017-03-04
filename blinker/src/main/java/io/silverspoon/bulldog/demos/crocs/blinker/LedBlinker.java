package io.silverspoon.bulldog.demos.crocs.blinker;

import io.silverspoon.bulldog.core.gpio.DigitalOutput;
import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.core.platform.Platform;
import io.silverspoon.bulldog.core.util.BulldogUtil;

public class LedBlinker {

   public static void main(String[] args) {
      Board board = Platform.createBoard();

      DigitalOutput out = board.getPins().get(4).as(DigitalOutput.class);

      for (int k = 0; k < 10; k++) {
         if (k % 2 == 0) {
            out.high();
         } else {
            out.low();
         }
         BulldogUtil.sleepMs(1000);
      }
      out.low();
   }
}

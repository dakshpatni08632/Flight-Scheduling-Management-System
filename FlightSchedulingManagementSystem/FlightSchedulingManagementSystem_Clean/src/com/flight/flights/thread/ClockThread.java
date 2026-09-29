package com.flight.flights.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockThread extends Thread {

    private boolean running = true;

    @Override
    public void run() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        while (running) {

            System.out.println(
                    "Live System Time: "
                            + LocalDateTime.now().format(formatter));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void stopClock() {
        running = false;
        interrupt();
    }
}

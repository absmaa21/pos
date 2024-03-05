package demo01_watchGUI;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeLabel extends JLabel implements Runnable {

    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void run() { // this method contains the code, that should run in parallel
        this.setText("00:00:00");
        long startTime = System.nanoTime();

        while (!Thread.interrupted()) {
            //LocalTime time = LocalTime.now();
            //this.setText(DTF.format(time));

            long timeDiff = System.nanoTime() - startTime;
            this.setText(DTF.format(LocalTime.ofNanoOfDay(timeDiff)));

            // High CPU usage
            // Unnecessary GUI updates
            // Hard to interact with GUI
            // Waste of resources
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                // If "Interrupt" is called on the thread in the meantime, the loop needs to be exited
                break;
            }
        }
    }
}

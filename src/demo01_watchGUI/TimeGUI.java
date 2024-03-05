package demo01_watchGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TimeGUI {
    private JPanel paMain;
    private JPanel paMenu;
    private JButton btStartTime;
    private JButton btEndTime;
    private JLabel lbTime;
    private Thread thread = null;

    public TimeGUI() {
        btStartTime.addActionListener(this::onStartTime);
        btEndTime.addActionListener(this::onEndTime);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TimeGUI");
        frame.setContentPane(new TimeGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void onStartTime(ActionEvent e) {
        if(thread == null || !thread.isAlive()) {
            thread = new Thread((TimeLabel) lbTime);
            // Create a new thread
            // Thread state: NEW (Thread was created, but not started yet)
            thread.start();
            // the run() method is never called directly
            // Thread state: RUNNABLE (Thread waits to be assigned to a slot by the CPU and run() is called

        }
    }

    private void onEndTime(ActionEvent e) {
        if(thread != null || thread.isAlive()) {
            thread.interrupt();
            // The interrupt flag is set and the thread is interrupted
        }
    }

    private void createUIComponents() {
        lbTime = new TimeLabel();
    }
}

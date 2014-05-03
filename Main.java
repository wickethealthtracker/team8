/**
 * Author Jack
 * 
 * The purpose of this class is control the program flow, change panels and call
 * to save/load program data on close/open.
 */

//Project Package
package cse_360_project;

//Necessary Imports
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
  
  public static void main(String[] args) { 
    RecordManager.getInstanceOf().load("WorkoutRecord.ser","MetricRecord.ser");
    
    //Build the central JFrame and fill with WindowListeners and closing procedures
    final JFrame frame = new JFrame("Wicket Health Tracker");
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        RecordManager.getInstanceOf().save("WorkoutRecord.ser","MetricRecord.ser");
        frame.dispose();
        System.exit(0);
      }
    });
    
    //Display the program
    frame.getContentPane().add(new MainPanel());
    frame.pack();
    frame.setSize(1440, 850);
    frame.setVisible(true);
  }

  
}

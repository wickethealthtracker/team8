
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
  
  
  public static void main(String[] args) { 
    RecordManager.getInstanceOf().load("record.ser");
    
    final JFrame frame = new JFrame("Wicket Health Tracker");
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        RecordManager.getInstanceOf().save("record.ser");
        frame.dispose();
        System.exit(0);
      }
    });
    frame.getContentPane().add(new MainPanel());
    frame.pack();
    frame.setVisible(true);
  }

  
}

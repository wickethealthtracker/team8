/**
 * The purpose of this class is to display all the UI buttons
 * on the left hand side of the MainPanel
 */

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
  
public class ButtonPanel extends JPanel {
  MainPanel parent;
  
  /* ADD YOUR CODE HERE */
  public ButtonPanel(MainPanel p) {
    parent = p;
    final JButton workout = new JButton("Input Workout");
    
    workout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         parent.showPanel(1); // TODO change to enum
      }
    });
    
    final JButton metrics = new JButton("Input Metrics");
    metrics.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        parent.showPanel(2); // TODO change to enum
      }
    });
    this.add(workout);
    this.add(metrics);
  }
}

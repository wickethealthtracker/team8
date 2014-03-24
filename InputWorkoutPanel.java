
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InputWorkoutPanel extends JPanel {
  
  public InputWorkoutPanel() {
    // TODO use a layout; for now using default flow flayout
    this.add(new JLabel("Running:"));
    this.add(new JTextField());
    this.add(new JButton("Save"));
  }  
  
}

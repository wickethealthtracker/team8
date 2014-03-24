
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InputMetricsPanel extends JPanel {
  
  public InputMetricsPanel() {
    // TODO use a layout; for now using default flow flayout
    this.add(new JLabel("Blood Pressure:"));
    this.add(new JTextField());
    this.add(new JButton("Save"));
  }
  
}

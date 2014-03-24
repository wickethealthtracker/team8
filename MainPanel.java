
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
  
  public static final int SPLASH_PANEL = 0;
  public static final int METRICS_PANEL = 1;
  public static final int WORKOUT_PANEL = 2;

  public MainPanel() {
    // set up layout of panel, add top level buttons
    GridLayout layout = new GridLayout(1,2);
    this.setLayout(layout);
    this.add(new ButtonPanel(this));
    this.add(new SplashScreenPanel());
    
  }
  
  public void showPanel(int panel) { // TODO switch int to enum
    switch(panel) {
      case SPLASH_PANEL:
        break;
      case METRICS_PANEL:
        System.out.println("switching to metrics panel");
        this.remove(1); // TODO get index of right hand panel dynamically
        this.add(new InputMetricsPanel());        
        break;
      case WORKOUT_PANEL:
        System.out.println("switching to workout panel");
        this.remove(1); // TODO get index of right hand panel dynamically
        this.add(new InputWorkoutPanel());
        break;
    }
    
    this.revalidate();
    this.repaint();
  }
  
}

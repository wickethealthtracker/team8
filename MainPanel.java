/*
 * Author Jack 
 *
 * Main software panel which includes buttons for different activities and a 
 * display area for to input or represent the data for the requested activity.
 *
 */

//Project package
package cse_360_project;

//Necessary imports
import com.sun.javafx.application.PlatformImpl;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
  
  //Switch statement ints for which panel to display
  public static final int SPLASH_PANEL = 0;
  public static final int METRICS_PANEL = 1;
  public static final int WORKOUT_PANEL = 2;
  public static final int LINE_PANEL = 3;
  public static final int PIE_PANEL = 4;
  public static final int SCATTER_PANEL = 5;
  
  private static LineGraphPanel lineGraphPanel;
  private static PieChartPanel pieChartPanel;
  private static ScatterPanel scatterPanel;  

  public MainPanel() {
      
    // set up layout of panel, add top level buttons
    GridLayout layout = new GridLayout(1,2);
    this.setLayout(layout);
    this.add(new ButtonPanel(this));
    this.add(new SplashScreenPanel());
    
    //Establish panels
    PlatformImpl.setImplicitExit(false);
    lineGraphPanel = new LineGraphPanel();
    pieChartPanel = new PieChartPanel();
    scatterPanel = new ScatterPanel();
    
  }
  
  public void showPanel(int panel) { 
    
    //Switch case to input which panel should be displayed
    switch(panel) {
        case SPLASH_PANEL:
            //Display the Splash_Panel
            System.out.println("switching to splash panel");
            this.removeAll();
            this.add(new ButtonPanel(this));
            this.add(new SplashScreenPanel());
            break;
        case METRICS_PANEL:
            //Display the Metrics_Panel
            System.out.println("switching to metrics panel");
            this.removeAll();
            this.add(new ButtonPanel(this));
            this.add(new InputMetricsPanel(this));        
            break;
        case WORKOUT_PANEL:
            //Display the Workout_Panel
            System.out.println("switching to workout panel");
            this.removeAll();
            this.add(new ButtonPanel(this));
            this.add(new InputWorkoutPanel(this));
            break;
        case LINE_PANEL:
            //Display the Line_Panel
            System.out.println("switching to line graph");
            this.removeAll();
            this.add(new ButtonPanel(this));
            lineGraphPanel.createScene();
            this.add(lineGraphPanel);
            break;
        case SCATTER_PANEL:
            //Display the Scatter_Panel
            System.out.println("switching to scatter plot");
            this.removeAll();
            this.add(new ButtonPanel(this));
            scatterPanel.createScene();
            this.add(scatterPanel);
            break;
        case PIE_PANEL:
            //Display the Pie_Panel
            System.out.println("switching to pie chart");
            this.removeAll();
            this.add(new ButtonPanel(this));
            pieChartPanel.createScene();
            this.add(pieChartPanel);
            break;
    }
    
    //Update GUI
    this.revalidate();
    this.repaint();
  }
  
}

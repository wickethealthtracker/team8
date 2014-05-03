/**
 * Author Jack
 * 
 * The purpose of this class is to display all the UI buttons
 * on the left hand side of the MainPanel
 */

//Project Package
package cse_360_project;

//Necessary Imports
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
  

public class ButtonPanel extends JPanel {
  MainPanel parent;
  

  public ButtonPanel(MainPanel p) {
    parent = p;
    
    //Initalize and deploy "Input Workout" button used to navigate to
    //input workouts page
    final JButton workout = new JButton("Input Workout");
    
    workout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         parent.showPanel(MainPanel.WORKOUT_PANEL);
      }
    });
    
    //Initalize and deploy "Input Metrics" button used to navigate to
    //input metrics page
    final JButton metrics = new JButton("Input Metrics");
    metrics.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        parent.showPanel(MainPanel.METRICS_PANEL);
      }
    });
    
    //Initalize and deploy "Graph Scatterplot" button used to navigate to
    //graph scatterplot page
    final JButton scatter = new JButton("Graph Scatterplot");
    scatter.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           parent.showPanel(MainPanel.SCATTER_PANEL);
       } 
    });
    
    //Initalize and deploy "Pie Chart" button used to navigate to
    //graph pie chart page
    final JButton pieChart = new JButton("Pie Chart");
    pieChart.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           parent.showPanel(MainPanel.PIE_PANEL);
       } 
    });
    
    //Initalize and deploy "Graph Line" button used to navigate to
    //line graph page
    final JButton lineGraph = new JButton("Graph Line");
    lineGraph.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           parent.showPanel(MainPanel.LINE_PANEL);
       } 
    });
    
    //Initalize and deploy "Print Report" button used to generate and open
    //a printable health report
    final JButton print = new JButton("Print Report");
    print.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           RecordManager.getInstanceOf().printRecords();           
       } 
    });
    
    //Establish grid layout for the panel
    this.setLayout(new GridLayout(6,1));
    
    //Add buttons to the panel
    this.add(workout);
    this.add(metrics);
    this.add(lineGraph);
    this.add(pieChart);
    this.add(scatter);
    this.add(print);
  }
}

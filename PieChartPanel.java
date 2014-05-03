/*
 * Author Jack
 *
 * Class responsible for creating the pie chart to be displayed. Creates arrays
 * to store data taken from the RecordManager class in the necessary formats for
 * graphing.  The pie chart displays the total cumulative time spent for the 
 * user doing each workout since they began using the software.
 */


//Project package
package cse_360_project;

//Necessary imports
import com.sun.javafx.application.PlatformImpl;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javax.swing.JPanel;



public class PieChartPanel extends JPanel {
    //Panel declaration
    private JFXPanel jfxPanel;
    
    //Method to call initComponents() to build pie chart
    public PieChartPanel() {
        initComponents();     
    }
    
    //builds panel, creates scene and adds panel
    public void initComponents() {
        jfxPanel = new JFXPanel();
        createScene();
        this.add(jfxPanel);
    }
    
    
    public void createScene() {
        PlatformImpl.startup(new Runnable() {

            @Override
            public void run() {
                //Build scene
                Group root = new Group();
                Scene scene = new Scene(root);

                //Declare an ArrayList of type WorkoutRecord containing workouts
                ArrayList<WorkoutRecord> list =
                        RecordManager.getInstanceOf().getWorkoutList();

                //Initalize incoming data 
                WorkoutType[] types = WorkoutType.values();
                int[] lengths = new int[types.length];
                double total = 0;

                // iterate over each record in the arraylist and sum durations
                // then convert to percent
                for(WorkoutRecord r : list) {
                    lengths[r.getType().ordinal()] += r.duration();
                    total += r.duration();
                }

                //ObervableList containing pie chart data 
                ObservableList<PieChart.Data> pieChartData = 
                    FXCollections.observableArrayList();

                //loop data percentages and add them to pieChartData
                for(int i = 0; i < types.length; i++) {
                    pieChartData.add(new PieChart.Data(types[i].toString(), 
                            (lengths[i]/total)*100));
                }
                
                //Build a pie chart based on pieChartData
                final PieChart chart = new PieChart(pieChartData);
                
                //Title of the pie chart
                chart.setTitle("Workouts by type");

                //Build and display chart
                root.getChildren().add(chart);
                jfxPanel.setScene(scene);
            }
            
        });
    }
    

}

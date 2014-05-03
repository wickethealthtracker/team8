/*
 * Author Jack
 *
 * Class responsible for creating the scatter graph to be displayed. Creates 
 * arrays to store data taken from the RecordManager class in the necessary 
 * formats for graphing. Graphs the value for the metric on the y-axis with the
 * number indicating the month completed on the x-axis.  Various graphed 
 * symbols represent the type of metric completed which correspond to a legand
 * beneath the graph.
 *
 */

//Project package
package cse_360_project;

//Necessary imports
import com.sun.javafx.application.PlatformImpl;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javax.swing.JPanel;


public class ScatterPanel extends JPanel {
    
    //Declare JFXPanel
    private JFXPanel jfxPanel;
    
    //Method for calling initComponents() to build functionality in swing
    public ScatterPanel() {
        initComponents();
    }
    
    //Initalize panel, scene and add them to the display
    public void initComponents() {
        jfxPanel = new JFXPanel();
        createScene();
        this.add(jfxPanel);
    }
    
    public void createScene() {
        PlatformImpl.startup(new Runnable() {
            @Override
            public void run() {        
                
                //Declare scene
                Group root = new Group();
                Scene scene = new Scene(root);

                //Declare axis type and parameters for graph
                final NumberAxis xAxis = new NumberAxis(0, 12, 1);
                final NumberAxis yAxis = new NumberAxis(0, 500, 50);        
                final ScatterChart<Number,Number> sc = new

                //Labels graph and axies
                ScatterChart<Number,Number>(xAxis,yAxis);
                xAxis.setLabel("Month");                
                yAxis.setLabel("Value");
                sc.setTitle("Metric Scatterplot");

                //Establishes data series labels
                XYChart.Series series1 = new XYChart.Series();
                series1.setName("Body Mass Percentage");

                XYChart.Series series2 = new XYChart.Series();
                series2.setName("Weight");

                XYChart.Series series3 = new XYChart.Series();
                series3.setName("Height (Inches)");

                XYChart.Series series4 = new XYChart.Series();
                series4.setName("Resting Heart Rate");

                XYChart.Series series5 = new XYChart.Series();
                series5.setName("Active Heart Rate");

                //Initalize array list of MetricRecords
                ArrayList<MetricRecord> list =
                        RecordManager.getInstanceOf().getMetricList();

                //Initalize array of MetricType values
                MetricType[] types = MetricType.values();
                int length = list.size(); 

                
                String[] names = new String[5];
                
                //arrays for storing values assoicated with records of each metric
                double[] BMI_values = new double[length/5];
                double[] Weight_values = new double[length/5];
                double[] Height_values = new double[length/5];
                double[] Resting_values = new double[length/5];
                double[] Active_values = new double[length/5];

                //arrays for storing dates associated with records of each metric
                String[] BMI_dates = new String[length/5];
                String[] Weight_dates = new String[length/5];
                String[] Height_dates = new String[length/5];
                String[] Resting_dates = new String[length/5];
                String[] Active_dates = new String[length/5];

                //Arrays for storing just months (converted to int representation)
                //corresponding to metric records
                int[] BMI_months = new int[length/5];
                int[] Weight_months = new int[length/5];
                int[] Height_months = new int[length/5];
                int[] Resting_months = new int[length/5];
                int[] Active_months = new int[length/5];

                //Number of instance collections to graph
                int iterations = list.size() / types.length;

                //Fill names array with string version of metric enums
                for(int i = 0; i<types.length; i++) {
                names[i] = types[i].toString();
                }

                //Declare sequence in which enumerations are presented
                int store_BMI = 0;
                int store_Weight = 1;
                int store_Height = 2;
                int store_Resting = 3;
                int store_Active = 4;

                
                for(int i = 0; i<iterations; i++){
                    //Store next iteration of metric value
                    BMI_values[i] = list.get(store_BMI).value();
                    Weight_values[i] = list.get(store_Weight).value();
                    Height_values[i] = list.get(store_Height).value();
                    Resting_values[i] = list.get(store_Resting).value();
                    Active_values[i] = list.get(store_Active).value();

                    //Store next iteration of metric date
                    BMI_dates[i] = list.get(store_BMI).date();
                    Weight_dates[i] = list.get(store_Weight).date();
                    Height_dates[i] = list.get(store_Height).date();
                    Resting_dates[i] = list.get(store_Resting).date();
                    Active_dates[i] = list.get(store_Active).date();

                    //Cycle iteration location to move to next instance in the
                    //recordManager
                    store_BMI = store_BMI + 5;
                    store_Weight = store_Weight + 5;
                    store_Height = store_Height +5;
                    store_Resting = store_Resting + 5;
                    store_Active = store_Active + 5;
                }

                //Logic for converting BMI_dates to numeric representations
                for(int i = 0; i<iterations; i++){
                    String temp = BMI_dates[i];
                    String[] words = temp.split(" "); 
                    String tempMonth = words[1];

                    switch (tempMonth) {
                    case "Jan": BMI_months[i] = 1;
                            break;
                    case "Feb": BMI_months[i] = 2;
                            break;
                    case "Mar": BMI_months[i] = 3;
                            break;
                    case "Apr": BMI_months[i] = 4;
                            break;
                    case "May": BMI_months[i] = 5;
                            break;
                    case "Jun": BMI_months[i] = 6;
                            break;
                    case "Jul": BMI_months[i] = 7;
                            break;
                    case "Aug": BMI_months[i] = 8;
                            break;
                    case "Sep": BMI_months[i] = 9;
                            break;
                    case "Oct": BMI_months[i] = 10;
                            break;
                    case "Nov": BMI_months[i] = 11;
                            break;
                    case "Dec": BMI_months[i] = 12;
                            break;     
                    }
                }

                //Logic for converting Weight_dates to numeric representations
                for(int i = 0; i<iterations; i++){
                    String temp = Weight_dates[i];
                    String[] words = temp.split(" "); 
                    String tempMonth = words[1];

                    switch (tempMonth) {
                    case "Jan": Weight_months[i] = 1;
                            break;
                    case "Feb": Weight_months[i] = 2;
                            break;
                    case "Mar": Weight_months[i] = 3;
                            break;
                    case "Apr": Weight_months[i] = 4;
                            break;
                    case "May": Weight_months[i] = 5;
                            break;
                    case "Jun": Weight_months[i] = 6;
                            break;
                    case "Jul": Weight_months[i] = 7;
                            break;
                    case "Aug": Weight_months[i] = 8;
                            break;
                    case "Sep": Weight_months[i] = 9;
                            break;
                    case "Oct": Weight_months[i] = 10;
                            break;
                    case "Nov": Weight_months[i] = 11;
                            break;
                    case "Dec": Weight_months[i] = 12;
                            break;     
                    }
                }

                //Logic for converting Height_dates to numeric representations
                for(int i = 0; i<iterations; i++){
                    String temp = Height_dates[i];
                    String[] words = temp.split(" "); 
                    String tempMonth = words[1];

                    switch (tempMonth) {
                    case "Jan": Height_months[i] = 1;
                            break;
                    case "Feb": Height_months[i] = 2;
                            break;
                    case "Mar": Height_months[i] = 3;
                            break;
                    case "Apr": Height_months[i] = 4;
                            break;
                    case "May": Height_months[i] = 5;
                            break;
                    case "Jun": Height_months[i] = 6;
                            break;
                    case "Jul": Height_months[i] = 7;
                            break;
                    case "Aug": Height_months[i] = 8;
                            break;
                    case "Sep": Height_months[i] = 9;
                            break;
                    case "Oct": Height_months[i] = 10;
                            break;
                    case "Nov": Height_months[i] = 11;
                            break;
                    case "Dec": Height_months[i] = 12;
                            break;     
                    }
                }

                //Logic for converting resting heart rate dates to numeric 
                //representations
                for(int i = 0; i<iterations; i++){
                    String temp = Resting_dates[i];
                    String[] words = temp.split(" "); 
                    String tempMonth = words[1];

                    switch (tempMonth) {
                    case "Jan": Resting_months[i] = 1;
                            break;
                    case "Feb": Resting_months[i] = 2;
                            break;
                    case "Mar": Resting_months[i] = 3;
                            break;
                    case "Apr": Resting_months[i] = 4;
                            break;
                    case "May": Resting_months[i] = 5;
                            break;
                    case "Jun": Resting_months[i] = 6;
                            break;
                    case "Jul": Resting_months[i] = 7;
                            break;
                    case "Aug": Resting_months[i] = 8;
                            break;
                    case "Sep": Resting_months[i] = 9;
                            break;
                    case "Oct": Resting_months[i] = 10;
                            break;
                    case "Nov": Resting_months[i] = 11;
                            break;
                    case "Dec": Resting_months[i] = 12;
                            break;     
                    }
                }

                //Logic for converting active heart rate dates to numeric 
                //representations
                for(int i = 0; i<iterations; i++){
                    String temp = Active_dates[i];
                    String[] words = temp.split(" "); 
                    String tempMonth = words[1];

                    switch (tempMonth) {
                    case "Jan": Active_months[i] = 1;
                            break;
                    case "Feb": Active_months[i] = 2;
                            break;
                    case "Mar": Active_months[i] = 3;
                            break;
                    case "Apr": Active_months[i] = 4;
                            break;
                    case "May": Active_months[i] = 5;
                            break;
                    case "Jun": Active_months[i] = 6;
                            break;
                    case "Jul": Active_months[i] = 7;
                            break;
                    case "Aug": Active_months[i] = 8;
                            break;
                    case "Sep": Active_months[i] = 9;
                            break;
                    case "Oct": Active_months[i] = 10;
                            break;
                    case "Nov": Active_months[i] = 11;
                            break;
                    case "Dec": Active_months[i] = 12;
                            break;     
                    }
                }


                //Add metric values and respective months to series data for graph
                for(int i = 0; i <iterations; i++) {
                    series1.getData().add(new XYChart.Data(BMI_months[i], BMI_values[i]));
                    series2.getData().add(new XYChart.Data(Weight_months[i], Weight_values[i]));
                    series3.getData().add(new XYChart.Data(Height_months[i], Height_values[i]));
                    series4.getData().add(new XYChart.Data(Resting_months[i], Resting_values[i]));
                    series5.getData().add(new XYChart.Data(Active_months[i], Active_values[i]));
                }

                //Build and display graph
                sc.getData().addAll(series1, series2, series3, series4, series5);
                root.getChildren().add(sc);
                jfxPanel.setScene(scene);
            }
        });
       
    }
}

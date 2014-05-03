/*
 * Author Jack
 *
 * Class responsible for creating the line graph to be displayed. Creates arrays
 * to store data taken from the RecordManager class in the necessary formats for
 * graphing.  Presents different metrics on the y-axis and values on the x-axis. 
 * The user can then observe the data points for each time they have completed
 * that metric and easy see their peak values for each metric.
 *
 */


//Project package
package cse_360_project;

//Necessary imports
import com.sun.javafx.application.PlatformImpl;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.JPanel;


public class LineGraphPanel extends JPanel {

    
    private JFXPanel jfxPanel;
    
    public LineGraphPanel() {
        initComponents();
    }
    
    public void initComponents() {
        jfxPanel = new JFXPanel();
        //createScene();
        this.add(jfxPanel);
    }
    
    public void createScene() {
        PlatformImpl.startup(new Runnable() {
            public void run() {
                //Declare the page type
                Group root = new Group();
                Scene scene = new Scene(root);
                
                //Determine the type for each graph axis
                final NumberAxis xAxis = new NumberAxis();
                final CategoryAxis yAxis = new CategoryAxis();

                //Label the x and y axis
                xAxis.setLabel("Value");
                yAxis.setLabel("Metrics");

                //Declare the LineChart
                LineChart<Number,String> lineChart =
                    new LineChart<>(xAxis,yAxis);

                //ArrayList contianing set of MetricRecords in the RecordManager
                ArrayList<MetricRecord> list =
                        RecordManager.getInstanceOf().getMetricList();

                //Declare chart data series and their associated data sets
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

                //declare 
                MetricType[] types = MetricType.values();
                int length = list.size();

                String[] names = new String[5];
                
                //Store values for each metric
                double[] BMI_values = new double[length/5];
                double[] Weight_values = new double[length/5];
                double[] Height_values = new double[length/5];
                double[] Resting_values = new double[length/5];
                double[] Active_values = new double[length/5];

                //Track iterations through the records
                int iterations = list.size() / types.length;

                //build a list of names (string) for the graph
                for(int i = 0; i<types.length; i++) {
                    names[i] = types[i].toString();
                }

                //Indicate the order metrics are presented for separating data sets
                int store_BMI = 0;
                int store_Weight = 1;
                int store_Height = 2;
                int store_Resting = 3;
                int store_Active = 4;

                //store the values for each metric through the recordManager
                for(int i = 0; i<iterations; i++){
                    BMI_values[i] = list.get(store_BMI).value();
                    Weight_values[i] = list.get(store_Weight).value();
                    Height_values[i] = list.get(store_Height).value();
                    Resting_values[i] = list.get(store_Resting).value();
                    Active_values[i] = list.get(store_Active).value();

                    store_BMI = store_BMI + 5;
                    store_Weight = store_Weight + 5;
                    store_Height = store_Height +5;
                    store_Resting = store_Resting + 5;
                    store_Active = store_Active + 5;
                }


                //Add the data streams to the graphs data
                for(int i = 0; i <iterations; i++) {
                    series1.getData().add(new XYChart.Data(BMI_values[i],names[0]));
                    series2.getData().add(new XYChart.Data(Weight_values[i],names[1]));
                    series3.getData().add(new XYChart.Data(Height_values[i],names[2]));
                    series4.getData().add(new XYChart.Data(Resting_values[i],names[3]));
                    series5.getData().add(new XYChart.Data(Active_values[i],names[4]));
                }

                //Add the series to the displayed graph
                lineChart.getData().add(series1);
                lineChart.getData().add(series2);
                lineChart.getData().add(series3);
                lineChart.getData().add(series4);
                lineChart.getData().add(series5);                        
                
                //Display the graph
                root.getChildren().add(lineChart);
                jfxPanel.setScene(scene);
            }
        });

    }
    
}

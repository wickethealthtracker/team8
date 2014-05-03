/**
 * Author Jack
 * 
 * RecordManager is responsible for data management inside the software.  
 * RecordManager stores instances of WorkoutRecords and MetricRecords as
 * serializable data in .ser files.  RecordManager is responsible for creating
 * the .ser files, saving data to them, loading data from them on initalization
 * and printing the user report based on the data stored in those files.
 * 
 */


//Project package
package cse_360_project;

//Necessary imports
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class RecordManager implements Serializable {

  //Declare inital arraylists and the RecordManager
  private ArrayList<WorkoutRecord> workouts;
  private ArrayList<MetricRecord> metrics;
  private static RecordManager instance;
  
/**
 * Singleton class RecordManager guarantees only one instance of the record manager is created
 * for the program
 */
  public static RecordManager getInstanceOf() {
    if(instance == null) {
      instance = new RecordManager();
    }
    return instance;
  }
  
  //Manager for user records containing arraylists of workouts and metrics
  private RecordManager() {
    workouts = new ArrayList();
    metrics = new ArrayList();
  }
  
  //Method for adding a new workout to the record
  public void addWorkout(WorkoutType type, int duration) {
    workouts.add(new WorkoutRecord(type, duration));
  }
  
  //Method for adding new metric to the record
  public void addMetric(MetricType type, double value) {
    metrics.add(new MetricRecord(type, value));
  }
  
  public void printRecords() {
      
      try {
        //Build file to save printed information and print to the file
        FileWriter fw = new FileWriter("my_data.txt");
        PrintWriter pw = new PrintWriter(fw);
        String header = String.format("%20s %6s", "Workout Type", "Length");
        pw.println(header);
        pw.println("-------------------------");
        for(WorkoutRecord r : workouts) {
            pw.println(r.date());
            pw.println(r.toString());
            pw.println();
        }
      
        pw.println();
        pw.println();
        header = String.format("%20s %5s", "Health Stat", "Value");
        pw.println(header);
        pw.println("--------------------------");
        for(MetricRecord r : metrics) {
            pw.println(r.date());
            pw.println(r.report());
            pw.println();
            //System.out.println(r.toString());
        }
        
        //Close the printing functionality
        pw.close();
        fw.close();
        
        //Open newly created file for viewing
        Desktop.getDesktop().open(new File("my_data.txt"));
        
      }
      catch(Exception e) {
          //Erorr writing to file exception
          System.err.println("Error writing to file");
      }
      
  }
  
  public void save(String fNameWorkouts, String fNameMetrics) {
    try {
        
      //Initalize storage procedures for workouts and store them in workouts
      FileOutputStream fileOutWorkouts = new FileOutputStream(fNameWorkouts);
      ObjectOutputStream outWorkouts = new ObjectOutputStream(fileOutWorkouts);
      outWorkouts.writeObject(workouts);
      
      //Initalize storage procedures for metrics and store them in metrics
      FileOutputStream fileOutMetrics = new FileOutputStream(fNameMetrics);
      ObjectOutputStream outMetrics = new ObjectOutputStream(fileOutMetrics);
      outMetrics.writeObject(metrics);

      
      //close ObjectOutputStreams
      outWorkouts.close();
      outMetrics.close();
      
      //Close FileOutputStreams
      fileOutWorkouts.close();
      fileOutMetrics.close();
      
      System.out.printf("Serialized data is saved in " + fNameWorkouts 
              + " and " + fNameMetrics);
    }
    catch(IOException i)
    {
      i.printStackTrace();
    }    
  }
  
  public void load(String fNameWorkouts, String fNameMetrics) {
    System.out.println("Loading " + fNameWorkouts + " and " + fNameMetrics);
    try
    {         
      //Declare functions for loading serialized workouts
      FileInputStream fileInWorkouts = new FileInputStream(fNameWorkouts);
      ObjectInputStream inWorkouts = new ObjectInputStream(fileInWorkouts);
      workouts = (ArrayList<WorkoutRecord>) inWorkouts.readObject();
      inWorkouts.close();
      fileInWorkouts.close();
      
      //Declare fundtions for loading serialized metrics
      FileInputStream fileInMetrics = new FileInputStream(fNameMetrics);
      ObjectInputStream inMetrics = new ObjectInputStream(fileInMetrics);
      metrics = (ArrayList<MetricRecord>) inMetrics.readObject();
      inMetrics.close();
      fileInMetrics.close();
    }
    catch(IOException i)
    {
      //Error handling IOEception
      i.printStackTrace();
      return;
    }
    catch(ClassNotFoundException c)
    {
      //Error handling incorrect data storage procedure
      System.out.println("Saved data not in format expected");
      c.printStackTrace();
      return;
    }    
  }
  
  //Maintain a public arraylist containing user workouts
  public ArrayList<WorkoutRecord> getWorkoutList() {
      return workouts;
  }
  
  //Maintain a public arrayList containing user metrics
  public ArrayList<MetricRecord> getMetricList() {
      return metrics;
  }
  
}

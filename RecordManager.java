/**
 * Note: singleton class RecordManager guarantees only one instance of the record manager is created
 * for the program
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class RecordManager implements Serializable {

  private ArrayList<WorkoutRecord> workouts;
  private static RecordManager instance;
  
  // syntax for other classes calling this is
  // RecordManager.getInstanceOf().WHATEVER_CALL
  public static RecordManager getInstanceOf() {
    if(instance == null) {
      instance = new RecordManager();
    }
    return instance;
  }
  
  private RecordManager() {
    workouts = new ArrayList();
  }
  
  public void addWorkout(String name, int duration) {
    workouts.add(new WorkoutRecord(name, duration));
  }
  
  public void save(String fName) {
    try {
      FileOutputStream fileOut = new FileOutputStream(fName);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(workouts);
      out.close();
      fileOut.close();
      System.out.printf("Serialized data is saved in " + fName);
    }
    catch(IOException i)
    {
      i.printStackTrace();
    }    
  }
  
  public void load(String fName) {
    System.out.println("Loading " + fName);
    try
    {         
      FileInputStream fileIn = new FileInputStream(fName);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      workouts = (ArrayList<WorkoutRecord>) in.readObject();
      in.close();
      fileIn.close();
    }
    catch(IOException i)
    {
      i.printStackTrace();
      return;
    }
    catch(ClassNotFoundException c)
    {
      System.out.println("Saved data not in format expected");
      c.printStackTrace();
      return;
    }    
  }
  
}

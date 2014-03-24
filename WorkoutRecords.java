
import java.io.Serializable;

public class WorkoutRecord implements Serializable {
  
  private String name; // TODO change to enum for type of workout
  private int duration;
  
  public WorkoutRecord(String n, int d) {
    name = n;
    duration = d;
  }
  
}

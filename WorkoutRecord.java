/*
 * Author Jack 
 *
 * Class used for data storage procedures relating to the workout data. Data
 * stored as serializable
 */

//Program package
package cse_360_project;


//Necessary imports
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;


/**
 * The WorkoutRecord class is responsible for storing a single workout record.
 * It consists of a name and duration of workout.
 * @author Jack
 */
public class WorkoutRecord implements Serializable {

    /**
     * type, duration (in minutes), and date are final because once a WorkoutRecord
     * is created it cannot be modified
     */
    final private WorkoutType type;
    final private int duration;
    final private Date date;
  
    
    //Create a WorkoutRecord of the given type and duration
    public WorkoutRecord(WorkoutType t, int d) {
      type = t;
      duration = d;
      
      // calculate date based on the current date when the record was created
      date = Date.from(Instant.now());
    }
    
    
    //Create a string representation of the WorkoutRecord
    public String toString() {
        return String.format("%20s %5s", type.name(), duration);
    }
    
    //Return the date of the WorkoutRecord as a string
    public String date(){
        return (date.toString());
    }
    
    //Return the type enum of the WorkoutType
    public WorkoutType getType() {
        return type;
    } 
    
    //Return the duration of the WorkoutRecord as an int
    public int duration() {
        return duration;
    }
}

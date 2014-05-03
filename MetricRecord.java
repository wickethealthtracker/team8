/*
 * Author Jack 
 *
 * Class used for data storage procedures relating to the metrics data. Data
 * stored as serializable
 */

//Project package
package cse_360_project;

//Necessary imports
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class MetricRecord implements Serializable {
    
    //Initial declarations
    final private MetricType type;
    final private double value;
    final private Date date;
    
    //MetricRecord constructor
    public MetricRecord(MetricType t, double v) {
        type = t;
        value = v;
        date = Date.from(Instant.now());
    }
    
    //Return enum name in MetricRecord
    public String toString() {
        return type.name();
    }
    
    //Return date of MetricRecord
    public String date(){
        return (date.toString());
    }
    
    //Return type of MetricRecord
    public MetricType getType() {
        return type;
    } 
    
    //Return value in MetricRecord
    public double value() {
        return value;
    }
    
    //Return String formatted with name and value in MetricRecord
    public String report(){
        return String.format("%20s %5s", type.name(), value);
    }
}

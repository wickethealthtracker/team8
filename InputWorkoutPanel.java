/**
 * Author Jack
 * 
 * The InputWorkoutPanel automatically loops through the list of enumerations
 * in WorkoutType and creates one JLabel with the string representation of
 * each enum in a JLabel as well as a JTextField for entering the value.
 * 
 * The createRecords() function assumes this automated framework is in place.
 * If it is violated, the program will quit with a system failure.
 */

//Project package
package cse_360_project;

//Necessary imports
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputWorkoutPanel extends JPanel {
    
  private MainPanel parent;
    private Component frame;
  public InputWorkoutPanel(MainPanel p) {
      parent = p;
    
    //Initalize array of WorkoutType
    WorkoutType[] values = WorkoutType.values();
    
    //Establishes the grid layout for the panel.
    this.setLayout(new GridLayout(values.length+1,2));
      
    //Adds a JLabel and text field to the panel for each WorkoutType
    for(WorkoutType t : values) {
        this.add(new JLabel(t.name()));
        this.add(new JTextField(20));
    }
    
    //Initalize and display new JButton called save 
    JButton save = new JButton("Save"); 
    
    //Add action listener used for creating records.
    save.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            createRecords();
        }
    });
            
    // add empty anonymous JPanel to move the save button to the right
    // side of the grid
    this.add(new JPanel());
    this.add(save);
  }
  
  
  void createRecords() {
      //Array of workout components
      Component[] list = this.getComponents();
      
      for(int i = 0; i < list.length-2; i+=2) {
          if(list[i] instanceof JLabel && list[i+1] instanceof JTextField) {
              
              //Build a list of labels and text boxes to be displayed on screen
              JLabel label = (JLabel)list[i];
              JTextField text = (JTextField)list[i+1];
              try {
                  
                //Define the type and duration of the workout being entered
                WorkoutType type = WorkoutType.valueOf(label.getText());
                int duration = Integer.parseInt(text.getText());
                
                //Test if duration is negative
                if(duration <0){
                    JOptionPane.showMessageDialog(frame,
                        "Workout duration cannot be negative!",
                        "Unsupported Duration",
                         JOptionPane.WARNING_MESSAGE); 
                }
                
                //Test if the workout is longer than the number of minutes in the day
                if (duration > 1440){
                    JOptionPane.showMessageDialog(frame,
                        "That workout is too long!  Workout cannot be "
                        + "longer than the amount of minutes in a day.",
                        "Unsupported Duration",
                         JOptionPane.WARNING_MESSAGE); 
                }
                //Add a WorkoutRecord to the RecordManager
                else{
                RecordManager.getInstanceOf().addWorkout(
                          type,
                          duration);
                    }
              }
              catch(NumberFormatException e) {
                  // Do nothing here; this just guarantees
                  // invalid entries or empty entries are not put into the
                  // RecordManager
              }
              
          }
          else {
              //Safeguard against internal modification of the page architecture
              System.err.println("Error, automated component framework of " +
                      "InputWorkoutPanel has been violated.  See design for more details");
              System.exit(0);
          }
      }
      
      //On completion of usage of the panel return to the splash screen
      parent.showPanel(MainPanel.SPLASH_PANEL);
      
  }
  
}

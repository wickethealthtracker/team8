/*
 * Author Jack
 *
 * Generates splash screen panel.  Extends JPanel functionality.  Panel utilized
 * between user selections as a general display on the right side of the GUI.
 */

//Project package
package cse_360_project;

//Necessary imports
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class SplashScreenPanel extends JPanel {
  
 //Constructor builds splash screen panel and includes project logo   
  public SplashScreenPanel() {
    ImageIcon icon = new ImageIcon("wicket.jpg");
    this.add(new JLabel(icon));
  }
  
}

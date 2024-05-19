
import java.awt.Component;
import java.awt.Container;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest-a
 */
public class NoFocusContainers {

    public void removeFocusFromAllObjects(Container container) {
    container.setFocusable(false);
    for (Component child : container.getComponents()) {
        if (child instanceof Container) {
            removeFocusFromAllObjects((Container) child);
        } else {
            child.setFocusable(false);
        }
    }
   }
    public static void main(String[] args) {
      NoFocusContainers a = new NoFocusContainers();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootleggbasavextractor;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author SummonerArthur
 */
public class BootlegGBASavExtractor {
    
    
    
    public static Screen scr;
    public static Thread thr0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        String genVersion = "0.0.7";
        JOptionPane.showConfirmDialog((Component) null, "Program by: 3SidedDie\n\nSpecial thanks to:\n''watermagician1996'' on Reddit\n''Im a blisy'' on Youtube.\n\nVersion: "+genVersion,"CREDITS", JOptionPane.DEFAULT_OPTION);
        
        scr = new Screen();
        thr0 = new Thread(scr);
        thr0.start();
        
    }
    
}

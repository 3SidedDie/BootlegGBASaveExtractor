
package bootleggbasavextractor;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author SummonerArthur
 */
public class Screen extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form Screen
     */
    public Screen() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/icon.png")));
    }
       
   
public static int savst=0,savfn=1;
public static String salename="unloaded";
String asd;
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        logButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".sav Extractor for Bootleg GBA cart ROMs");
        setMaximumSize(new java.awt.Dimension(310, 800));
        setMinimumSize(new java.awt.Dimension(310, 215));
        setPreferredSize(new java.awt.Dimension(310, 215));
        setResizable(false);
        getContentPane().setLayout(null);

        loadButton.setText("Load ROM");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadButton);
        loadButton.setBounds(10, 10, 280, 23);

        saveButton.setText("Extract .sav data");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(10, 140, 280, 23);

        logButton.setText("View LOG");
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logButton);
        logButton.setBounds(10, 190, 280, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 280, 100);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 220, 280, 230);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bootleggbasavextractor/Images/BG01.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        JOptionPane.showConfirmDialog((Component) null, "this button doesnt do shit man","WHAT???", JOptionPane.DEFAULT_OPTION);
    }//GEN-LAST:event_logButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
    final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            int x=0;
            String gamename="";
            newMessage("Detecting ROM");
            try{
                        File filePatch = fc.getSelectedFile();
                        FileInputStream rom = new FileInputStream(filePatch);
                        asd=filePatch.toString();
                            int c;
                            while (((c = rom.read()) != -1)){
                                x++;
                                if(x>323){
                                    rom.close();
                                    }
                                if (x>160&&x<=179){
                                    gamename=gamename+String.valueOf((char)c);
                                }
                            }
                            
                }catch (Exception ex) {
                            VerificaROM(gamename);
            }
            newMessage("Finished! Game is "+salename);
            saveButton.setEnabled(true);//activate the save button after loading
        }
        
    }//GEN-LAST:event_loadButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        JOptionPane.showConfirmDialog((Component) null, "IGNORING THIS MESSAGE CAN RESULT IN A SAVE FILE BEING DELETED,CORRUPT OR OVERWRITTEN!\nBEFORE EXTRACTING, MAKE SURE THERE'S NO OTHER SAVE FILE IN THE SAME FOLDER AS THE ROM.","WARNING!", JOptionPane.DEFAULT_OPTION);
        int retunVal = JOptionPane.showConfirmDialog((Component) null, "Extraction can take about 5 minutes cuz im dumb and i'll be doing it the dumb way. Proceed?","warning", JOptionPane.OK_CANCEL_OPTION);
        
        if(retunVal==0){
                newMessage("Reading ROM");
                newMessage("This process can take about 5 minutes");
                    try{
                        JOptionPane.showConfirmDialog((Component) null, "Extraction has started. The programm will seem like its freezed, just wait a bit.","Extraction has started", JOptionPane.DEFAULT_OPTION);
                        
                        FileInputStream rom = new FileInputStream(asd);
                                FileOutputStream save = new FileOutputStream(asd+".sav");
                                int c,x=0;
                                while ((c = rom.read()) != -1){
                                    x++;
                                    if(x>savst&&x<=savfn+1){
                                    save.write(c);
                                    }
                                    if (x>savfn){
                                    rom.close();
                                    }
                                }

                    }catch (Exception ex) {
                    newMessage("\nFinished!\nYour "+salename+" Save file is in the\nsame folder as your ROM");
                    JOptionPane.showConfirmDialog((Component) null, "EXTRACTION FINISHED! Your save data is in the same folder as your rom.","FINISHED!", JOptionPane.DEFAULT_OPTION);
                    }
        }else{
            newMessage("User cancelled extraction");
        }



    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton logButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    public void newMessage(String theMessage){
    jTextArea1.setText(jTextArea1.getText()+theMessage+"\n");
}
        public void VerificaROM(String romname){
        //StringSelection selection = new StringSelection(romname);
        //Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //clipboard.setContents(selection, selection);
        if(romname.equals("POKEMON FIREBPRE01")){
            savst=16515072;savfn=16580607;salename="Pokemon Fire Red";}
        else if(romname.equals("POKEMON LEAFBPRE01")){//untested, using fake name for now
            savst=16515072;savfn=16580607;salename="Pokemon Leaf Green";}
        else if(romname.equals("POKE DUNGEONB24E01")){//might need some testing
            savst=2621440;savfn=2686975;salename="Pokemon MDungeon Red";}
        else if(romname.equals("POKEMON EMERBPEE01")){
            savst=16515072;savfn=16580607;salename="Pokemon Emerald";}
        else{
            savst=16515072;savfn=16580607;salename="Untested/nExtraction might not work!";
        }
    }
    
    @Override
    public void run() {
        BootlegGBASavExtractor.scr.setVisible(true);
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Gui.Gui;
import java.io.File;
import javax.swing.DefaultListModel;

/**
 *
 * @author omero
 */
public class PlayList  {

    
    private Gui g;
    public PlayList(Gui g) {
        this.g=g;
        playListDoldur();
    }
    
    public void playListDoldur(){
        DefaultListModel dim=new DefaultListModel();
        File dir=new File("./music");
        File []list=dir.listFiles();
        for(File file:list){
            if(file.getName().endsWith(".wav")){
                dim.addElement(file.getName());
            }
        }
        getG().getPlayList().setModel(dim);
        
    }

    public Gui getG() {
        return g;
    }

    public void setG(Gui g) {
        this.g = g;
    }
    
    
    
}

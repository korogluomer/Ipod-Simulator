/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Functions.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Gui.*;

/**
 *
 * @author omero
 */
public class LabelEvent implements MouseListener{
    private Gui g;
    private Plays p;

    public LabelEvent(Gui g) {
        this.g=g;
        p=new Plays(this.g);
    }

    public Gui getG() {
        return g;
    }

    public void setG(Gui g) {
        this.g = g;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource()==getG().getBtnSesac()) {
            p.high();
        }
        else if(e.getSource()==getG().getBtnSeskis()){
            p.low();
        }
        else if(e.getSource()==getG().getBtnBaslat()){
            if(getG().getBtnBaslat().getIcon().toString().equals(getClass().getResource("/Gui/pause.png").toString())){
                p.pause();
            }
            else{
                p.play();
            }
        }
        else if(e.getSource()==getG().getBtnGeri()){
            p.back();
        }
        else if(e.getSource()==getG().getBtnIleri()){
            p.next();
        }
        else if(e.getSource()==getG().getList()){
            p.list();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}

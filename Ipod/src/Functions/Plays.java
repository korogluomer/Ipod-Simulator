/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Gui.Gui;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author omero
 */
public class Plays {
    
    
    private boolean playResume=true;//false başlat true devam
    private ImageIcon iic;
    private Gui g;
    private Lists l;
    private AudioInputStream a;
    private Clip clip;
    private FloatControl f;
    private long totalTime,pauseTime;

    public Plays(Gui g) {
        this.g = g;
        l=new Lists();
        l.search();
    }

    public Plays() {
    }
    

    public Gui getG() {
        return g;
    }

    public void setG(Gui g) {
        this.g = g;
    }

    public boolean getPlayResume() {
        return playResume;
    }

    public void setPlayResume(boolean playResume) {
        this.playResume = playResume;
    }
    public AudioInputStream getA() {
        return a;
    }

    public void setA(String a) throws UnsupportedAudioFileException {
        try {
            this.a = AudioSystem.getAudioInputStream(new File(a));
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public FloatControl getF() {
        return f;
    }

    public void setF(FloatControl f) {
        this.f = f;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public long getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(long pauseTime) {
        this.pauseTime = pauseTime;
    }

    public ImageIcon getIic() {
        return iic;
    }

    public void setIic(String iic) {
        this.iic = new ImageIcon(getClass().getResource(iic));
    }
    
    
    public void play(){
        
        setIic("/Gui/pause.png");
        getG().getBtnBaslat().setIcon(iic);
        setIic("/Gui/musicon.png");
        getG().getSongImage().setIcon(iic);
        if(getPlayResume()==true){
        try {
            setA(l.getY().path);
            setClip(AudioSystem.getClip());
            getClip().open(getA());
            setF((FloatControl)getClip().getControl(FloatControl.Type.MASTER_GAIN));
            //f.setValue(1.0f);//Ses seviyesi
            setTotalTime(getClip().available());
            //clip.setMicrosecondPosition(200000000);//dakikaya atlama
            getClip().start();//başlatma
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println(ex);
            }
            }
            else{
            setPauseTime(getClip().getMicrosecondPosition());
            try {
            setA(l.getY().path);
            setClip(AudioSystem.getClip());
            getClip().open(getA());
            /*f=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            f.setValue(1.0f);//Ses seviyesi*/
            setTotalTime(getClip().available());
            getClip().setMicrosecondPosition(getPauseTime());//dakikaya atlama
            getClip().start();//başlatma
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println(ex);
            }
            }
            getG().getName().setText(l.getY().name);
            getG().getDurum().setText("Now Playing");
    }
    public void pause(){
        getClip().stop();
        setPlayResume(false);
        setIic("/Gui/play.png");
        getG().getBtnBaslat().setIcon(iic);
        setIic("/Gui/musicoff.png");
        getG().getSongImage().setIcon(iic);
        getG().getDurum().setText("Paused");
    }
    public void next(){
        l.Listeleileri();
        getClip().close();
        try {
            setA(l.getY().path);
            setClip(AudioSystem.getClip());
            getClip().open(getA());
            setF((FloatControl)getClip().getControl(FloatControl.Type.MASTER_GAIN));
            //clip.setMicrosecondPosition(200000000);//dakikaya atlama
            if(getG().getBtnBaslat().getIcon().toString().equals(getClass().getResource("/Gui/pause.png").toString())){
                getClip().start();//başlatma
            }
            else
                getClip().stop();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        getG().getName().setText(l.getY().name);
    }
    public void back(){
            l.Listelegeri();
            getClip().close();
            try {
                setA(l.getY().path);
                setClip(AudioSystem.getClip());
                getClip().open(getA());
                setF((FloatControl)getClip().getControl(FloatControl.Type.MASTER_GAIN));
                //clip.setMicrosecondPosition(90000000);//dakikaya atlama
                if(getG().getBtnBaslat().getIcon().toString().equals(getClass().getResource("/Gui/pause.png").toString())){
                    getClip().start();//başlatma
                    //SongOver s=new SongOver(this);
                }
                else
                    getClip().stop();
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
            getG().getName().setText(l.getY().name);
    }
    public void low(){
        if(getF().getValue()>-40.0f)
            getF().setValue(getF().getValue()-10.0f);
    }
    public void high(){
        if(getF().getValue()<0.0f)
            getF().setValue(getF().getValue()+10.0f);
    }
    public void list(){
        if(getG().getPlayList().isVisible()==false)
            getG().getPlayList().setVisible(true);
        else
            getG().getPlayList().setVisible(false);
    }
    
}

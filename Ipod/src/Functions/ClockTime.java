/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Gui.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author omero
 */
public class ClockTime{ 

    private Gui g;
    public ClockTime(Gui g) {
        this.g=g;
        time();
    }
    
    public int saat,dakika;
    public void time(){
        Thread clock=new Thread(){
            @Override
            public void run(){
                for(;;){
                    Calendar cal=new GregorianCalendar();
                    saat=cal.get(Calendar.HOUR)+12;
                    dakika=cal.get(Calendar.MINUTE);
                    String zaman=saat+":"+dakika;
                    getG().setSaat(zaman);
                }
            }
        };
        clock.start();
    }

    public Gui getG() {
        return g;
    }

    public void setG(Gui g) {
        this.g = g;
    }
}

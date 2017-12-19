/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Actions.*;
import Functions.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author omero
 */
public class Gui {
    
    private JFrame jf;
    private JPanel jpButton,jpMain,jpPlayer,jpNoti;
    private JLabel btnBaslat,btnIleri,btnGeri,btnSesac,btnSeskis;
    private JLabel mainImage,songImage;
    private JLabel name,saat,durum,list;
    private ImageIcon iic;
    private JList playList;
    private LabelEvent action;
    private PlayList playList1;
    private ClockTime clockTime;

    public Gui() {
        init();
        playList1 = new PlayList(this);
        clockTime = new ClockTime(this);
    }
    
    
    public void init(){
        
        setAction();
        setIic("/Gui/back.png");
        jf=new JFrame();
        jf.setVisible(true);
        jf.setLayout(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //ana panel
        jpMain=new JPanel();
        jpMain.setBackground(Color.darkGray);
        jpMain.setLocation(0, 0);
        jpMain.setSize(400,900);
        jpMain.setLayout(null);
        
        //ana panel resim
        setIic("/Gui/ipod.png");
        mainImage =new JLabel();
        mainImage.setIcon(iic);
        mainImage.setLocation(0, 0);
        mainImage.setSize(400,900);
        
        //Player panel
        jpPlayer =new JPanel();
        jpPlayer.setBackground(new Color(220,220,220));
        jpPlayer.setLocation(49, 102);
        jpPlayer.setSize(280,338);
        jpPlayer.setLayout(null);

        //Bildirim Panel
        jpNoti=new  JPanel();
        jpNoti.setSize(280,22);
        jpNoti.setLocation(0, 0);
        jpNoti.setBackground(new Color(190,190,190));
        jpNoti.setLayout(null);

        //Saat
        saat=new JLabel("12:15");
        saat.setSize(50,20);
        saat.setLocation(240, 0);
        saat.setFont(new Font ("San Francisco",Font.BOLD,11));
        
        //Durum
        durum=new JLabel();
        durum.setSize(150,20);
        durum.setLocation(5, 0);
        durum.setFont(new Font ("San Francisco",Font.BOLD,11));
        
        //List
        setIic("/Gui/list.png");
        list=new JLabel();
        list.setIcon(iic);
        list.setSize(20,18);
        list.setLocation(130,2);
        list.addMouseListener(getAction());
        
        
        //PlayList
        playList=new JList();
        playList.setBounds(0, 25, 280, 310);
        playList.setBackground(new Color(190,190,190));
        playList.setVisible(false);
        
        //Şarkı ismi
        name=new JLabel();
        name.setSize(280,20);
        name.setLocation(20, 50);
        name.setFont(new Font ("San Francisco",Font.BOLD,14));
        
        //Şarkı Resmi
        setIic("/Gui/musicoff.png");
        songImage =new JLabel();
        songImage.setIcon(iic);
        songImage.setLocation(90, 80);
        songImage.setSize(200,200);
        
        //tuş Panel
        jpButton=new JPanel();
        jpButton.setOpaque(false);
        jpButton.setLayout(null);
        jpButton.setLocation(50, 515);
        jpButton.setSize(290,230);
        
        //Geri Buton
        setIic("/Gui/back.png");
        btnGeri=new JLabel();
        btnGeri.setIcon(iic);
        btnGeri.setLocation(22, 92);
        btnGeri.setSize(50,50);
        btnGeri.addMouseListener(getAction());
      
        //ses aç Buton
        setIic("/Gui/high.png");
        btnSesac=new JLabel();
        btnSesac.setIcon(iic);
        btnSesac.setLocation(122, 4);
        btnSesac.setSize(50,50);
        btnSesac.addMouseListener(getAction());
        
        //ses kıs Buton
        setIic("/Gui/low.png");
        btnSeskis=new JLabel();
        btnSeskis.setIcon(iic);
        btnSeskis.setLocation(122, 188);
        btnSeskis.setSize(50,50);
        btnSeskis.addMouseListener(getAction());
        
        //Play Buton
        setIic("/Gui/play.png");
        btnBaslat=new JLabel();
        btnBaslat.setIcon(iic);
        btnBaslat.setLocation(122, 92);
        btnBaslat.setSize(50,50);
        btnBaslat.addMouseListener(getAction());
        
        //İleri Buton
        setIic("/Gui/next.png");
        btnIleri=new JLabel();
        btnIleri.setIcon(iic);
        btnIleri.setLocation(215, 92);
        btnIleri.setSize(50,50);
        btnIleri.addMouseListener(getAction());
        
        jpButton.add(btnGeri);
        jpButton.add(btnSesac);
        jpButton.add(btnSeskis);
        jpButton.add(btnBaslat);
        jpButton.add(btnIleri);
        
        jpPlayer.add(playList);
        jpPlayer.add(name);
        //jpPlayer.add(ps);
        jpPlayer.add(songImage);
        jpPlayer.add(jpNoti);
        
        jpNoti.add(saat);
        jpNoti.add(durum);
        jpNoti.add(list);
        
        jpMain.add(jpButton);
        jpMain.add(jpPlayer);
        jpMain.add(mainImage);
        
        jf.add(jpMain);
        jf.setSize(390,900);//İlk boyutta sıkıntı var
        
    }

    public JLabel getBtnBaslat() {
        return btnBaslat;
    }

    public void setBtnBaslat(JLabel btnBaslat) {
        this.btnBaslat = btnBaslat;
    }

    public JLabel getBtnIleri() {
        return btnIleri;
    }

    public void setBtnIleri(JLabel btnIleri) {
        this.btnIleri = btnIleri;
    }

    public JLabel getBtnGeri() {
        return btnGeri;
    }

    public void setBtnGeri(JLabel btnGeri) {
        this.btnGeri = btnGeri;
    }

    public JLabel getBtnSesac() {
        return btnSesac;
    }

    public void setBtnSesac(JLabel btnSesac) {
        this.btnSesac = btnSesac;
    }

    public JLabel getBtnSeskis() {
        return btnSeskis;
    }

    public void setBtnSeskis(JLabel btnSeskis) {
        this.btnSeskis = btnSeskis;
    }

    public JLabel getSongImage() {
        return songImage;
    }

    public void setSongImage(JLabel songImage) {
        this.songImage = songImage;
    }

    public JLabel getName() {
        return name;
    }

    public void setName(JLabel name) {
        this.name = name;
    }

    public JLabel getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat.setText(saat);
    }

    public JLabel getDurum() {
        return durum;
    }

    public void setDurum(JLabel durum) {
        this.durum = durum;
    }

    public JLabel getList() {
        return list;
    }

    public void setList(JLabel list) {
        this.list = list;
    }

    public JList getPlayList() {
        return playList;
    }

    public void setPlayList(JList playList) {
        this.playList = playList;
    }

    public ImageIcon getIic() {
        return iic;
    }

    public void setIic(String path) {
        this.iic = new ImageIcon(getClass().getResource(path));
    }

    public LabelEvent getAction() {
        return action;
    }

    public void setAction() {
        if(this.action==null)
            this.action=new LabelEvent(this);
    }
}

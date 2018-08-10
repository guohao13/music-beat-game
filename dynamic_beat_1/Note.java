/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_beat_1;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author tjddn
 */
public class Note extends Thread {

    Image noteBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteBasic.png")).getImage();
    //y = - 120; 1초에 700을 이동
    private int x;
    private int y = 580 - (1000 / Dynamic_beat_1.SLEEP_TIME * Dynamic_beat_1.NOTE_SPEED) * Dynamic_beat_1.REACH_TIME;
    private String noteType;
    private boolean proceeded = true;

    public String getNoteType() {
        return noteType;
    }
    
    public boolean isProceeded(){
        return proceeded;
    }
    public void close(){
        proceeded = false;
    }
    
    public Note(String noteType ) {
        if (noteType.equals("S")) {
            x = 228;
        } else if (noteType.equals("D")) {
            x = 332;
        } else if (noteType.equals("F")) {
            x = 436;
        } else if (noteType.equals("Space")) {
            x = 540;
        } else if (noteType.equals("J")) {
            x = 744;
        } else if (noteType.equals("K")) {
            x = 848;
        } else if (noteType.equals("L")) {
            x = 952;
        }
        this.noteType = noteType;
    }

    public void screenDraw(Graphics2D g) {
        if (!noteType.equals("Space")) {
            g.drawImage(noteBasicImage, x, y, null);
        } else {
            g.drawImage(noteBasicImage, x, y, null);
            g.drawImage(noteBasicImage, x + 100, y, null);
        }
    }

    public void drop() {
        y += Dynamic_beat_1.NOTE_SPEED;
        if(y > 620 ){
            System.out.println("MISS!");
            close();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                drop();
                if(proceeded){
                    Thread.sleep(Dynamic_beat_1.SLEEP_TIME);
                }else{
                    interrupt();
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String judge(){
        if( y >= 613 ){
            System.out.println("Late");
            close();
            return "Late";
        }else if( y >= 600 ){
            System.out.println("Good");
            close();
            return "Good";
        }else if( y >= 587 ){
            System.out.println("Great");
            close();
            return "Great";
        }else if( y >= 573 ){
            System.out.println("Perfect");
            close();
            return "Perfect";
        }else if( y >= 565 ){
            System.out.println("Great");
            close();
            return "Great";
        }else if( y >= 550 ){
            System.out.println("Good");
            close();
            return "Good";
        }else if( y >= 535 ){
            System.out.println("Early");
            close();
            return "Early";
        }
        return "None";
    }
    
    public int getY(){
        return y;
    }
    
    public int getX(){
        return x;
    }
}

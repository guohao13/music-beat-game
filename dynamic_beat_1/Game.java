/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_beat_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author tjddn
 */
public class Game extends Thread {

    private Image judgeLineImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgeLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/gameInfo.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    private Image judgeImage;

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;
    private int points = 0;

    ArrayList<Note> noteList = new ArrayList<Note>();

    public Game(String titleName, String difficulty, String musicTitle) {
        this.difficulty = difficulty;
        this.titleName = titleName;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);

    }

    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
        
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgeLineImage, 0, 580, null);

        //note 출력
        //IF proceeded is false then remove on the list and i - 1 
        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if (note.getY() > 620) {
                judgeImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgeMiss.png")).getImage();
            }
            
            if (!note.isProceeded()) {
                noteList.remove(i);
                i--;
            } else {
                if(note.getY() >= 550 ){
                    note.noteBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteEffect.png")).getImage();
                }
                note.screenDraw(g);
            }
        }

        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("monospaced", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 630);
        g.drawString("D", 374, 630);
        g.drawString("F", 478, 630);
        g.drawString("Space Bar", 580, 630);
        g.drawString("J", 784, 630);
        g.drawString("K", 889, 630);
        g.drawString("L", 993, 630);
        g.setFont(new Font("monospaced", Font.BOLD, 30));
//        ///////

        g.drawString(Integer.toString(points), 565, 702);
        g.drawImage(judgeImage, 410, 370, null);
    }

    public void pressS() {
        judge("S");
        noteRouteSImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drum1.mp3", false).start();
    }

    public void releaseS() {
        noteRouteSImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressD() {
        judge("D");
        noteRouteDImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drum2.mp3", false).start();
    }

    public void releaseD() {
        noteRouteDImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressF() {
        judge("F");
        noteRouteFImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drum3.mp3", false).start();
    }

    public void releaseF() {
        noteRouteFImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressSpace() {
        judge("Space");
        noteRouteSpace1Image = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drum4.mp3", false).start();
    }

    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressJ() {
        judge("J");
        noteRouteJImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drum5.mp3", false).start();
    }

    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressK() {
        judge("K");
        noteRouteKImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drum6.mp3", false).start();
    }

    public void releaseK() {
        noteRouteKImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    }

    public void pressL() {
        judge("L");
        noteRouteLImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("drum1.mp3", false).start();
    }

    public void releaseL() {
        noteRouteLImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteRoute.png")).getImage();
    }

    @Override
    public void run() {
        dropNotes(this.titleName);
    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(String titleName) {
        Beat[] beats = null;

        if (titleName.equals("Crush - whatever you do") && difficulty.equals("Easy")) {
            int startTime = 4460 - Dynamic_beat_1.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime, "S"),
                new Beat(startTime + gap * 2, "L"),
                new Beat(startTime + gap * 8, "S"),
                new Beat(startTime + gap * 14, "L"),
                new Beat(startTime + gap * 16, "D"),
                new Beat(startTime + gap * 18, "K"),
                new Beat(startTime + gap * 20, "F"),
                new Beat(startTime + gap * 22, "J"),
                new Beat(startTime + gap * 24, "F"),
                new Beat(startTime + gap * 26, "J"),
                new Beat(startTime + gap * 28, "Space"),
                new Beat(startTime + gap * 30, "J"),
                new Beat(startTime + gap * 32, "Space"),
                new Beat(startTime + gap * 34, "S"),
                new Beat(startTime + gap * 36, "D"),
                new Beat(startTime + gap * 38, "L"),
                new Beat(startTime + gap * 40, "F"),
                new Beat(startTime + gap * 42, "D"),
                new Beat(startTime + gap * 44, "S"),
                new Beat(startTime + gap * 46, "Space"),
                new Beat(startTime + gap * 48, "L"),
                new Beat(startTime + gap * 49, "K"),
                new Beat(startTime + gap * 52, "Space"),
                new Beat(startTime + gap * 56, "L"),
                new Beat(startTime + gap * 60, "K"),
                new Beat(startTime + gap * 64, "L"),
                new Beat(startTime + gap * 68, "S"),
                new Beat(startTime + gap * 72, "L"),
                new Beat(startTime + gap * 72, "D"),
                new Beat(startTime + gap * 76, "K"),
                new Beat(startTime + gap * 80, "F"),
                new Beat(startTime + gap * 82, "J"),
                new Beat(startTime + gap * 84, "F"),
                new Beat(startTime + gap * 88, "J"),
                new Beat(startTime + gap * 92, "Space"),
                new Beat(startTime + gap * 98, "J"),
                new Beat(startTime + gap * 102, "Space"),
                new Beat(startTime + gap * 102, "S"),
                new Beat(startTime + gap * 106, "D"),
                new Beat(startTime + gap * 108, "L"),
                new Beat(startTime + gap * 110, "F"),
                new Beat(startTime + gap * 114, "D"),
                new Beat(startTime + gap * 114, "S"),
                new Beat(startTime + gap * 114, "Space"),
                new Beat(startTime + gap * 120, "L"),
                new Beat(startTime + gap * 124, "K"),
                new Beat(startTime + gap * 128, "Space"),
                new Beat(startTime + gap * 132, "L"),
                new Beat(startTime + gap * 138, "K"),
                new Beat(startTime + gap * 144, "Space"),
                new Beat(startTime + gap * 148, "S"),
                new Beat(startTime + gap * 152, "D"),
                new Beat(startTime + gap * 156, "L"),
                new Beat(startTime + gap * 160, "F"),
                new Beat(startTime + gap * 170, "D"),
                new Beat(startTime + gap * 174, "S"),
                new Beat(startTime + gap * 178, "Space"),
                new Beat(startTime + gap * 182, "L"),
                new Beat(startTime + gap * 186, "K"),
                new Beat(startTime + gap * 188, "Space"),
                new Beat(startTime + gap * 192, "L"),
                new Beat(startTime + gap * 200, "K"),
                new Beat(startTime + gap * 204, "Space"),
                new Beat(startTime + gap * 208, "S"),
                new Beat(startTime + gap * 212, "D"),
                new Beat(startTime + gap * 216, "L"),
                new Beat(startTime + gap * 220, "F"),
                new Beat(startTime + gap * 226, "D"),
                new Beat(startTime + gap * 230, "S"),
                new Beat(startTime + gap * 234, "Space"),
                new Beat(startTime + gap * 238, "L"),
                new Beat(startTime + gap * 244, "K"),
                new Beat(startTime + gap * 248, "Space"),
                new Beat(startTime + gap * 252, "L"),
                new Beat(startTime + gap * 256, "K"),
                new Beat(startTime + gap * 260, "Space"),
                new Beat(startTime + gap * 264, "S"),
                new Beat(startTime + gap * 268, "D"),
                new Beat(startTime + gap * 272, "L"),
                new Beat(startTime + gap * 276, "F"),
                new Beat(startTime + gap * 280, "D"),
                new Beat(startTime + gap * 284, "S"),
                new Beat(startTime + gap * 288, "Space"),
                new Beat(startTime + gap * 292, "L"),
                new Beat(startTime + gap * 296, "K"),
                new Beat(startTime + gap * 300, "Space"),
                new Beat(startTime + gap * 302, "L"),
                new Beat(startTime + gap * 304, "K"),
                new Beat(startTime + gap * 304, "Space"),
                new Beat(startTime + gap * 310, "S"),
                new Beat(startTime + gap * 314, "D"),
                new Beat(startTime + gap * 318, "L"),
                new Beat(startTime + gap * 320, "F"),
                new Beat(startTime + gap * 324, "D"),
                new Beat(startTime + gap * 328, "S"),
                new Beat(startTime + gap * 332, "Space"),
                new Beat(startTime + gap * 338, "L"),
                new Beat(startTime + gap * 342, "K"),
                new Beat(startTime + gap * 350, "Space"),
                new Beat(startTime + gap * 352, "L"),
                new Beat(startTime + gap * 356, "K"),
                new Beat(startTime + gap * 360, "L"),
                new Beat(startTime + gap * 360, "K"),
                new Beat(startTime + gap * 364, "Space"),
                new Beat(startTime + gap * 368, "S"),
                new Beat(startTime + gap * 368, "D"),
                new Beat(startTime + gap * 372, "L"),
                new Beat(startTime + gap * 378, "F"),
                new Beat(startTime + gap * 382, "D"),
                new Beat(startTime + gap * 384, "S"),
                new Beat(startTime + gap * 388, "Space"),
                new Beat(startTime + gap * 392, "L"),
                new Beat(startTime + gap * 398, "K"),
                new Beat(startTime + gap * 400, "Space"),
                new Beat(startTime + gap * 404, "L"),
                new Beat(startTime + gap * 408, "K"),
                new Beat(startTime + gap * 412, "Space"),
                new Beat(startTime + gap * 416, "S"),
                new Beat(startTime + gap * 420, "D"),
                new Beat(startTime + gap * 422, "L"),
                new Beat(startTime + gap * 426, "F"),
                new Beat(startTime + gap * 432, "D"),
                new Beat(startTime + gap * 436, "S"),
                new Beat(startTime + gap * 440, "Space"),
                new Beat(startTime + gap * 448, "L"),
                new Beat(startTime + gap * 452, "K"),
                new Beat(startTime + gap * 456, "Space"),
                new Beat(startTime + gap * 460, "L"),
                new Beat(startTime + gap * 464, "K"),
                new Beat(startTime + gap * 470, "Space"),
                new Beat(startTime + gap * 472, "S"),
                new Beat(startTime + gap * 478, "D"),
                new Beat(startTime + gap * 478, "L"),
                new Beat(startTime + gap * 482, "F"),
                new Beat(startTime + gap * 486, "D"),
                new Beat(startTime + gap * 490, "S"),
                new Beat(startTime + gap * 496, "Space"),
                new Beat(startTime + gap * 500, "L"),
                new Beat(startTime + gap * 504, "K"),
                new Beat(startTime + gap * 508, "Space"),
                new Beat(startTime + gap * 512, "L"),
                new Beat(startTime + gap * 516, "K"),
                new Beat(startTime + gap * 520, "Space"),
                new Beat(startTime + gap * 524, "S"),
                new Beat(startTime + gap * 528, "D"),
                new Beat(startTime + gap * 532, "L"),
                new Beat(startTime + gap * 536, "F"),
                new Beat(startTime + gap * 540, "D"),
                new Beat(startTime + gap * 544, "S"),
                new Beat(startTime + gap * 548, "Space"),
                new Beat(startTime + gap * 548, "L"),
                new Beat(startTime + gap * 552, "K"),
                new Beat(startTime + gap * 556, "Space"),
                new Beat(startTime + gap * 560, "L"),
                new Beat(startTime + gap * 566, "K"),
                new Beat(startTime + gap * 570, "Space"),
                new Beat(startTime + gap * 574, "S"),
                new Beat(startTime + gap * 578, "D"),
                new Beat(startTime + gap * 580, "L"),
                new Beat(startTime + gap * 584, "F"),
                new Beat(startTime + gap * 588, "D"),
                new Beat(startTime + gap * 592, "S"),
                new Beat(startTime + gap * 596, "Space"),
                new Beat(startTime + gap * 600, "L"),
                new Beat(startTime + gap * 604, "K"),
                new Beat(startTime + gap * 608, "Space"),
                new Beat(startTime + gap * 612, "L"),
                new Beat(startTime + gap * 612, "K"),
                new Beat(startTime + gap * 616, "Space"),
                new Beat(startTime + gap * 620, "S"),
                new Beat(startTime + gap * 624, "D"),
                new Beat(startTime + gap * 628, "L"),
                new Beat(startTime + gap * 632, "F"),
                new Beat(startTime + gap * 636, "D"),
                new Beat(startTime + gap * 640, "S"),
                new Beat(startTime + gap * 644, "Space"),
                new Beat(startTime + gap * 644, "L"),
                new Beat(startTime + gap * 648, "K"),
                new Beat(startTime + gap * 652, "Space"),
                new Beat(startTime + gap * 656, "L"),
                new Beat(startTime + gap * 660, "K"),
                new Beat(startTime + gap * 666, "L"),
                new Beat(startTime + gap * 670, "K"),
                new Beat(startTime + gap * 674, "Space"),
                new Beat(startTime + gap * 678, "S"),
                new Beat(startTime + gap * 682, "D"),
                new Beat(startTime + gap * 684, "L"),
                new Beat(startTime + gap * 688, "F"),
                new Beat(startTime + gap * 692, "D"),
                new Beat(startTime + gap * 700, "S"),
                new Beat(startTime + gap * 700, "D"),
                new Beat(startTime + gap * 700, "F"),
                new Beat(startTime + gap * 704, "Space"),
                new Beat(startTime + gap * 708, "J"),
                new Beat(startTime + gap * 712, "K"),
                new Beat(startTime + gap * 716, "J"),
                new Beat(startTime + gap * 720, "K"),
                new Beat(startTime + gap * 724, "Space"),
                new Beat(startTime + gap * 728, "D"),
                new Beat(startTime + gap * 732, "F"),
                new Beat(startTime + gap * 736, "D"),
                new Beat(startTime + gap * 740, "F"),
                new Beat(startTime + gap * 744, "Space"),
                new Beat(startTime + gap * 748, "D"),
                new Beat(startTime + gap * 752, "L"),
                new Beat(startTime + gap * 756, "F"),
                new Beat(startTime + gap * 756, "D"),
                new Beat(startTime + gap * 760, "S"),
                new Beat(startTime + gap * 764, "Space"),
                new Beat(startTime + gap * 768, "L"),
                new Beat(startTime + gap * 772, "K"),
                new Beat(startTime + gap * 776, "Space"),
                new Beat(startTime + gap * 780, "L"),
                new Beat(startTime + gap * 784, "K"),
                new Beat(startTime + gap * 788, "Space"),
                new Beat(startTime + gap * 792, "S"),
                new Beat(startTime + gap * 796, "D"),
                new Beat(startTime + gap * 800, "L"),
                new Beat(startTime + gap * 804, "F"),
                new Beat(startTime + gap * 806, "D"),
                new Beat(startTime + gap * 808, "S"),
                new Beat(startTime + gap * 814, "Space"),
                new Beat(startTime + gap * 818, "L"),
                new Beat(startTime + gap * 822, "K"),
                new Beat(startTime + gap * 824, "Space"),
                new Beat(startTime + gap * 828, "L"),
                new Beat(startTime + gap * 832, "K"),
                new Beat(startTime + gap * 836, "Space"),
                new Beat(startTime + gap * 840, "S"),
                new Beat(startTime + gap * 844, "D"),
                new Beat(startTime + gap * 850, "L"),
                new Beat(startTime + gap * 854, "F"),
                new Beat(startTime + gap * 858, "D"),
                new Beat(startTime + gap * 860, "S"),
                new Beat(startTime + gap * 864, "Space"),
                new Beat(startTime + gap * 868, "L"),
                new Beat(startTime + gap * 870, "K"),
                new Beat(startTime + gap * 874, "Space"),
                new Beat(startTime + gap * 878, "L"),
                new Beat(startTime + gap * 882, "K"),
                new Beat(startTime + gap * 886, "Space"),
                new Beat(startTime + gap * 890, "S"),
                new Beat(startTime + gap * 894, "D"),
                new Beat(startTime + gap * 898, "L"),
                new Beat(startTime + gap * 902, "F"),
                new Beat(startTime + gap * 906, "D"),
                new Beat(startTime + gap * 908, "S"),
                new Beat(startTime + gap * 912, "Space"),
                new Beat(startTime + gap * 918, "L"),
                new Beat(startTime + gap * 918, "K"),
                new Beat(startTime + gap * 918, "Space"),
                new Beat(startTime + gap * 922, "L"),
                new Beat(startTime + gap * 928, "K"),
                new Beat(startTime + gap * 932, "L"),
                new Beat(startTime + gap * 936, "K"),
                new Beat(startTime + gap * 940, "Space"),
                new Beat(startTime + gap * 944, "S"),
                new Beat(startTime + gap * 948, "D"),
                new Beat(startTime + gap * 952, "L"),
                new Beat(startTime + gap * 956, "F"),
                new Beat(startTime + gap * 960, "D"),
                new Beat(startTime + gap * 964, "S"),
                new Beat(startTime + gap * 968, "D"),
                new Beat(startTime + gap * 972, "F"),
                new Beat(startTime + gap * 974, "Space"),
                new Beat(startTime + gap * 978, "J"),
                new Beat(startTime + gap * 982, "K"),
                new Beat(startTime + gap * 986, "J"),
                new Beat(startTime + gap * 990, "K"),
                new Beat(startTime + gap * 994, "Space"),
                new Beat(startTime + gap * 994, "Space"),
                new Beat(startTime + gap * 994, "Space"),
                new Beat(startTime + gap * 994, "Space"),
                new Beat(startTime + gap * 994, "Space"),
                new Beat(startTime + gap * 994, "Space"),
                new Beat(startTime + gap * 994, "Space"),
                new Beat(startTime + gap * 1000, "F"),
                new Beat(startTime + gap * 1004, "F"),
                new Beat(startTime + gap * 1008, "D"),
                new Beat(startTime + gap * 1012, "F"),
                new Beat(startTime + gap * 1016, "Space"),
                new Beat(startTime + gap * 1020, "J"),
                new Beat(startTime + gap * 1022, "K"),
                new Beat(startTime + gap * 1024, "L"),};
        } else if (titleName.equals("Crush - whatever you do") && difficulty.equals("Hard")) {
            int startTime = 4460 - Dynamic_beat_1.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime, "S"),
                new Beat(startTime + gap * 2, "L"),
                new Beat(startTime + gap * 8, "S"),
                new Beat(startTime + gap * 14, "L"),
                new Beat(startTime + gap * 16, "D"),
                new Beat(startTime + gap * 18, "K"),
                new Beat(startTime + gap * 20, "F"),};
        } else if (titleName.equals("Jazzyfact - waste of time") && difficulty.equals("Easy")) {
            int startTime = 4460 - Dynamic_beat_1.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime, "S"),
                new Beat(startTime + gap * 2, "L"),
                new Beat(startTime + gap * 8, "S"),
                new Beat(startTime + gap * 14, "L"),
                new Beat(startTime + gap * 16, "D"),
                new Beat(startTime + gap * 18, "K"),
                new Beat(startTime + gap * 20, "F"),
                new Beat(startTime + gap * 22, "J"),
                new Beat(startTime + gap * 24, "F"),
                new Beat(startTime + gap * 26, "J"),
                new Beat(startTime + gap * 28, "Space"),
                new Beat(startTime + gap * 30, "J"),
                new Beat(startTime + gap * 32, "Space"),
                new Beat(startTime + gap * 34, "S"),
                new Beat(startTime + gap * 36, "D"),
                new Beat(startTime + gap * 38, "L"),
                new Beat(startTime + gap * 40, "F"),
                new Beat(startTime + gap * 42, "D"),
                new Beat(startTime + gap * 44, "S"),};
        } else if (titleName.equals("Jazzyfact - waste of time") && difficulty.equals("Hard")) {
            int startTime = 4460 - Dynamic_beat_1.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime, "S"),
                new Beat(startTime + gap * 2, "L"),
                new Beat(startTime + gap * 8, "S"),
                new Beat(startTime + gap * 14, "L"),
                new Beat(startTime + gap * 16, "D"),
                new Beat(startTime + gap * 18, "K"),
                new Beat(startTime + gap * 20, "F"),};
        } else if (titleName.equals("Sik-k - iffy") && difficulty.equals("Easy")) {
            int startTime = 4460 - Dynamic_beat_1.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime, "S"),
                new Beat(startTime + gap * 2, "L"),
                new Beat(startTime + gap * 8, "S"),
                new Beat(startTime + gap * 14, "L"),
                new Beat(startTime + gap * 16, "D"),
                new Beat(startTime + gap * 18, "K"),
                new Beat(startTime + gap * 20, "F"),
                new Beat(startTime + gap * 22, "J"),
                new Beat(startTime + gap * 24, "F"),
                new Beat(startTime + gap * 26, "J"),
                new Beat(startTime + gap * 28, "Space"),
                new Beat(startTime + gap * 30, "J"),
                new Beat(startTime + gap * 32, "Space"),
                new Beat(startTime + gap * 34, "S"),
                new Beat(startTime + gap * 36, "D"),
                new Beat(startTime + gap * 38, "L"),
                new Beat(startTime + gap * 40, "F"),
                new Beat(startTime + gap * 42, "D"),
                new Beat(startTime + gap * 44, "S"),
                new Beat(startTime + gap * 46, "Space"),};
                
        } else if (titleName.equals("Sik-k - iffy") && difficulty.equals("Hard")) {
            int startTime = 4460 - Dynamic_beat_1.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                new Beat(startTime, "S"),
                new Beat(startTime + gap * 2, "L"),
                new Beat(startTime + gap * 8, "S"),
                new Beat(startTime + gap * 14, "L"),
                new Beat(startTime + gap * 16, "D"),
                new Beat(startTime + gap * 18, "K"),
                new Beat(startTime + gap * 20, "F"),};
        }
        int i = 0;
        gameMusic.start();
        while (i < beats.length && !isInterrupted()) {
            boolean dropped = false;

            if (beats[i].getTime() <= gameMusic.getTime()) {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if (!dropped) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void judge(String input) {
        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if (input.equals(note.getNoteType())) {
                judgeEvent(note.judge());
                if(note.getY() == 573){
                    note.noteBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/noteEffect.png")).getImage();
                }
                break;
            }
        }
    }
    
    public void judgeEvent(String judge) {
//        if(!judge.equals("None")){
//            blueFlareImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/blueFlare.png")).getImage();
//        }
        if (judge.equals("Miss")) {
            judgeImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgeMiss.png")).getImage();
            points += 0;
        } else if (judge.equals("Late")) {
            judgeImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgeLate.png")).getImage();
            points += 10;
        } else if (judge.equals("Early")) {
            judgeImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgeEarly.png")).getImage();
            points += 100;
        } else if (judge.equals("Good")) {
            judgeImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgeGood.png")).getImage();
            points += 300;
        } else if (judge.equals("Great")) {
            judgeImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgeGreat.png")).getImage();
            points += 500;
        } else if (judge.equals("Perfect")) {
           
            judgeImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/judgePerfect.png")).getImage();
            points += 1000;
        }
    }

}

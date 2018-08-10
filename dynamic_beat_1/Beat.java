/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_beat_1;

/**
 *
 * @author tjddn
 */
public class Beat {
    
    private int time;
    private String noteName;

    public Beat(int time, String noteName) {
        this.time = time;
        this.noteName = noteName;
    }
    
    public int getTime() {
        return time;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }
    
    
}

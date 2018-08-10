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
public class Track {
    
    private String titleImage; // title image
    private String startImage; // start screen image
    private String gameImage; // game page image
    private String startMusic; // start screen music( for 30sec )
    private String gameMusic; // selected music 
    private String titleName; // selected title name 
    
    public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String titleName ) {
        super();
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
        this.titleName = titleName;
    }
    
    
    
    public String getTitleImage() {
        return titleImage;
    }

    public String getStartImage() {
        return startImage;
    }

    public String getGameImage() {
        return gameImage;
    }

    public String getStartMusic() {
        return startMusic;
    }

    public String getGameMusic() {
        return gameMusic;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}

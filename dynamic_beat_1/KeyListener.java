/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_beat_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author tjddn
 */
public class KeyListener extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e){
        //만약 게임이 진행되고 있지 않다면 키보드 이벤트를 무력화시킴
        if(DynamicBeat.game == null){
            return;
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                DynamicBeat.game.pressS();
                break;
            case KeyEvent.VK_D:
                DynamicBeat.game.pressD();
                break;
            case KeyEvent.VK_F:
                DynamicBeat.game.pressF();
                break;
            case KeyEvent.VK_SPACE:
                DynamicBeat.game.pressSpace();
                break;
            case KeyEvent.VK_J:
                DynamicBeat.game.pressJ();
                break;
            case KeyEvent.VK_K:
                DynamicBeat.game.pressK();
                break;
            case KeyEvent.VK_L:
                DynamicBeat.game.pressL();
                break;
            default:
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        if(DynamicBeat.game == null){
            return;
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                DynamicBeat.game.releaseS();
                break;
            case KeyEvent.VK_D:
                DynamicBeat.game.releaseD();
                break;
            case KeyEvent.VK_F:
                DynamicBeat.game.releaseF();
                break;
            case KeyEvent.VK_SPACE:
                DynamicBeat.game.releaseSpace();
                break;
            case KeyEvent.VK_J:
                DynamicBeat.game.releaseJ();
                break;
            case KeyEvent.VK_K:
                DynamicBeat.game.releaseK();
                break;
            case KeyEvent.VK_L:
                DynamicBeat.game.releaseL();
                break;
            default:
                break;
        }
    }
}

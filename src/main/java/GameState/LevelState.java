package GameState;

import Element.Block;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.List;

public class LevelState implements State{
    private GameStateManager gsm;
    private List<Block> blocks;
    //private List<Enemy> enemies;
    //private Player player;


    public LevelState(GameStateManager gsm){
        this.gsm = gsm;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(TextGraphics graphics) {
        /*graphics.setBackgroundColor(TextColor.Factory.fromString("#87CEFA"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(52*7, 8*5), ' ');
        for(Block b: blocks){
            if(b.isVisible()){
                b.draw(graphics);
            }
        }

        for(Enemy e: enemys){
            if(e.isVisible()){
                e.draw(graphics);
            }
        }

        player.draw(graphics);*/
    }

    @Override
    public void keyPressed(KeyStroke key) {

    }

    @Override
    public void keyReleased() {

    }
}

package GameState;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class LevelState implements State{
    private int ARENABLOCKSROW;
    private int ARENABLOCKSCOLS;

    private GameStateManager gsm;
    private Arena arena;

    public LevelState(GameStateManager gsm){
        this.gsm = gsm;
    }

    @Override
    public void init() {
        arena = new Arena(ARENABLOCKSROW,ARENABLOCKSCOLS);
        arena.init();
    }

    @Override
    public void update() {}

    @Override
    public void draw(TextGraphics graphics) {

        arena.draw(graphics);
    }

    @Override
    public void keyPressed(KeyStroke key) {

    }

    @Override
    public void keyReleased() {

    }
}

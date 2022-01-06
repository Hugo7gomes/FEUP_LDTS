package GameState;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class LevelSelectState implements State{
    private int currentChoice = 1;
    private int NUMLEVELS = 6;
    private GameStateManager gsm;
    private Arena arena;

    public LevelSelectState(GameStateManager gsm){
        this.gsm = gsm;
    }


    @Override
    public void init() {
        arena = new Arena(gsm);
    }

    @Override
    public void update() {}

    @Override
    public void draw(TextGraphics g) {
        g.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
        g.fillRectangle(new TerminalPosition(0,0), new TerminalSize(190, 50), ' ');

        g.putString(10,10,"Super Mario");

        for(int i = 1; i < 7; i++){
            if(i  == currentChoice){
                g.setForegroundColor(TextColor.Factory.fromString("RED"));
            }else{
                g.setForegroundColor(TextColor.Factory.fromString("WHITE"));
            }
            g.putString(10, 13 + i, "LEVEL" + i);
        }
    }

    @Override
    public void keyPressed(KeyStroke key) {
        switch (key.getKeyType()){
            case Enter -> select();
            case ArrowUp -> {
                currentChoice--;
                if(currentChoice == 0){
                    currentChoice = NUMLEVELS;
                }
            }
            case ArrowDown-> {
                currentChoice++;
                if(currentChoice == NUMLEVELS + 1){
                    currentChoice = 1;
                }
            }
        }
    }

    @Override
    public void keyReleased() {}

    public void select(){
        LevelState level = new LevelState(gsm);
       level.setLevel(currentChoice);
       gsm.addState(level);
       gsm.setState(3);
    }


    public int getCurrentChoice() {
        return currentChoice;
    }

    public void setCurrentChoice(int choice){
        this.currentChoice = choice;
    }
}

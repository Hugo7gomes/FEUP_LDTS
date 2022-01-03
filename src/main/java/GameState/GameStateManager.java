package GameState;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {
    private List<State> gameStates;
    private int currentState;

    private int MENUSTATE = 0;
    private int INSTRUCTSTATE = 1;

    public GameStateManager(){
        gameStates = new ArrayList<State>();

        currentState = MENUSTATE;

        gameStates.add(new MenuState(this));
        gameStates.add(new InstructionsState(this));
    }

    public void setState(int state){
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void draw(TextGraphics g){
        gameStates.get(currentState).draw(g);
    }

    public void keyPressed(KeyStroke key) {
        gameStates.get(currentState).keyPressed(key);
    }

    public void keyReleased() {
        gameStates.get(currentState).keyReleased();
    }

    public void notifyCurrentState(KeyStroke key){
        if(key == null){
            keyReleased();
        }else{
        keyPressed(key);
        }
    }
}

package superMario.gameStates;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {
    private List<State> gameStates;
    private int currentState;

    private int MENUSTATE = 0;
    private int SELECTLEVELSTATE = 1;
    private int INSTRUCTSTATE = 2;
    private int GAMEOVERSTATE = 3;
    private int WINSTATE = 4;
    private int LEVELSTATE = 5;



    public GameStateManager(){
        gameStates = new ArrayList<State>();

        currentState = MENUSTATE;

        gameStates.add(new MenuState(this));
        gameStates.add(new LevelSelectState(this));
        gameStates.add(new InstructionsState(this));
        gameStates.add(new GameOverState(this));
        gameStates.add(new WinState(this));

    }

    public void addState(State state){
        gameStates.add(state);
    }

    public List<State> getGameStates() {
        return gameStates;
    }
    public int getCurrentState() {
        return currentState;
    }

    public void setState(int state){
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void draw(TextGraphics graphics){
        gameStates.get(currentState).draw(graphics);
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

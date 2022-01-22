package superMario.gameStates;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.util.ArrayList;
import java.util.List;

/*(0)MENUSTATE, (1)SELECTLEVELSTATE,(2)INSTRUCTSTATE,(3)GAMEOVERSTATE,(4)WINSTATE,(5)LEVELSTATE*/
public class GameStateManager {
    private List<State> gameStates;
    private int currentState;

    public GameStateManager(){
        gameStates = new ArrayList<State>();

        currentState = 0;

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

package superMario.gameStates;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class InstructionsState implements State{
    private GameStateManager gsm;
    public InstructionsState(GameStateManager gsm){
        this.gsm = gsm;
    }

    private String[] rules = {
            "Press the right or left arrow to run",
            "Press the up arrow to jump",
            "Jump on top of the enemies to kill them",
            "If you bump into them, you die",
            "After 3 lives, it's game over",
            "Reach the final flag to win the game",
            " "
    };

    @Override
    public void init() {}

    @Override
    public void update() {}

    @Override
    public void draw(TextGraphics g) {
        g.putString(65, 10, "Instructions", SGR.BOLD);
        for(int i = 0; i < rules.length; i++){
            g.putString(55, 13 + i, rules[i]);
        }
        g.putString(65, 13 + rules.length, "Enter to go back", SGR.BOLD);
    }

    @Override
    public void keyPressed(KeyStroke key) {
        switch (key.getKeyType()){
            case Enter -> gsm.setState(0);
            default->{}//Aviso errorprone switch nao lida com todos os casos
        }

    }

    @Override
    public void keyReleased() {}
}

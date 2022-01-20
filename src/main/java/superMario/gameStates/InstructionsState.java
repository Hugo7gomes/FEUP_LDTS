package superMario.gameStates;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class InstructionsState implements State{
    private GameStateManager gsm;
    public InstructionsState(GameStateManager gsm){
        this.gsm = gsm;
    }

    private String[] rules = {
            "Rule 1",
            "Rule 2 ",
            "Rule 3"
    };

    @Override
    public void init() {}

    @Override
    public void update() {}

    @Override
    public void draw(TextGraphics g) {
        for(int i = 0; i < rules.length; i++){
            g.putString(10, 13 + i, rules[i]);
        }
        g.putString(10, 13 + rules.length, "Enter to go back");
    }

    @Override
    public void keyPressed(KeyStroke key) {
        switch (key.getKeyType()){
            case Enter -> gsm.setState(0);
        }
    }

    @Override
    public void keyReleased() {}
}

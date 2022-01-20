package superMario.gameStates;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class WinState implements State{
    private GameStateManager gsm;
    private int currentChoice = 1;
    private String[] options = {
            "Select Another Level",
            "Exit"
    };

    public void setCurrentChoice(int currentChoice) {
        this.currentChoice = currentChoice;
    }

    public String[] getOptions(){
        return options;
    }

    public int getCurrentChoice() {
        return currentChoice;
    }

    public WinState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void init() {
        if(gsm.getGameStates().size() == 6){
            gsm.getGameStates().remove(5);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(TextGraphics g) {
        g.setBackgroundColor(TextColor.Factory.fromString("BLACK"));
        g.fillRectangle(new TerminalPosition(0,0), new TerminalSize(190, 50), ' ');

        g.putString(65,10,"YOU WON!");

        g.putString(60,13 + options.length +5,"superMario.Game designed by:");
        g.putString(60,13 + options.length +6,"Hugo Gomes");
        g.putString(60,13 + options.length +7,"Lia Silva");
        g.putString(60,13 + options.length +8,"Joao Moreira");

        for(int i = 0; i < options.length; i++){
            if(i + 1 == currentChoice){
                g.setForegroundColor(TextColor.Factory.fromString("RED"));
            }else{
                g.setForegroundColor(TextColor.Factory.fromString("WHITE"));
            }
            g.putString(60, 13 + i, options[i]);
        }



    }


    @Override
    public void keyPressed(KeyStroke key) {
        switch (key.getKeyType()){
            case Enter -> select();
            case ArrowUp -> {
                currentChoice--;
                if(currentChoice == 0){
                    currentChoice = options.length;
                }
            }
            case ArrowDown-> {
                currentChoice++;
                if(currentChoice == options.length + 1){
                    currentChoice = 1;
                }
            }
        }

    }

    @Override
    public void keyReleased() {

    }

    public void select(){
        switch (currentChoice){
            case 1:
                gsm.setState(currentChoice);
                break;
            case 2:
                System.exit(0);
                break;
        }
    }

}

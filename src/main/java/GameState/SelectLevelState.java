package GameState;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class SelectLevelState implements State{
    private GameStateManager gsm;

    private List<Integer> levels;

    private int levelSelect;

    public SelectLevelState(GameStateManager gsm){
        this.gsm = gsm;
    }

    @Override
    public void init() {
        levels = new ArrayList<Integer>();
        levels.add(0);
        levels.add(1);
        levels.add(2);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(TextGraphics g) {
        for(int i = 0; i < levels.size(); i++){
            if(i == levelSelect){
                g.setForegroundColor(TextColor.Factory.fromString("RED"));
            }else{
                g.setForegroundColor(TextColor.Factory.fromString("WHITE"));
            }
            g.putString(10, 13 + i, "Level " + i);
        }
    }

    @Override
    public void keyPressed(KeyStroke key) {
        switch (key.getKeyType()){
            case Enter -> select();
            case ArrowUp -> {
                levelSelect--;
                if(levelSelect == -1){
                    levelSelect = levels.size() - 1;
                }
            }
            case ArrowDown-> {
                levelSelect++;
                if(levelSelect == levels.size()){
                    levelSelect = 0;
                }
            }
        }

    }

    public void select(){
        switch (levelSelect){
            case 0:
                System.out.println("Level 0");
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }
    @Override
    public void keyReleased() {

    }
}

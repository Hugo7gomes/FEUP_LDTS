package superMario.gameStates;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public interface State {
    void init();
    void update();
    void draw(TextGraphics graphics);
    void keyPressed(KeyStroke key);
    void keyReleased();

}

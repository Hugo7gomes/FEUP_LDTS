package Element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Block extends Element {
    public Block(int row, int col) {
        super(row, col);
    }

    @Override
    public void draw(TextGraphics textGraphics) {
        TerminalPosition positionTerminal = new TerminalPosition(position.getX(),position.getY());
        textGraphics.drawImage(positionTerminal, image);
    }

    @Override
    public void update() {

    }
}

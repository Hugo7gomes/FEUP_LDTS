package Element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

public abstract class Block extends Element {


    public Block(int row, int col) {
        super(row, col);
        this.image = buildImage();
    }

    @Override
    public void draw(TextGraphics textGraphics) {
        TerminalPosition positionTerminal = new TerminalPosition(relativePosition.getX(), relativePosition.getY());
        textGraphics.drawImage(positionTerminal, image);
    }

    @Override
    public void update() {}

    @Override
    public abstract TextImage buildImage();


}

package Element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

import java.awt.*;

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

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle(position.getX(), position.getY(), width, height);
        return rectangle;
    }
}

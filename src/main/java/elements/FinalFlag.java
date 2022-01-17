package elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

import java.awt.*;

public class FinalFlag extends Element{
    public FinalFlag(int row, int col) {
        super(row, col);
        setHeight(35);
    }

    @Override
    public void draw(TextGraphics textGraphics) {
        TerminalPosition positionTerminal = new TerminalPosition(relativePosition.getX(), relativePosition.getY());
        textGraphics.drawImage(positionTerminal, image);
    }

    @Override
    public void update() {}

    @Override
    public TextImage buildImage() {
        return null;
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle(position.getX(), position.getY(), width, height);
        return rectangle;
    }
}

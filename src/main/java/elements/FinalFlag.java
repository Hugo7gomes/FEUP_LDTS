package elements;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
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
        TextCharacter bg = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#87CEFA"), SGR.BOLD);
        TextCharacter red = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#8B0000"), SGR.BOLD);
        TextCharacter black = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("BLACK"), SGR.BOLD);
        TerminalSize size = new TerminalSize(16,35);
        TextImage image = new BasicTextImage(size);
        image.setAll(bg);
        image.setCharacterAt(0,33, black);
        image.setCharacterAt(0,34, black);
        image.setCharacterAt(3,33, black);
        image.setCharacterAt(3,34, black);
        for(int row = 10; row < 35; row++){
            image.setCharacterAt(1,row, black);
            image.setCharacterAt(2,row, black);
        }
        for(int row = 10; row < 15; row++){
            for(int col = 3; col < 17; col++){
                image.setCharacterAt(col,row, red);
            }
        }
        return image;
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle(position.getX(), position.getY(), width, height);
        return rectangle;
    }
}

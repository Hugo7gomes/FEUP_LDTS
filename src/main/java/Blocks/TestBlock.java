package Blocks;

import Element.Block;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class TestBlock extends Block {
    public TestBlock(int row, int col) {
        super(row, col);
        this.image = buildImage();
    }

    @Override
    public TextImage buildImage() {
        TextCharacter bg = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#87CEFA"), SGR.BOLD);
        TextCharacter red1 = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#9A2A2A"), SGR.BOLD);
        TextCharacter red = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#8B0000"), SGR.BOLD);
        TextCharacter green = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#006400"), SGR.BOLD);
        TextCharacter blue = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#4169E1"), SGR.BOLD);
        TextCharacter yellow = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#FFFACD"), SGR.BOLD);
        TextCharacter black = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("BLACK"), SGR.BOLD);
        TerminalSize size = new TerminalSize(7,10);
        TextImage image = new BasicTextImage(size);
        image.setAll(bg);
        image.setCharacterAt(2,0,red);
        image.setCharacterAt(3,0,red);
        image.setCharacterAt(1,1,red);
        image.setCharacterAt(2,1,red);
        image.setCharacterAt(3,1,red);
        image.setCharacterAt(4,1,red);
        image.setCharacterAt(5,1,red);
        image.setCharacterAt(2,2,yellow);
        image.setCharacterAt(3,2,yellow);
        image.setCharacterAt(4,2,black);
        image.setCharacterAt(2,3,yellow);
        image.setCharacterAt(3,3,yellow);
        image.setCharacterAt(4,3,yellow);
        image.setCharacterAt(0,4,blue);
        image.setCharacterAt(1,4,blue);
        image.setCharacterAt(5,4,blue);
        image.setCharacterAt(6,4,blue);
        image.setCharacterAt(2,4,red);
        image.setCharacterAt(3,4,blue);
        image.setCharacterAt(4,4,red);
        image.setCharacterAt(0,5,blue);
        image.setCharacterAt(1,5,blue);
        image.setCharacterAt(5,5,blue);
        image.setCharacterAt(6,5,blue);
        image.setCharacterAt(2,5,red);
        image.setCharacterAt(3,5,blue);
        image.setCharacterAt(4,5,red);
        image.setCharacterAt(6,5,blue);
        image.setCharacterAt(0,6,yellow);
        image.setCharacterAt(1,6,blue);
        image.setCharacterAt(2,6,red);
        image.setCharacterAt(3,6,red);
        image.setCharacterAt(4,6,red);
        image.setCharacterAt(5,6,blue);
        image.setCharacterAt(6,6,yellow);
        image.setCharacterAt(0,7,yellow);
        image.setCharacterAt(1,7,red);
        image.setCharacterAt(2,7,red);
        image.setCharacterAt(3,7,red);
        image.setCharacterAt(4,7,red);
        image.setCharacterAt(5,7,red);
        image.setCharacterAt(6,7,yellow);
        image.setCharacterAt(1,8,blue);
        image.setCharacterAt(2,8,blue);
        image.setCharacterAt(4,8,blue);
        image.setCharacterAt(5,8,blue);
        image.setCharacterAt(0,9,blue);
        image.setCharacterAt(1,9,blue);
        image.setCharacterAt(6,9,blue);
        image.setCharacterAt(5,9,blue);
        image.setCharacterAt(4,9,blue);
        image.setCharacterAt(2,9,blue);

        return image;
    }
}

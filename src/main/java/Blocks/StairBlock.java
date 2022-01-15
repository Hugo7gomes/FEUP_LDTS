package Blocks;

import Element.Block;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class StairBlock extends Block {
    public StairBlock(int row, int col) {
        super(row, col);
    }

    @Override
    public TextImage buildImage() {
        TextCharacter ch0 = new TextCharacter(' ', TextColor.Factory.fromString("#C4A484"),TextColor.Factory.fromString("#964B00"), SGR.BOLD);
        TextCharacter ch1 = new TextCharacter('\\', TextColor.Factory.fromString("#C4A484"),TextColor.Factory.fromString("#964B00"), SGR.BOLD);
        TextCharacter ch2 = new TextCharacter('/',TextColor.Factory.fromString("#C4A484"),TextColor.Factory.fromString("#964B00"), SGR.BOLD);
        TextCharacter ch3 = new TextCharacter('_', TextColor.Factory.fromString("#C4A484"),TextColor.Factory.fromString("#964B00"), SGR.BOLD);
        TextCharacter ch4 = new TextCharacter('|',TextColor.Factory.fromString("#C4A484"),TextColor.Factory.fromString("#964B00"), SGR.BOLD);
        TerminalSize size = new TerminalSize(8,5);
        TextImage image = new BasicTextImage(size);

        image.setAll(ch0);
        image.setCharacterAt(0,0,ch1);
        image.setCharacterAt(6,4,ch1);
        image.setCharacterAt(1,1,ch1);
        image.setCharacterAt(5,3,ch1);
        image.setCharacterAt(0,4,ch2);
        image.setCharacterAt(6,0,ch2);
        image.setCharacterAt(1,3,ch2);
        image.setCharacterAt(5,1,ch2);
        image.setCharacterAt(2,1,ch3);
        image.setCharacterAt(3,1,ch3);
        image.setCharacterAt(4,1,ch3);
        image.setCharacterAt(2,2,ch3);
        image.setCharacterAt(3,2,ch3);
        image.setCharacterAt(4,2,ch3);
        image.setCharacterAt(1,2,ch4);
        image.setCharacterAt(5,2,ch4);
        return image;
    }
}

package blocks;

import elements.Block;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class GrassBlock extends Block {
    public GrassBlock(int row, int col) {
        super(row, col);
    }

    @Override
    public TextImage buildImage() {
        TextCharacter ch = new TextCharacter(' ', TextColor.Factory.fromString("#C4A484"),TextColor.Factory.fromString("#00A300"), SGR.BOLD);
        TerminalSize size = new TerminalSize(8,5);
        TextImage image = new BasicTextImage(size, ch);
        return image;
    }
}

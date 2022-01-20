package superMario.enemies;

import superMario.elements.Enemy;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

public class EnemyY extends Enemy {
    private TextImage downImage = buildImageUpsideDown();
    public EnemyY(int row, int col) {
        super(row, col);
        setRange(30);
        setVy(-1.0);
    }

    @Override
    public void draw(TextGraphics textGraphics) {
        TerminalPosition positionTerminal = new TerminalPosition(relativePosition.getX(), relativePosition.getY());
        if(getVy() < 0){
            textGraphics.drawImage(positionTerminal, image);
        } else{
            textGraphics.drawImage(positionTerminal, downImage);
        }
    }


    public void checkBoundaries(){
        if(position.getY() == (getInitialPos().getY() - getRange())){
            setVy(-getVy());
        }
        if((position.getY() == getInitialPos().getY())){
            setVy(-getVy());
        }
    }

    @Override
    public void update() {
        position.setY(position.getY() + (int) getVy());
        checkBoundaries();
    }

    @Override
    public TextImage buildImage() {
        TextCharacter bg = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#87CEFA"), SGR.BOLD);
        TextCharacter black = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("BLACK"), SGR.BOLD);
        TextCharacter white = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#FFFFFF"), SGR.BOLD);
        TerminalSize size = new TerminalSize(8,5);
        TextImage image = new BasicTextImage(size);
        image.setAll(bg);
        image.setCharacterAt(0,4,black);
        image.setCharacterAt(1,1,black);
        image.setCharacterAt(1,2,black);
        image.setCharacterAt(1,3,black);
        image.setCharacterAt(1,4,black);
        image.setCharacterAt(2,0,black);
        image.setCharacterAt(2,1,black);
        image.setCharacterAt(2,2,black);
        image.setCharacterAt(2,3,black);
        image.setCharacterAt(2,4,black);
        image.setCharacterAt(3,0,black);
        image.setCharacterAt(3,1,white);
        image.setCharacterAt(3,2,black);
        image.setCharacterAt(3,3,black);
        image.setCharacterAt(3,4,black);
        image.setCharacterAt(4,0,black);
        image.setCharacterAt(4,1,black);
        image.setCharacterAt(4,2,black);
        image.setCharacterAt(4,3,black);
        image.setCharacterAt(4,4,black);
        image.setCharacterAt(5,0,black);
        image.setCharacterAt(5,1,white);
        image.setCharacterAt(5,2,white);
        image.setCharacterAt(5,3,black);
        image.setCharacterAt(5,4,black);
        image.setCharacterAt(6,1,black);
        image.setCharacterAt(6,2,black);
        image.setCharacterAt(6,3,black);
        image.setCharacterAt(6,4,black);
        image.setCharacterAt(7,4,black);
        return image;
    }

    public TextImage buildImageUpsideDown() {
        TextCharacter bg = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#87CEFA"), SGR.BOLD);
        TextCharacter black = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("BLACK"), SGR.BOLD);
        TextCharacter white = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#FFFFFF"), SGR.BOLD);
        TerminalSize size = new TerminalSize(8,5);
        TextImage image = new BasicTextImage(size);
        image.setAll(bg);
        image.setCharacterAt(0,0,black);
        image.setCharacterAt(1,3,black);
        image.setCharacterAt(1,2,black);
        image.setCharacterAt(1,1,black);
        image.setCharacterAt(1,0,black);
        image.setCharacterAt(2,4,black);
        image.setCharacterAt(2,3,black);
        image.setCharacterAt(2,2,black);
        image.setCharacterAt(2,1,black);
        image.setCharacterAt(2,0,black);
        image.setCharacterAt(3,4,black);
        image.setCharacterAt(3,3,white);
        image.setCharacterAt(3,2,black);
        image.setCharacterAt(3,1,black);
        image.setCharacterAt(3,0,black);
        image.setCharacterAt(4,4,black);
        image.setCharacterAt(4,3,black);
        image.setCharacterAt(4,2,black);
        image.setCharacterAt(4,1,black);
        image.setCharacterAt(4,0,black);
        image.setCharacterAt(5,4,black);
        image.setCharacterAt(5,3,white);
        image.setCharacterAt(5,2,white);
        image.setCharacterAt(5,1,black);
        image.setCharacterAt(5,0,black);
        image.setCharacterAt(6,3,black);
        image.setCharacterAt(6,2,black);
        image.setCharacterAt(6,1,black);
        image.setCharacterAt(6,0,black);
        image.setCharacterAt(7,0,black);
        return image;
    }
}

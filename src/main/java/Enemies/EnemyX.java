package Enemies;

import Element.Enemy;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;

public class EnemyX extends Enemy {
    public EnemyX(int row, int col) {
        super(row, col);
        setRange(100);
        setVx(1.0);
    }


    public void checkBoundaries(){
        if(position.getX() == (getInitialPos().getX() + getRange())){
            setVx(-getVx());
        }
        if((position.getX() == getInitialPos().getX())){
            setVx(-getVx());
        }
    }

    @Override
    public void update() {
        position.setX(position.getX() + (int) getVx());
        System.out.println( position.getX());
        checkBoundaries();
    }

    @Override
    public TextImage buildImage() {
        TextCharacter bg = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#87CEFA"), SGR.BOLD);
        TextCharacter black = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("BLACK"), SGR.BOLD);
        TextCharacter LightBrown = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#805A46"), SGR.BOLD);
        TextCharacter White = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#FFFFFF"), SGR.BOLD);
        TerminalSize size = new TerminalSize(8,5);
        TextImage image = new BasicTextImage(size);
        image.setAll(bg);
        image.setCharacterAt(0,2,LightBrown);
        image.setCharacterAt(0,3,LightBrown);
        image.setCharacterAt(1,1,LightBrown);
        image.setCharacterAt(1,2,White);
        image.setCharacterAt(1,3,LightBrown);
        image.setCharacterAt(1,4,black);
        image.setCharacterAt(2,0,LightBrown);
        image.setCharacterAt(2,1,LightBrown);
        image.setCharacterAt(2,2,black);
        image.setCharacterAt(2,3,LightBrown);
        image.setCharacterAt(2,4,black);
        image.setCharacterAt(2,5,black);
        image.setCharacterAt(3,0,LightBrown);
        image.setCharacterAt(3,1,LightBrown);
        image.setCharacterAt(3,2,LightBrown);
        image.setCharacterAt(3,3,LightBrown);
        image.setCharacterAt(4,0,LightBrown);
        image.setCharacterAt(4,1,LightBrown);
        image.setCharacterAt(4,2,LightBrown);
        image.setCharacterAt(4,3,LightBrown);
        image.setCharacterAt(5,0,LightBrown);
        image.setCharacterAt(5,1,LightBrown);
        image.setCharacterAt(5,2, black);
        image.setCharacterAt(5,3,LightBrown);
        image.setCharacterAt(5,4,black);
        image.setCharacterAt(6,1,LightBrown);
        image.setCharacterAt(6,2,White);
        image.setCharacterAt(6,3,LightBrown);
        image.setCharacterAt(6,4,black);
        image.setCharacterAt(7,2,LightBrown);
        image.setCharacterAt(7,3,LightBrown);
        return image;
    }
}

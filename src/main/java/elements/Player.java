package elements;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;

public class Player extends Element{
    private int lives = 3;
    private double vx = 0;
    private double vy = 0;
    public static final double GRAVITY = 0.2;//gravity 0.1
    public static final double JUMP_STRENGTH = 2;

    boolean isLeft = false;
    boolean isJumping = false;
    TextImage imageLeft;


    public Player(int row, int col) {
        super(row, col);
        vx = 0;
        imageLeft = buildImageLeft();
        setHeight(10);
    }

    @Override
    public void draw(TextGraphics textGraphics) {
        TerminalPosition positionTerminal = new TerminalPosition((140)/2,position.getY());
        if(isLeft){
            textGraphics.drawImage(positionTerminal, imageLeft);
        }else{
            textGraphics.drawImage(positionTerminal, image);
        }
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle(getNextPosition().getX(), getNextPosition().getY(), width, height);
        return rectangle;
    }

    @Override
    public void update() {

        double newX = position.getX()  + vx;
        double newY = position.getY() + vy;
        position.setX((int) newX);
        position.setY((int) newY);
        accelerate(0, GRAVITY);
    }

    public void keyPressed(KeyStroke key){
        switch (key.getKeyType()){
            case ArrowRight -> {
                setVx(4.0);
                isLeft = false;
            }
            case ArrowLeft-> {
                setVx(-4.0);
                isLeft = true;
            }
            case ArrowUp -> {
                if(isJumping){break;}
                else{
                    jump();
                }
            }
        }
    }

    @Override
    public TextImage buildImage() {
        TextCharacter bg = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#87CEFA"), SGR.BOLD);
        TextCharacter red = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#8B0000"), SGR.BOLD);
        TextCharacter blue = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#4169E1"), SGR.BOLD);
        TextCharacter yellow = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#FFFACD"), SGR.BOLD);
        TextCharacter black = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("BLACK"), SGR.BOLD);
        TerminalSize size = new TerminalSize(8,10);
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
        image.setCharacterAt(7,7,black);
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

    public TextImage buildImageLeft() {
        TextCharacter bg = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#87CEFA"), SGR.BOLD);
        TextCharacter red1 = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#9A2A2A"), SGR.BOLD);
        TextCharacter red = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#8B0000"), SGR.BOLD);
        TextCharacter green = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#006400"), SGR.BOLD);
        TextCharacter blue = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#4169E1"), SGR.BOLD);
        TextCharacter yellow = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("#FFFACD"), SGR.BOLD);
        TextCharacter black = new TextCharacter(' ', TextColor.Factory.fromString("RED"),TextColor.Factory.fromString("BLACK"), SGR.BOLD);
        TerminalSize size = new TerminalSize(8,10);
        TextImage image = new BasicTextImage(size);
        image.setAll(bg);
        image.setCharacterAt(5,0,red);
        image.setCharacterAt(4,0,red);
        image.setCharacterAt(2,1,red);
        image.setCharacterAt(3,1,red);
        image.setCharacterAt(4,1,red);
        image.setCharacterAt(5,1,red);
        image.setCharacterAt(6,1,red);
        image.setCharacterAt(4,2,yellow);
        image.setCharacterAt(0,7,black);
        image.setCharacterAt(3,2,black);
        image.setCharacterAt(5,2,yellow);
        image.setCharacterAt(3,3,yellow);
        image.setCharacterAt(4,3,yellow);
        image.setCharacterAt(5,3,yellow);
        image.setCharacterAt(1,4,blue);
        image.setCharacterAt(2,4,blue);
        image.setCharacterAt(6,4,blue);
        image.setCharacterAt(7,4,blue);
        image.setCharacterAt(3,4,red);
        image.setCharacterAt(4,4,blue);
        image.setCharacterAt(5,4,red);
        image.setCharacterAt(1,5,blue);
        image.setCharacterAt(2,5,blue);
        image.setCharacterAt(6,5,blue);
        image.setCharacterAt(7,5,blue);
        image.setCharacterAt(3,5,red);
        image.setCharacterAt(4,5,blue);
        image.setCharacterAt(5,5,red);
        image.setCharacterAt(7,5,blue);
        image.setCharacterAt(1,6,yellow);
        image.setCharacterAt(2,6,blue);
        image.setCharacterAt(3,6,red);
        image.setCharacterAt(4,6,red);
        image.setCharacterAt(5,6,red);
        image.setCharacterAt(6,6,blue);
        image.setCharacterAt(7,6,yellow);
        image.setCharacterAt(1,7,yellow);
        image.setCharacterAt(2,7,red);
        image.setCharacterAt(3,7,red);
        image.setCharacterAt(4,7,red);
        image.setCharacterAt(5,7,red);
        image.setCharacterAt(6,7,red);
        image.setCharacterAt(7,7,yellow);
        image.setCharacterAt(2,8,blue);
        image.setCharacterAt(3,8,blue);
        image.setCharacterAt(5,8,blue);
        image.setCharacterAt(6,8,blue);
        image.setCharacterAt(1,9,blue);
        image.setCharacterAt(2,9,blue);
        image.setCharacterAt(7,9,blue);
        image.setCharacterAt(6,9,blue);
        image.setCharacterAt(5,9,blue);
        image.setCharacterAt(3,9,blue);

        return image;
    }

    public void keyReleased(){
        vx = 0;
    }

    public void accelerate(double acelerationX, double acelerationY){
        vx += acelerationX;
        vy += acelerationY;
    }

    public void jump(){
        isJumping = true;
        accelerate(0, -JUMP_STRENGTH);
    }

    public Position getNextPosition(){
        Position nextPosition = new Position(position.getX(),position.getY());
        double newX = position.getX()  + vx;
        double newY = position.getY() + vy;
        nextPosition.setX((int) newX);
        nextPosition.setY((int) newY);
        return  nextPosition;
    }

    public double getVx(){
        return  vx;
    }

    public void setVx(double vx){this.vx = vx;}

    public double getVy() {
        return vy;
    }

    public boolean getIsLeft(){
        return isLeft;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public boolean getIsJumping(){return isJumping;}

    public void setIsJumping(boolean b){this.isJumping = b;}

    public double getJumpStrength(){return JUMP_STRENGTH;}

    public int getLives() {return lives;}

    public void setLives(int lives) {
        this.lives = lives;
    }
}

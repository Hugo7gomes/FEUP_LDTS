package Element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;

import java.awt.*;

public abstract class Enemy  extends Element{
    private int range;
    private double Vx, Vy;
    private Position InitialPos;
    public Enemy(int row, int col) {
        super(row, col);
        Position position = new Position(col, row);
        setInitialPos(position);
    }


    @Override
    public abstract void draw(TextGraphics textGraphics);

    @Override
    public abstract void update();

    @Override
    public abstract TextImage buildImage();

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle = new Rectangle(position.getX(), position.getY(), width, height);
        return rectangle;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Position getInitialPos() {
        return InitialPos;
    }

    public void setInitialPos(Position initialPos) {
        InitialPos = initialPos;
    }

    public double getVx() {
        return Vx;
    }

    public void setVx(double Vx) {
        this.Vx = Vx;
    }

    public double getVy() {
        return Vy;
    }

    public void setVy(double Vy) {
        this.Vy = Vy;
    }
}

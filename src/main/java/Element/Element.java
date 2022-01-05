package Element;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;



import java.awt.*;

public abstract class Element {
    public Position position = new Position(0,0);
    public TextImage image;
    boolean visible;

    public Element(int row, int col){
        position.setY(row);
        position.setX(col);
        this.image = buildImage();
    }

    public abstract void draw(TextGraphics textGraphics);
    public abstract void update();
    public abstract TextImage buildImage();
    public Rectangle getBounds(){
        Rectangle rectangle = new Rectangle(position.getX(), position.getY(), 7, 5);
        return rectangle;
    }
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

package superMario.elements;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;



import java.awt.*;

public abstract class Element {
    public Position position = new Position(0,0);
    public Position relativePosition = new Position(position.getX(), position.getY());
    public int width = 8;
    public int height = 5;
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
    public abstract Rectangle getBounds();
    public Position getPosition(){
        return position;
    }
    public Position getRelativePosition(){return relativePosition;}
    public void setRelativePosition(Position playerPos){this.relativePosition = new Position(getPosition().getX()-playerPos.getX()+ 140/2,getPosition().getY());}
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void setWidth(int w){this.width = w;}
    public void setHeight(int h){this.height = h;}
}

package superMario.elements;

public class Position {
    private int x, y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEqual(Position p){
        if((p.getX() == x) && (p.getY() == y)){
            return true;
        }
        return  false;
    }
}

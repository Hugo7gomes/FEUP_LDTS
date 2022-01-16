package Enemies;

import Element.Enemy;
import com.googlecode.lanterna.graphics.TextImage;

public class EnemyX extends Enemy {
    public EnemyX(int row, int col) {
        super(row, col);
    }

    @Override
    public void update() {

    }

    @Override
    public TextImage buildImage() {
        return null;
    }
}

package Factorys;
import Element.Enemy;
import Enemies.EnemyX;
import Enemies.EnemyY;

public class EnemyFactory {
    public Enemy makeEnemy(int i, int row, int col){

        switch (i){
            case 4:
                return new EnemyX(row, col);
            case 5:
                return new EnemyY(row, col);
        }
        return null;
    }
}

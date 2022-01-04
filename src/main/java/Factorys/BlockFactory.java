package Factorys;

import Element.Block;

public class BlockFactory {
    public Block makeBlock(int i, int row, int col){
        switch (i){
            case 1:
                return new Block(row, col);
            case 2:
                //return new Coin();
                break;
        }
        return null;
    }
}

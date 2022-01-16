package Factorys;

import Blocks.BrickBlock;
import Blocks.GrassBlock;
import Blocks.StairBlock;
import Blocks.TestBlock;
import Element.Block;

public class BlockFactory {
    public Block makeBlock(int i, int row, int col){

        switch (i){
            case 1:
                return new BrickBlock(row, col);
            case 2:
                return new GrassBlock(row, col);
            case 3:
                return new StairBlock(row, col);
        }
        return null;
    }
}

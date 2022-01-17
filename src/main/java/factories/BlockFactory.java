package factories;

import blocks.BrickBlock;
import blocks.GrassBlock;
import blocks.StairBlock;
import elements.Block;

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

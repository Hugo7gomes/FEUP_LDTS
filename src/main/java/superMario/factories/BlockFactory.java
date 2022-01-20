package superMario.factories;

import superMario.blocks.BrickBlock;
import superMario.blocks.GrassBlock;
import superMario.blocks.StairBlock;
import superMario.elements.Block;

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

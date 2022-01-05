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
                System.out.println("brick");
                return new BrickBlock(row, col);
            case 2:
                System.out.println("grass");
                return new GrassBlock(row, col);
            case 3:
                System.out.println("stair");
                return new StairBlock(row, col);
            case 4:
                System.out.println("stair");
                return new TestBlock(row, col);

        }
        return null;
    }
}

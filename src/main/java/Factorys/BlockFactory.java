package Factorys;

import Blocks.BrickBlock;
import Blocks.GrassBlock;
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

        }
        return null;
    }
}

package GameState;

import Element.Block;
import Factorys.BlockFactory;

import java.util.List;


public class Arena {
    private int height;
    private int width;
    private int[][] map;
    private List<Block> blocks;
    private BlockFactory blockFactory = new BlockFactory();
    //private List<Enemy> enemys;

    public Arena(int width, int height){
        this.height = height;
        this.width = width;
    }

    public void loadMap(){
        for(int row = 0; row < map.length; row ++){
            for(int col = 0; col < map[row].length;col++ ){
                Block b = blockFactory.makeBlock(map[row][col], row * 7, col * 5);
                b.setVisible(true);
                blocks.add(b);
            }
        }
    }

    public void draw(){
    }
}

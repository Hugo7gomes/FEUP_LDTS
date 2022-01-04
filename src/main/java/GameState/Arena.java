package GameState;

import Element.Block;
import Factorys.BlockFactory;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Arena {
    private int height;
    private int width;
    private Block[][] map = new Block[8][52];
    private Block[][] frameAtual;
    private List<Block> blocks = new ArrayList<Block>();
    private BlockFactory blockFactory = new BlockFactory();
    //private List<Enemy> enemys;

    public Arena(int width, int height){
        this.height = height;
        this.width = width;
    }

    public void loadMap(){
        int row = 0;
        try {
            File mapFile = new File("level.txt");
            Scanner read = new Scanner(mapFile);
            while (read.hasNextLine()){
                String line = read.nextLine();
                for(int i = 0; i < line.length(); i++){
                    Block b = blockFactory.makeBlock(Character.getNumericValue(line.charAt(i)), row * 5, i * 7);
                    if(b!= null){
                        blocks.add(b);
                        b.setVisible(true);
                    }
                    map[row][i] = b;
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        loadMap();
    }
    public void buildArena(){

    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(52*7, 8*5), ' ');
        for(Block b: blocks){
          if(b.isVisible()){
              b.draw(graphics);
          }
        }
    }
}

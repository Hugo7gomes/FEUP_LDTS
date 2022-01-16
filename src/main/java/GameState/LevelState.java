package GameState;

import Element.Block;
import Element.Player;
import Factorys.BlockFactory;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LevelState implements State{
    private GameStateManager gsm;
    private List<Block> blocks = new ArrayList<Block>();
    private BlockFactory blockFactory = new BlockFactory();;
    //private List<Enemy> enemies;
    private Player player;
    private Block[][] map = new Block[8][200];
    private Block[][] frame = new Block[8][21];
    private int level;


    public LevelState(GameStateManager gsm){
        this.gsm = gsm;
    }

    @Override
    public void init() {
        player = new Player(25,16);
        loadMap();
    }

    public void updateRelativePositions(){
        for(Block b: blocks){
            b.setRelativePosition(player.getPosition());
        }
    }
    @Override
    public void update() {
        //verificar colisoes do player(nextPosition) com blocks
        for(Block b : blocks){
            checkColisions(player, b);
        }
        player.update();
        updateRelativePositions();
    }


    public void checkColisions(Player p, Block b){
        if(p.getBounds().intersects(b.getBounds())){//testa proxima posição player com posicao blocos
            if(b.getPosition().getX() < p.getNextPosition().getX()){
                p.setVx(0);
            }
            if(p.getNextPosition().getX() <b.getPosition().getX() ){
                p.setVx(0.0);
            }
            if(b.getPosition().getY() < p.getNextPosition().getY()){
                p.setVy(0.0);

            }
            if(p.getNextPosition().getY() <b.getPosition().getY() ){
                p.setVy(0.0);
                p.setIsJumping(false);
            }
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#87CEFA"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(52*7, 8*5), ' ');
        for(Block b: blocks){
            if(b.isVisible()){
                b.draw(graphics);
            }
        }


        player.draw(graphics);
    }

    @Override
    public void keyPressed(KeyStroke key) {
        player.keyPressed(key);
    }

    @Override
    public void keyReleased() {
        player.keyReleased();
    }

    public void loadMap(){
        int row = 0;
        try {
            File mapFile = new File("Level" + level + ".txt");
            Scanner read = new Scanner(mapFile);
            while (read.hasNextLine()){
                String line = read.nextLine();
                for(int i = 0; i < line.length(); i++){
                    Block b = blockFactory.makeBlock(Character.getNumericValue(line.charAt(i)), row * 5, i * 8);
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Block> getBlocks(){return blocks;}

    public void setPlayer(Player p){this.player = p;}
}

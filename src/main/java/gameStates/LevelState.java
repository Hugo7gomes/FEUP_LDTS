package gameStates;

import elements.Block;
import elements.Enemy;
import elements.FinalFlag;
import elements.Player;
import factories.BlockFactory;
import factories.EnemyFactory;
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
    private BlockFactory blockFactory = new BlockFactory();
    private EnemyFactory enemyFactory = new EnemyFactory();
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private Player player;
    private FinalFlag flag;
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
        flag.setRelativePosition(player.getPosition());
        for(Block b: blocks){
            b.setRelativePosition(player.getPosition());
        }
        for(Enemy e: enemies){
            e.setRelativePosition(player.getPosition());
        }
    }
    @Override
    public void update() {
        for(Enemy e : enemies){
            if(e.isVisible()){
                checkCollisionsEnemy(player, e);
            }
        }
        if(player.getLives() == 0){
            gsm.setState(3);
        }

        for(Enemy e : enemies){
            e.update();
        }
        for(Block b : blocks){
            checkCollisionsBlock(player, b);
        }


        player.update();
        updateRelativePositions();
    }

    private void checkCollisionsEnemy(Player p, Enemy e) {
        if(p.getBounds().intersects(e.getBounds())){
            if((p.getNextPosition().getY()+8) < e.getPosition().getY()){
                e.setVisible(false);
            }
            else{
                p.getPosition().setY(0);
                p.getPosition().setX(p.getPosition().getX()-16);
                p.setLives(p.getLives()-1);
            }
        }
    }


    public void checkCollisionsBlock(Player p, Block b){
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
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(52*8, 8*5), ' ');
        for(Block b: blocks){
            if(b.isVisible()){
                b.draw(graphics);
            }
        }
        for(Enemy e: enemies){
            if(e.isVisible()){
                e.draw(graphics);
            }
        }

        flag.draw(graphics);
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
                    if(Character.getNumericValue(line.charAt(i)) == 5){
                        FinalFlag flag = new FinalFlag(40, i*8);
                        this.flag = flag;
                    }
                    Block b = blockFactory.makeBlock(Character.getNumericValue(line.charAt(i)), row * 5, i * 8);
                    Enemy e = enemyFactory.makeEnemy(Character.getNumericValue(line.charAt(i)), row * 5, i *8);
                    if(b!= null){
                        blocks.add(b);
                        b.setVisible(true);
                    }
                    if(e != null){
                        enemies.add(e);
                        e.setVisible(true);
                    }
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

    public List<Enemy> getEnemies(){return enemies;}

    public void setPlayer(Player p){this.player = p;}

    public int getLives(){
        return player.getLives();
    }

    public void setFlag(FinalFlag flag){
        this.flag = flag;
    }
}

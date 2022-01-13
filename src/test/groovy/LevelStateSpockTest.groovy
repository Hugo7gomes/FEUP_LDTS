import Blocks.BrickBlock
import Element.Block
import Element.Element
import Element.Player
import Element.Position
import GameState.GameStateManager
import GameState.LevelState
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class LevelStateSpockTest extends Specification{
    def 'Colision Block under Player'(){
        given:
            Block b = new BrickBlock(23,10)
            Player p = new Player(10,10)
        when:
            def bool = p.getBounds().intersects(b.getBounds())
        then:
            bool == true
    }

    def 'Colision Block above Player'(){
        given:
            Block b = new BrickBlock(10,10)
            Player p = new Player(14,10)
        when:
            def bool = p.getBounds().intersects(b.getBounds())
        then:
            bool == true
    }

    def 'Colision Block left Player'(){
        given:
            Block b = new BrickBlock(10,10)
            Player p = new Player(5,16)
        when:
            def bool = p.getBounds().intersects(b.getBounds())
        then:
            bool == true
    }

    def 'Colision Block right Player'(){
        given:
            Block b = new BrickBlock(10,10)
            Player p = new Player(5,4)
        when:
            def bool = p.getBounds().intersects(b.getBounds())
        then:
            bool == true
    }

    def 'Player collides with left block stays same position'(){
        GameStateManager gsm = new GameStateManager()
        given:
            LevelState level = new LevelState(gsm);
            Block b = new BrickBlock(10,2)
            level.getBlocks().add(b)
            Player p = new Player(5,10)
            Position pPosition = new Position(p.getPosition().getX(),p.getPosition().getY())
            level.setPlayer(p)
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowLeft)
        when:
            level.keyPressed(key)
            level.update()
        then:
            p.getPosition().isEqual(pPosition)

    }

    def 'Player collides with right block stays same position'(){
        GameStateManager gsm = new GameStateManager()
        given:
            LevelState level = new LevelState(gsm);
            Block b = new BrickBlock(10,19)
            level.getBlocks().add(b)
            Player p = new Player(5,10)
            Position pPosition = new Position(p.getPosition().getX(),p.getPosition().getY())
            level.setPlayer(p)
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowRight)
        when:
            level.keyPressed(key)
            level.update()
        then:
            p.getPosition() == pPosition
    }

    def 'Player collides with ground block stays same position'(){
        GameStateManager gsm = new GameStateManager()
        given:
            LevelState level = new LevelState(gsm);
            Block b = new BrickBlock(23,10)
            level.getBlocks().add(b)
            Player p = new Player(10,10)
            p.setVy(1)
            Position pPosition = new Position(p.getPosition().getX(),p.getPosition().getY())
            level.setPlayer(p)
        when:
            level.update()
        then:
            p.getPosition().isEqual(pPosition)
    }
}

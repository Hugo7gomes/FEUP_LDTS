import Blocks.BrickBlock
import Element.Block
import Element.Element
import Element.Player
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


}

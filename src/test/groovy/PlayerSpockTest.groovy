import Element.Player
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class PlayerSpockTest extends Specification{
    Player player = new Player(10,0)

    def 'ArrowLeft Test'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowLeft)
            int x = player.getPosition().getX()
        when:
            player.keyPressed(key)
            player.update()
        then:
            player.getIsLeft() == true
            player.getVx() == -3
            player.getPosition().getX() == x - 3
    }

    def 'ArrowRight Test'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowRight)
            int x = player.getPosition().getX()
        when:
            player.keyPressed(key)
            player.update()
        then:
            player.getIsLeft() == false
            player.getVx() == 3
            player.getPosition().getX() == x + 3
    }
}

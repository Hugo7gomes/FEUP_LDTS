import Element.Player
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class PlayerSpockTest extends Specification{
    Player player = new Player()

    def 'ArrowLeft Test'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowLeft)
            int x = player.getPosition().getX()
        when:
            player.keyPressed(key)
            player.update()
        then:
            player.getIsLeft() == true
            player.getVx() == -5
            player.getPosition().getX() == x - 5
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
            player.getVx() == 5
            player.getPosition().getX() == x + 1
    }
}

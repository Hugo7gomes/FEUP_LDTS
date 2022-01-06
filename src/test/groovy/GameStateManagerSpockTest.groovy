import GameState.GameStateManager
import GameState.MenuState
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

import javax.swing.KeyStroke

class GameStateManagerSpockTest extends Specification{
    private def gsm

    def setup(){
        gsm = new GameStateManager();
    }

    def 'set State'(){
        given:
            int state = 1
        when:
            gsm.setState(state)
        then:
            gsm.getCurrentState() == state;
    }

    def 'notify Current State'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowDown)
        when:
            gsm.notifyCurrentState(key)
        then:
            1 * gsm.keyPressed(key)
    }
}

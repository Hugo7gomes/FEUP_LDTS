import GameState.GameStateManager
import GameState.MenuState
import GameState.State
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

import javax.swing.KeyStroke

class GameStateManagerSpockTest extends Specification{
    GameStateManager gsm = new GameStateManager()
    State state = Mock(State)

    def setup(){
        gsm.gameStates << state
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
            gsm.setState(gsm.getGameStates().size()-1)
            gsm.notifyCurrentState(key)
        then:
            1 * state.keyPressed(key)
    }
}

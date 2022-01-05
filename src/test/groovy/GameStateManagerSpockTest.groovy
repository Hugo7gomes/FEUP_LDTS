import GameState.GameStateManager
import GameState.MenuState
import spock.lang.Specification

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

}

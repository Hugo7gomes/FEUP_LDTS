package superMario


import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification
import superMario.gameStates.GameStateManager
import superMario.gameStates.InstructionsState

class InstructionsStateSpockTest extends Specification{
    private InstructionsState is
    GameStateManager gsm = new GameStateManager()

    def setup(){
        is = new InstructionsState(gsm)
    }

    def 'Enter input Test'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.Enter)

        when:
            is.keyPressed(key);
        then:
            gsm.getCurrentState() == 0;
    }
}

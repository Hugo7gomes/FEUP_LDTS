import GameState.GameStateManager
import com.googlecode.lanterna.input.KeyType

class MenuStateSpockTest {
    private GameStateManager gsm

    def setup(){
        gsm = new GameStateManager()
        gsm.setState(0)
    }

    def ' Basic test input ArrowDown'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowDown)

        when:
            gsm.keyPressed(key)
        then:
            gsm.getGameStates().get(0).getCurrentChoice() == gsm.getGameStates().get(0).getCurrentChoice() + 1
    }

    def 'Bottom position test input ArrowDown'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowDown)

        when:
            gsm.getGameStates().get(0).setCurrentChoice(gsm.getGameStates().length)
            gsm.keyPressed(key)
        then:
            gsm.getGameStates().get(0).getCurrentChoice() == 1
    }

    def 'Basic test input ArrowUp'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowUp)

        when:
            gsm.getGameStates().get(0).setCurrentChoice(2)
            gsm.keyPressed(key)
        then:
            gsm.getGameStates().get(0).getCurrentChoice() == gsm.getGameStates().get(0).getCurrentChoice() - 1
    }


    def 'Top position test input ArrowUp'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowUp)

        when:
            gsm.getGameStates().get(0).setCurrentChoice(1)
            gsm.keyPressed(key)
        then:
            gsm.getGameStates().get(0).getCurrentChoice() == gsm.getGameStates().length
    }

    def 'test input Enter'(){

    }

}

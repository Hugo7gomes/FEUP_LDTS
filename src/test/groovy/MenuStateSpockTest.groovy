import GameState.GameStateManager
import GameState.MenuState
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class MenuStateSpockTest extends Specification{
    private MenuState ms
    GameStateManager gsm = new GameStateManager()

    def setup(){
        ms = new MenuState(gsm)
    }

    def ' Basic test input ArrowDown'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowDown)
            int choice = ms.getCurrentChoice()

        when:
            ms.keyPressed(key)

        then:
            ms.getCurrentChoice() == choice + 1
    }

    def 'Bottom position test input ArrowDown'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowDown)
            ms.setCurrentChoice(ms.getOptions().size())

        when:
            ms.keyPressed(key)

        then:
            ms.getCurrentChoice() == 1
    }

    def 'Basic test input ArrowUp'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowUp)
            ms.setCurrentChoice(ms.getOptions().size())
            int choice = ms.getCurrentChoice()

        when:
            ms.keyPressed(key)

        then:
            ms.getCurrentChoice() == choice - 1
    }


    def 'Top position test input ArrowUp'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowUp)
            ms.setCurrentChoice(1)

        when:
            ms.keyPressed(key)

        then:
            ms.getCurrentChoice() == ms.getOptions().size()
    }

    def 'test input Enter'(){

    }

}

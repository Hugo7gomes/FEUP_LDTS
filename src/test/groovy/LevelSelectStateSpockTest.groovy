import GameState.GameStateManager
import GameState.LevelSelectState
import GameState.LevelState
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class LevelSelectStateSpockTest extends Specification{
    LevelSelectState ls
    GameStateManager gsm = new GameStateManager()
    LevelState level

    def setup(){
        ls = new LevelSelectState(gsm)
        level = new LevelState(gsm)
    }

    def ' Basic test input ArrowDown'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowDown)
            int choice = ls.getCurrentChoice()

        when:
            ls.keyPressed(key)

        then:
            ls.getCurrentChoice() == choice + 1
    }

    def 'Bottom position test input ArrowDown'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowDown)
            ls.setCurrentChoice(6)

        when:
            ls.keyPressed(key)
        then:
            ls.getCurrentChoice() == 1
    }

    def 'Basic test input ArrowUp'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowUp)
            ls.setCurrentChoice(6)
            int choice = ls.getCurrentChoice()

        when:
            ls.keyPressed(key)

        then:
            ls.getCurrentChoice() == choice - 1
    }


    def 'Top position test input ArrowUp'(){
        given:
            def key = new com.googlecode.lanterna.input.KeyStroke(KeyType.ArrowUp)
            ls.setCurrentChoice(1)

        when:
            ls.keyPressed(key)

        then:
            ls.getCurrentChoice() == 6
    }

    def 'test input Enter'(){
        given:
            def key = new KeyStroke(KeyType.Enter)

        when:
            ls.keyPressed(key)

        then:
            level.getLevel() == ls.getCurrentChoice()

    }
}

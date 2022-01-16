import Enemies.EnemyX
import spock.lang.Specification;

class EnemyXSpockTest extends Specification {
    def 'EnemyX Basic movement Test'(){
        given:
            def enemy = new EnemyX(10, 0)

        when:
            enemy.update()

        then:
            enemy.getPosition().getX() == enemy.getInitialPos().getX() + enemy.getVx()
    }

    def 'Enemy Reaching Right Boundary'(){
        given:
            def enemy = new EnemyX(10, 0)
            enemy.setPosition(enemy.getInitialPos().getX() + enemy.getRange(),0)

        when:
            enemy.update()

        then:
            enemy.getPosition().getX() == enemy.getInitialPos().getX() + enemy.getRange() + enemy.getVx()
    }

    def 'Enemy Reaching Left Boundary'() {
        given:
            def enemy = new EnemyX(10, 0)
            enemy.setVx(-enemy.getVx())
        when:
            enemy.update()
        then:
            enemy.getPosition().getX() == enemy.getInitialPos().getX() + enemy.getVx()
    }
}

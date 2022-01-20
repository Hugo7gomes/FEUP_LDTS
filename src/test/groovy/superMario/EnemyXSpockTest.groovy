package superMario


import spock.lang.Specification
import superMario.enemies.EnemyX;

class EnemyXSpockTest extends Specification {
    def 'EnemyX Basic movement Test'(){
        given:
            def enemy = new EnemyX(10, 0)

        when:
            enemy.update()

        then:
            enemy.getPosition().getX() == (enemy.getInitialPos().getX() + enemy.getVx())
    }

    def 'Enemy Reaching Right Boundary'(){
        given:
            def enemy = new EnemyX(10, 0)
            enemy.getPosition().setX(enemy.getInitialPos().getX() + enemy.getRange())

        when:
            enemy.update()

        then:
            enemy.getPosition().getX() == (enemy.getInitialPos().getX() + enemy.getRange() + enemy.getVx())
    }

    def 'Enemy Reaching Left Boundary'() {
        given:
            def enemy = new EnemyX(10, 0)
            enemy.setVx(-enemy.getVx())
        when:
            enemy.update()
        then:
            enemy.getPosition().getX() == (enemy.getInitialPos().getX() + enemy.getVx())
    }
}

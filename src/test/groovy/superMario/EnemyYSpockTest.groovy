package superMario


import spock.lang.Specification
import superMario.enemies.EnemyY

class EnemyYSpockTest extends Specification {
    def 'EnemyY Basic Movement Test'(){
        given:
            def enemy = new EnemyY(10,10)

        when:
            enemy.update()

        then:
            enemy.getPosition().getY() == enemy.getInitialPos().getY() + enemy.getVy()
    }

    def 'Enemy Reaching Bottom Boundary'(){
        given:
        def enemy = new EnemyY(10, 0)
        enemy.getPosition().setY(enemy.getInitialPos().getY() + enemy.getRange())

        when:
        enemy.update()

        then:
        enemy.getPosition().getY() == enemy.getInitialPos().getY() + enemy.getRange() + enemy.getVy()
    }

    def 'Enemy Reaching Upper Boundary'() {
        given:
        def enemy = new EnemyY(10, 0)
        enemy.setVy(-enemy.getVy())
        when:
        enemy.update()
        then:
        enemy.getPosition().getY() == enemy.getInitialPos().getY() + enemy.getVy()
    }
}


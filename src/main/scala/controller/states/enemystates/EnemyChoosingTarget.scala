package controller.states.enemystates

import characters.WCharacter
import characters.enemies.TEnemy
import controller.GameController
import controller.states.{AbstractGameState, DoingAction}

/** State class for the enemy to choose a target.
 *
 * @param attacker The enemy who attacks. */
class EnemyChoosingTarget(private val attacker: TEnemy) extends AbstractGameState {

  /** Changes the state of the controller.*/
  def update(controller: GameController): Unit = {
    val charArray: Array[WCharacter] = controller.getAllies
    var selectedCharacter: Option[WCharacter] = None
    for(c <- charArray) {
      if (c.getHealthPoints > 0 && selectedCharacter.isEmpty) {
        selectedCharacter = Some(c)
      }
    }
    controller.state = new DoingAction(attacker, selectedCharacter.get)
  }

  /** Returns true because this state is EnemyChoosingTarget. */
  override def isEnemyChoosingTarget: Boolean = true
}

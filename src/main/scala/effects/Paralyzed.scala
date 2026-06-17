package effects

import characters.enemies.TEnemy

/** Class for the effect of throwing a spell that burns the target.*/
class Paralyzed extends AbstractEffect(1) {

  override def apply(char: TEnemy): Unit = {
    if(turns == 0) {
      char.setAction("attack")
    }
    else {
      char.setAction("skip")
      turns -= 1
    }
  }
}

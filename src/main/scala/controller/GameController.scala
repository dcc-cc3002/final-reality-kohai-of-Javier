package controller

import characters.enemies.TEnemy
import controller.states._
import programmer.{Programmer, TProgrammer}
import characters.WCharacter
import party.{Party, TParty}

import scala.collection.mutable.ArrayBuffer

/** Class for the game controller.
 * The constructor initializes the game
 * @param characterList The list of characters controller by the player to be added to the game.
 * @param enemyList The list of enemies to be added to the game.
 * */
class GameController(private[controller] val characterList: List[WCharacter], private[controller] val enemyList: List[TEnemy]) {

  if(characterList.size != 3)
    throw new Exception("Error: The player must start with exactly 3 characters.")
  if(enemyList.size < 1)
    throw new Exception("Error: The game must be initialized with at leas one enemy.")

  private[controller] var turnProgrammer: TProgrammer = new Programmer
  private[controller] var playerParty: TParty = new Party
  for(char <- characterList) {
    turnProgrammer.addCharacter(char)
    playerParty.addCharacter(char)
  }
  for(char <- enemyList)
    turnProgrammer.addCharacter(char)

  private[controller] var state: GameState = new TurnProgramming

  /** It updates the state of the controller */
  private[controller] def update(): Unit = state.update(this)

  /** It shows the game is finished. */
  private[controller] def isFinished: Boolean = win() || lose()

  /** Returns true if the player lost. */
  private[controller] def lose(): Boolean = playerParty.isDefeated()

  /** Returns true if the player won. */
  private[controller] def win(): Boolean = {
    for(enemy <- enemyList) {
      if(enemy.getHealthPoints != 0)
        return false
    }
    true
  }
}
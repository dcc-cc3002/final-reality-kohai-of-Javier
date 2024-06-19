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
  // Current game state
  private[controller] var state: GameState = _
  private[controller] var turnProgrammer: TProgrammer = _
  private[controller] var playerParty: TParty = _

  println(characterList.size)
  if(characterList.size != 3)
    throw new Exception("Error: The player must start with exactly 3 characters.")
  if(enemyList.size < 1)
    throw new Exception("Error: The game must be initialized with at leas one enemy.")

  turnProgrammer = new Programmer
  playerParty = new Party
  for(char <- characterList) {
    turnProgrammer.addCharacter(char)
    playerParty.addCharacter(char)
  }
  for(char <- enemyList)
    turnProgrammer.addCharacter(char)

  state = new TurnProgramming

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

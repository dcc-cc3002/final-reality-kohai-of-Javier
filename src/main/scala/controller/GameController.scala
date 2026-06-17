package controller

import controller.states._
import programmer.{TProgrammer, Programmer}
import characters.TCharacter

/** Class for the game controller.
 * The constructor initializes the game
 * @param characterList The list of characters to be added to the game.
 * */
class GameController(private val characterList: List[TCharacter]) {
  // Current game state
  var state: GameState = _
  var turnProgrammer: TProgrammer = new Programmer

  for(char <- characterList)
    turnProgrammer.addCharacter(char)

  state = new TurnProgramming()

  def update: Unit = state.update(this)


}

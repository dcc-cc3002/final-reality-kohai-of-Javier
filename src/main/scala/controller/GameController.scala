package controller

import characters.enemies.TEnemy
import controller.states._
import programmer.{Programmer, TProgrammer}
import characters.{TCharacter, WCharacter}
import party.{Party, TParty}
import view.GameView
import weapons.Weapon

import scala.collection.mutable.ArrayBuffer

/** Class for the game controller.
 * The constructor initializes the game
 * @param characterArray The list of characters controller by the player to be added to the game.
 * @param enemyArray The list of enemies to be added to the game.
 * @oaram weaponArray The list of available weapons for playable characters.
 * */
class GameController(private val view: GameView, private[controller] val characterArray: Array[WCharacter], private[controller] val enemyArray: Array[TEnemy], private[controller] val weaponArray: Array[Weapon] = Array()) {

  if(characterArray.length != 3)
    throw new Exception("Error: The player must start with exactly 3 characters.")
  if(enemyArray.length < 1)
    throw new Exception("Error: The game must be initialized with at leas one enemy.")

  private[controller] var turnProgrammer: TProgrammer = new Programmer
  private[controller] var playerParty: TParty = new Party
  for(char <- characterArray) {
    turnProgrammer.addCharacter(char)
    playerParty.addCharacter(char)
  }
  for(char <- enemyArray)
    turnProgrammer.addCharacter(char)

  private[controller] var state: GameState = new TurnProgramming

  /** Gets an integer from the keyboard. */
  private[controller] def getNumericalInput: Int = view.getNumericalInput

  /** Shows all characters, both playable and enemies. */
  private[controller] def showCharacters(): Unit = view.showCharacters(characterArray, enemyArray)

  /** Shows all enemies. */
  private[controller] def showEnemies(): Unit = view.showEnemies(enemyArray)

  /** Shows all available weapons. */
  private[controller] def showWeapons(): Unit = view.showWeapons(weaponArray)

  /** Shows all possible actions for a common playable character. */
  private[controller] def showActions(): Unit = view.showActions()

  /** Shows all possible actions for a magical character. */
  private[controller] def showMagicalActions(): Unit = view.showMagicalActions()

  /** Shows all spells. */
  private[controller] def showSpells(): Unit = view.showSpells()

  /** It prints the exception in question. */
  private[controller] def displayException(e: Exception): Unit = view.displayException(e)

  /** Getter for all characters. */
  private[controller] def getCharacters: Array[TCharacter] = {
    characterArray.concat(enemyArray)
  }

  /** Getter for playable characters */
  private[controller] def getAllies: Array[WCharacter] = characterArray

  /** Getter for enemies */
  private[controller] def getEnemies: Array[TEnemy] = enemyArray
  
  /** Getter for weapons */
  private[controller] def getWeapons: Array[Weapon] = weaponArray
  
  /** It handles the input from the user */
  private[controller] def handleInput(): Unit = state.handleInput(this)

  /** It updates the state of the controller */
  private[controller] def update(): Unit = state.update(this)

  /** It shows the game is finished. */
  private[controller] def isFinished: Boolean = win() || lose()

  /** Returns true if the player lost. */
  private[controller] def lose(): Boolean = playerParty.isDefeated()

  /** Returns true if the player won. */
  private[controller] def win(): Boolean = {
    for(enemy <- enemyArray) {
      if(enemy.getHealthPoints != 0)
        return false
    }
    true
  }

}
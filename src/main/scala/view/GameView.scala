package view

import characters.{TCharacter, WCharacter}
import characters.enemies.TEnemy
import weapons.Weapon

import scala.io.StdIn

/** Class implementing the IO from and to the user. */
class GameView {

  /** Reads an integer from the keyboard. */
  def getNumericalInput: Int = StdIn.readLine.toInt

  /** Displays a congratulations message to the user. */
  def displayWin(): Unit = println("Congratulations! You win!")

  /** Displays a "You lost." message to the user. */
  def displayLose(): Unit = println("You lost.")
  
  /** Displays a list with all playable characters */
  def showCharacters(a: Array[WCharacter], b: Array[TEnemy]): Unit = {}

  /** Shows all enemies. */
  def showEnemies(enemies: Array[TEnemy]): Unit = {}

  /** Shows all available weapons. */
  def showWeapons(weapons: Array[Weapon]): Unit = {}

  /** Shows all possible actions for a common playable character. */
  def showActions(): Unit = {}

  /** Shows all possible actions for a magical character. */
  def showMagicalActions(): Unit = {}

  /** Shows all spells. */
  def showSpells(): Unit = {}

  /** Prints the exception in question */
  def displayException(e: Exception): Unit = {}
}

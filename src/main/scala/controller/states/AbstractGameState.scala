package controller.states

import controller.GameController

abstract class AbstractGameState extends GameState {

  /** Checks whether the current state of the controller is ApplyingEffects. */
  def isApplyingEffects: Boolean = false

  /** Checks whether the current state of the controller is ChangingWeapon. */
  def isChangingWeapon: Boolean = false

  /** Checks whether the current state of the controller is CharacterElimination. */
  def isCharacterElimination: Boolean = false

  /** Checks whether the current state of the controller is ChoosingAction. */
  def isChoosingAction: Boolean = false

  /** Checks whether the current state of the controller is ChoosingSpell. */
  def isChoosingSpell: Boolean = false

  /** Checks whether the current state of the controller is ChoosingTarget. */
  def isChoosingTarget: Boolean = false

  /** Checks whether the current state of the controller is DoingAction. */
  def isDoingAction: Boolean = false

  /** Checks whether the current state of the controller is TurnProgramming. */
  def isTurnProgramming: Boolean = false

  /** Checks whether the current state of the controller is EnemyChoosingTarget. */
  def isEnemyChoosingTarget: Boolean = false

  /** Checks whether the current state of the controller is MagicalChangingWeapon. */
  def isMagicalChangingWeapon: Boolean = false

  /** Checks whether the current state of the controller is MagicalChoosingTarget. */
  def isMagicalChoosingTarget: Boolean = false

  /** Checks whether the current state of the controller is MagicalChoosingAction. */
  def isMagicalChoosingAction: Boolean = false

  /** Checks whether the current state of the controller is MagicalDoingAction. */
  def isMagicalDoingAction: Boolean = false


  /** It handles input from the user.
   * It does nothing by default and is overridden in states
   * that require the input from the user. */
  def handleInput(controller: GameController): Unit = {}
}

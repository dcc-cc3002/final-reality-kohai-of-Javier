package controller.states

import controller.GameController

/** Trait for a game state */
trait GameState {

  /** Handles the input from the user */
  def handleInput(controller: GameController): Unit

  /** Changes the state of the game controller */
  def update(controller: GameController) : Unit

  /** Checks whether the current state of the controller is ApplyingEffects. */
  def isApplyingEffects: Boolean

  /** Checks whether the current state of the controller is ChangingWeapon. */
  def isChangingWeapon: Boolean

  /** Checks whether the current state of the controller is CharacterElimination. */
  def isCharacterElimination: Boolean

  /** Checks whether the current state of the controller is ChoosingAction. */
  def isChoosingAction: Boolean

  /** Checks whether the current state of the controller is ChoosingSpell. */
  def isChoosingSpell: Boolean

  /** Checks whether the current state of the controller is ChoosingTarget. */
  def isChoosingTarget: Boolean

  /** Checks whether the current state of the controller is DoingAction. */
  def isDoingAction: Boolean

  /** Checks whether the current state of the controller is TurnProgramming. */
  def isTurnProgramming: Boolean

  /** Checks whether the current state of the controller is EnemyChoosingTarget. */
  def isEnemyChoosingTarget: Boolean

  /** Checks whether the current state of the controller is MagicalChangingWeapon. */
  def isMagicalChangingWeapon: Boolean

  /** Checks whether the current state of the controller is MagicalChoosingAction. */
  def isMagicalChoosingAction: Boolean

  /** Checks whether the current state of the controller is MagicalDoingAction. */
  def isMagicalDoingAction: Boolean

  /** Checks whether the current state of the controller is MagicalChoosingTarget. */
  def isMagicalChoosingTarget: Boolean

}
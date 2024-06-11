package controller.states

import controller.GameController

/** Trait for a game state */
trait GameState {

  /** Changes the state of the game controller */
  def update(controller: GameController) : Unit

  /** Checks whether the current state of the controller is ApplyingEffects. */
  def isApplyingEffects(): Boolean

  /** Checks whether the current state of the controller is ChangingWeapon. */
  def isChangingWeapon(): Boolean

  /** Checks whether the current state of the controller is CharacterElimination. */
  def isCharacterElimination(): Boolean

  /** Checks whether the current state of the controller is ChoosingAction. */
  def isChoosingAction(): Boolean

  /** Checks whether the current state of the controller is ChoosingSpell. */
  def isChoosingSpell(): Boolean

  /** Checks whether the current state of the controller is ChoosingTarget. */
  def isChoosingTarget(): Boolean

  /** Checks whether the current state of the controller is DoingAction. */
  def isDoingAction(): Boolean

  /** Checks whether the current state of the controller is TurnProgramming. */
  def isTurnProgramming(): Boolean
}
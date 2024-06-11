package controller.states

abstract class AbstractGameState extends GameState {

  /** Checks whether the current state of the controller is ApplyingEffects. */
  def isApplyingEffects(): Boolean = false

  /** Checks whether the current state of the controller is ChangingWeapon. */
  def isChangingWeapon(): Boolean = false

  /** Checks whether the current state of the controller is CharacterElimination. */
  def isCharacterElimination(): Boolean = false

  /** Checks whether the current state of the controller is ChoosingAction. */
  def isChoosingAction(): Boolean = false

  /** Checks whether the current state of the controller is ChoosingSpell. */
  def isChoosingSpell(): Boolean = false

  /** Checks whether the current state of the controller is ChoosingTarget. */
  def isChoosingTarget(): Boolean = false

  /** Checks whether the current state of the controller is DoingAction. */
  def isDoingAction(): Boolean = false

  /** Checks whether the current state of the controller is TurnProgramming. */
  def isTurnProgramming(): Boolean = false
}

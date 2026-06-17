package controller.states

import controller.GameController

trait GameState {
  def update(controller: GameController) : Unit

}
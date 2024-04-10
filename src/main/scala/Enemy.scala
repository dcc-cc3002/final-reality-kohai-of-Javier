import weapons.{Weapon, AuxiliaryWeapon}
import characters.CharacterTrait

class Enemy(val name: String, var healthPoints: Double, val attack: Double, val defense: Double, val weight: Double) extends CharacterTrait {
    var weapon: Option[Weapon] = Some(new AuxiliaryWeapon("attack", attack, 0, this))
}

package effects

/** Class for the effect of throwing a spell that poisons the target.
 * @param magicDamage The magic damage of the spell */
class Poisoned(magicDamage: Int) extends AbstractEffect(4, magicDamage/3) {

}

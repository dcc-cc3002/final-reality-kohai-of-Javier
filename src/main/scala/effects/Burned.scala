package effects

/** Class for the effect of throwing a spell that burns the target.
 * @param magicDamage The magic damage of the spell */
class Burned(magicDamage: Int) extends AbstractEffect(3, magicDamage/2) {

}

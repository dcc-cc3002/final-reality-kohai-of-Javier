package exceptions.spellexceptions

/**
 * Custom exception to signal an invalid target for some attack or spell.
 *
 * For instance, a positive spell can not be thrown to an enemy, nor a
 * negative spell to an ally.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new InvalidTargetException("A White Mage can not throw a positive spell to an Enemy.")
 * // => InvalidTargetException: An invalid target was found -- A White Mage can not throw a positive spell to an Enemy.
 * }}}
 *
 * @param details A descriptive message detailing the nature of the invalid stat.
 */
class InvalidTargetException(details: String) extends Exception(s"An invalid target was found -- $details")

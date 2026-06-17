package exceptions

/**
 * Custom exception to signal an attack between two characters of the same type.
 *
 * This exception is designed to provide more specific feedback about
 * an attack between two characters of the same type. For instance, an enemy
 * can not attack another enemy, and a (playable) character can not attack another character.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new SameTypeException("Enemy")
 * // => SameTypeException: A Enemy can not attack another Enemy.
 * }}}
 *
 * @param details The type of character, generally Character (a playable character) or Enemy.
 */
class SameTypeException(details: String) extends Exception(s"A $details can not attack another $details.")

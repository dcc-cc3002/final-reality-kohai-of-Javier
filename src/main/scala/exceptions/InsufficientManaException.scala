package exceptions

/**
 * Custom exception to signal a magical character does not have enough mana for some spell.
 *
 * This exception is designed to provide more specific feedback about
 * insufficient mana.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new InsufficientManaException(30, 20)
 * // => InsufficientManaException: The spell requires 30 amount of mana but this character only has 20.
 * }}}
 *
 * @param required The required amount of mana for the spell.
 * @param current The current amount of mana the magical character in question has.
 */
class InsufficientManaException(required: Int, current: Int) extends Exception(s"The spell requires $required amount of mana but this character only has $current.")

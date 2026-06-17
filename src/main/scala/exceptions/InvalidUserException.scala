package exceptions

/**
 * Custom exception to signal an invalid user of some spell.
 *
 * For instance, a black spell can not be thrown by a white mage,
 * and viceversa.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new InvalidUserException("A Black Mage can not use a white spell")
 * // => InvalidUserException: An invalid target was found -- A Black Mage can not use a white spell
 * }}}
 *
 * @param details A descriptive message detailing the nature of the problem.
 */
class InvalidUserException(details: String) extends Exception(s"An invalid user was found -- $details")

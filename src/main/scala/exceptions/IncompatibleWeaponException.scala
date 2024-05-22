package exceptions

/**
 * Custom exception to signal a weapon that is incompatible with the type of character.
 *
 * This exception is designed to provide more specific feedback about
 * incompatible weapons. For instance, if a bow is assigned to a paladin,
 * this exception could be thrown with a detailed
 * message indicating the nature of the problem.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new IncompatibleWeaponException("Bow")
 * // => IncompatibleWeaponException: An incompatible weapon was found -- A Bow can not be assigned to this character.
 * }}}
 *
 * @param weapon The type of weapon that is tried to be equiped to an incompatible charater.
 */
class IncompatibleWeaponException(weapon: String) extends Exception(s"An incompatible weapon was found -- A $weapon can not be assigned to this character.")

package exceptions

/**
 * Custom exception to signal a spell without a magic weapon.
 *
 * For a spell to be thrown, a magical character must carry a magic weapon.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new NoMagicWeaponException
 * // => NoMagicWeaponException: A magical character tried to throw a spell without a magic weapon.
 * }}}
 *
 */
class NoMagicWeaponException extends Exception(s"A magical character tried to throw a spell without a magic weapon.")

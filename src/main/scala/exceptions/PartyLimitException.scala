package exceptions

/**
 * Custom exception to signal a party with more characters than its limit number.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new PartyLimitException(3)
 * // => PartyLimitException: Too many characters: The maximum number of characters is 3.
 * }}}
 *
 * @param limit The maximum number of characters allowed in a Party.
 */
class PartyLimitException(limit: Int) extends Exception(s"Too many characters: The maximum number of characters is $limit.")

package exceptions

/**
 * Custom exception to signal trying to equip a weapon that already has an owner to another character.
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new DoubleEquipmentException("Bow")
 * // => DoubleEquipmentException: The weapon in question already has an owner.
 * }}}
 *
 * @param message A descriptive message detailing the nature of the exception.
 */
class DoubleEquipmentException(weaponName: String, ownerName: String, otherName: String) extends Exception(s"Tried to equip $weaponName to $otherName but it is already equipped to $ownerName.")

package party

import characters.WCharacter

/** The trait for a Party.
  * A party contains zero or more characters
  * If it has zero characters, it is considered defeated
  */
trait TParty {

    /** Adds a character to the party.*/
    def addCharacter(x: WCharacter): Unit

    /** Returns true if and only if there are no alive charcters in the party.*/
    def isDefeated(): Boolean
}


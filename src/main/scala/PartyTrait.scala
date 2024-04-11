import characters.CharacterTrait

/** The trait for a Party.
  * A party contains zero or more characters
  * If it has zero characters, it is considered defeated
  */
trait PartyTrait {
    def addCharacter(x: CharacterTrait): Unit
    def isDefeated(): Boolean
}


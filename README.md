# Final Reality

Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

This README is yours to complete it. Take this opportunity to describe your contributions, the
design decisions you've made, and any other information you deem necessary.

This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).

## Traits

The following files in the source code correspond to traits:

* Weapon.scala
* MagicWeapon.scala
* TCharacter.scala
* WCharacter.scala
* MagicalCharacter.scala
* PartyTrait.scala
* Programmer.scala
* TEnemy.scala

Traits don't contain values nor variables. Instead, getters are put to be implemented by their correponding classes.

## Classes design

### Character

Characters are the fighters in combats. There are different types of characters: common, magical and enemies. The player controls common and magical characters. Common and magical characters contain an equiped weapon (if applicable), name, health points, defense, weight and a list of weapons they can use. Enemies are considered characters (this avoids code duplication): they are different because they can not wear weapons, but in the program they have an auxiliary weapon with a default attack.

Characters have minimum value requirements. In the constructor of the corresponding class the object Require is used to check if the minimum value requirements are met. If they don't, an InvalidStatException is thrown.

### Party

Each party is composed of zero or more characters. At the beginning of each turn the program checks whether both the player party and the enemy party have at least one living characters. If it is not the case, the combat ends. Else, the combat continues.

A party is modeled using a class with:
* A list of characters
* A method for knowing if the party is defeated or not

### Weapon

A weapon can be carried by a common or magical character. It contains a name, attack, a weight and an owner. There are three types of weapons: common, magical, and auxiliaries (for enemies). Magical weapons also contain a magic attack.

Weapons have minimum value requirements. In the constructor of the corresponding class the object Require is used to check if the minimum value requirements are met. If they don't, an InvalidStatException is thrown.

### Turn scheduler

The turn scheduler is implemented in the Assigner class, which extends the Programmer Trait.

## Weapon compatiblity

Each type of character can only wear certain kinds of weapons. The type of weapon each type of characters can carry appears in the project statement. Weapon compatiblity is implemented using the double dispatch technique: for each character, there is a function in the trait Weapon to be implemented in the definition of each weapon class.

## Exceptions

### InvalidStatException

This exception is thrown when a game statistic is not valid. For instance, when initializing a new character its initial hp is negative.

### IncompatibleWeaponException

This exception is thrown when a weapon is assigned to a character who is not compatible. See "Weapon compatiblity" for more details.

## Tests

Tests for the AbstractWCharacter class are in the NinjaTest class. Tests for the AbstractWeapon class are in the AxeTest class.

# Final Reality

Final Reality is a simplified clone of the renowned game, Final Fantasy. Its main purpose is to
serve as an educational tool, teaching foundational programming concepts.

This README is yours to complete it. Take this opportunity to describe your contributions, the
design decisions you've made, and any other information you deem necessary.

This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).

## Classes design

### Character

Characters are the fighters in combats. There are different types of characters: common, magical and enemies. The player controls common and magical characters. Common and magical characters contain an equiped weapon (if applicable), name, health points, defense, weight and a list of weapons they can use. Enemies are considered characters (this avoids code duplication, even if they use different traits): they are different because they can not wear weapons, but in the program they have an auxiliary weapon with a default attack

### Party

Each party is composed of zero or more characters. At the beginning of each turn the program checks whether both the player party and the enemy party have at least one living characters. If it is not the case, the combat ends. Else, the combat continues.

A party is modeled using a class with:
* A list of characters
* A method for knowing if the party is defeated or not

### Weapon

A weapon can be carried by a common or magical character. It contains a name, attack, a weight and an owner. There are three types of weapons: common, magical, and auxiliaries (for enemies). Magical weapons also contain a magic attack.

## Weapon compatiblity

Each type of character can only wear certain kinds of weapons. For knowing whether a weapon and a character are compatible, a Set of pairs (character, weapon) is keeped. Each character has a list of weapons it can wear, and each weapon has a list of characters it can be used with.

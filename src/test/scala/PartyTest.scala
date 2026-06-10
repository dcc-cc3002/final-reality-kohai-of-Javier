import scala.collection.mutable.ArrayBuffer
import characters.CharacterTrait
import characters.Ninja

class PartyTest extends munit.FunSuite {

    test("isDefeated") {
        //Arrange
        val sampleParty = new Party(new ArrayBuffer[CharacterTrait]())

        //Act
        val result: Boolean = sampleParty.isDefeated

        //Assert
        assertEquals(result, true)
    }

    //We test whether addCharacter methods works
    test("character added") {
        //Arrange
        val sampleParty = new Party(new ArrayBuffer[CharacterTrait]())
        sampleParty.addCharacter(new Ninja("Ninja 1", 100.0, 50.0, 70.1))

        //Act
        val result: Boolean = sampleParty.isDefeated

        //Assert
        assertEquals(result, false)
    }
}

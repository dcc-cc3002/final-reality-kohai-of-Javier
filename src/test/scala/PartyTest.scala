class PartyTest extends munit.FunSuite {

    override beforeEach(context: BeforeEach): Unit = {
        var characters: ArrayBuffer[Character] = new ArrayBuffer[Character]()
        val sampleParty = new Party(characters)
    }

    test("isDefeated") {
        //Act
        val result: Boolean = sampleParty.isDefeated

        //Assert
        assertEquals(result == true)
    }

    test("character added") = {
        //We test whether addCharacter methods works
        //Arrange
        simpleParty.addCharacter(new Ninja())

        //Act
        val result: Boolean = sampleParty.isDefeated

        //Assert
        assert(result == false)
    }
}

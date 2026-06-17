package programmer

import scala.collection.mutable
import characters.TCharacter
import characters.Ninja

class ProgrammerTest extends munit.FunSuite {
    var testProgrammer: Programmer = new Programmer()
    val testNinja: TCharacter = new Ninja("Ninja 1", 100, 50, 70)

    override def beforeEach(context: BeforeEach): Unit = {
        testProgrammer = new Programmer()
        testProgrammer.addCharacter(testNinja)
    }

    test("Add character") {
        val charactersList: List[(Int, TCharacter)] = testProgrammer.getCharacters()
        assertEquals(charactersList.isEmpty, false)
    }

    test("Remove character") {
        testProgrammer.removeCharacter(testNinja)

        val charactersList: List[(Int, TCharacter)] = testProgrammer.getCharacters()
        assertEquals(charactersList.isEmpty, true)
    }

    test("Augment Action Bar") {
        //Test
        testProgrammer.augmentActionBar(10)

        val charactersList: List[(Int, TCharacter)] = testProgrammer.getCharacters()
        assertEquals(charactersList.head._1, 10)
    }

    test("Max action bar") {
        //Test
        assertEquals(testProgrammer.maxActionBar, 0)

        //Test 2
        testProgrammer.augmentActionBar(10)
        assertEquals(testProgrammer.maxActionBar, 10)

        //Test 3
        testProgrammer.addCharacter(new Ninja("Ninja 2", 100, 50, 70))
        testProgrammer.augmentActionBar(10)
        assertEquals(testProgrammer.maxActionBar, 20)
    }

    test("Restart action bar") {
        testProgrammer.augmentActionBar(10)
        testProgrammer.restartActionBar(testNinja)

        assertEquals(testProgrammer.maxActionBar, 0)
    }

    test("Completed action bar") {
        //Test
        assertEquals(testProgrammer.completedActionBar(testNinja), false)

        //Test 2
        testProgrammer.augmentActionBar(testNinja.fullActionBar)
        assertEquals(testProgrammer.completedActionBar(testNinja), true)
    }

    test("Throw complete characters") {
        //Test
        val testNinja2: TCharacter = new Ninja("Ninja 2", 100, 50, 70)
        val testNinja3: TCharacter = new Ninja("Ninja 3", 100, 50, 70)
        testProgrammer.augmentActionBar(10)
        testProgrammer.addCharacter(testNinja2)
        testProgrammer.augmentActionBar(20)
        testProgrammer.addCharacter(testNinja3)
        var completeCharacters: List[TCharacter] = testProgrammer.throwCompleteCharacters

        assertEquals(completeCharacters.isEmpty, true)

        //Test 2
        testProgrammer.augmentActionBar(60)
        completeCharacters = testProgrammer.throwCompleteCharacters
        assertEquals(completeCharacters, List(testNinja, testNinja2))
    }

    test("Select character") {
        testProgrammer.augmentActionBar(10)
        testProgrammer.addCharacter(new Ninja("Ninja 2", 100, 50, 70))
        testProgrammer.augmentActionBar(20)
        testProgrammer.addCharacter(new Ninja("Ninja 3", 100, 50, 70))
        testProgrammer.augmentActionBar(60)

        val selected: TCharacter = testProgrammer.selectCharacter
        assertEquals(selected, testNinja)
    }

    test("Get characters") {
        val charactersList: List[(Int, TCharacter)] = testProgrammer.getCharacters
        assertEquals((0, testNinja), charactersList.head)
    }
}

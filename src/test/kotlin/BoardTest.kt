import org.junit.Assert.assertEquals
import org.junit.Test

class BoardTest {

    @Test
    fun shouldConvertStringToArray() {
        val input = "*.\n" +
                "..\n"

        val board = Board(input)
        print(board)
    }


    @Test
    fun `convert to char`() {
        val input = "....\n" +
                ".*.*\n" +
                "....\n" +
                "....\n"
        val board = Board(input)
        val char: Char = board.convertIntToChar(3)

        assertEquals('3', char)
    }


    @Test
    fun `convert array to string`() {
        val input = "....\n" +
                ".*.*\n" +
                "....\n" +
                "....\n"

        val board = Board(input)
        val result = board.toString()

        assertEquals(input, result)
    }

    @Test
    fun `calculate value`() {
        val input = "....\n" +
                ".*.*\n" +
                "....\n" +
                "....\n"

        val board = Board(input)
        val result = board.countSides(2, 1)
        assertEquals(2, result)
    }

    @Test
    fun `calculate value on left bounds`() {
        val input = "....\n" +
                ".*.*\n" +
                "....\n" +
                "....\n"
        val board = Board(input)
        val result = board.countSides(0, 1)
        assertEquals(1, result)
    }

    @Test
    fun `calculate value on right bounds`() {
        val input = "....\n" +
                ".**.\n" +
                "....\n" +
                "....\n"
        val board = Board(input)
        val result = board.countSides(3, 1)
        assertEquals(1, result)
    }

    @Test
    fun `should count below`() {
        val input = "....\n" +
                "***.\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countBelow(1, 0)

        assertEquals(3, result)
    }

    @Test
    fun `should not count below when bottom line`() {
        val input = "....\n" +
                "***.\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countBelow(1, 3)

        assertEquals(0, result)
    }

    @Test
    fun `should count and ignore left bound`() {
        val input = "....\n" +
                "***.\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countBelow(0, 0)

        assertEquals(2, result)
    }

    @Test
    fun `should count above and ignore right bound`() {
        val input = "....\n" +
                "***.\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countAbove(3, 2)

        assertEquals(1, result)
    }


    @Test
    fun `should not count above when on top line`() {
        val input = "....\n" +
                "***.\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countAbove(1, 0)

        assertEquals(0, result)
    }

    @Test
    fun `should count above`() {
        val input = "....\n" +
                "***.\n" +
                "*...\n" +
                "....\n"

        val board = Board(input)
        val result = board.countAbove(1, 2)

        assertEquals(3, result)
    }

}
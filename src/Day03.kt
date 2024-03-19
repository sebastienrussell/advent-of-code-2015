fun main() {
    fun String.toCoordinates(): List<Pair<Int, Int>> {
        val coordinates = mutableListOf(0 to 0)
        var current = 0 to 0
        forEach {
            current = when (it) {
                '^' -> current.first to current.second + 1
                'v' -> current.first to current.second - 1
                '>' -> current.first + 1 to current.second
                else -> current.first - 1 to current.second
            }
            coordinates.add(current.copy())
        }

        return coordinates
    }

    fun part1(input: List<String>): Int {
        return input.first().toCoordinates().toSet().count()
    }

    fun part2(input: List<String>): Int {
        val santa: StringBuilder = StringBuilder()
        val roboSanta: StringBuilder = StringBuilder()

        input.first().forEachIndexed { index, c ->
            when (index % 2) {
                0 -> santa.append(c)
                1 -> roboSanta.append(c)
            }
        }

        return (santa.toString().toCoordinates() + roboSanta.toString().toCoordinates()).toSet().count()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part2(testInput) == 3)

    val input = readInput("Day03")
    print("Part 1 :")
    part1(input).println()
    print("Part 2 :")
    part2(input).println()
}

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("DayXX_test")
    check(part1(testInput) == 1)

    val input = readInput("DayXX")
    print("Part 1 :")
    part1(input).println()
    print("Part 2 :")
    part2(input).println()
}

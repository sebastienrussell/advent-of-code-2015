fun main() {
    fun part1(input: List<String>): Int {
        var floor = 0
        input.first().forEach {
            when (it) {
                '(' -> floor++
                ')' -> floor--
            }
        }
        return floor
    }

    fun part2(input: List<String>): Int {
        var floor = 0
        var firstBasementPosition = 0

        val line = input.first()
        var i = 0
        while (firstBasementPosition == 0) {
            when (line[i]) {
                '(' -> floor++
                ')' -> floor--
            }
            if (floor == -1)
                firstBasementPosition = i
            else
                i++
        }
        return firstBasementPosition + 1
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

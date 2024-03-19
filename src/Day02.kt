fun main() {
    fun calculateSurfaceArea(l: Int, w: Int, h: Int) =
        2 * l * w + 2 * w * h + 2 * h * l

    fun calculateSlack(l: Int, w: Int, h: Int) =
        listOf(l, w, h).sorted().take(2).let { (first, last) ->
            first * last
        }

    fun part1(input: List<String>): Int =
        input.sumOf { line ->
            val (length, width, height) = line.split("x").map { it.toInt() }.take(3)
            calculateSurfaceArea(length, width, height) + calculateSlack(length, width, height)
        }

    fun calculateWrappingLength(l: Int, w: Int, h: Int) =
        listOf(l, w, h).sorted().take(2).let { (a, b) ->
            a * 2 + b * 2
        }

    fun calculateBowLength(l: Int, w: Int, h: Int) =
        l * w * h


    fun part2(input: List<String>): Int =
        input.sumOf { line ->
            val (length, width, height) = line.split("x").map { it.toInt() }.take(3)
            calculateWrappingLength(length, width, height) + calculateBowLength(length, width, height)
        }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 48)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

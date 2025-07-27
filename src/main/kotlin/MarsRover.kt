package dev.frtgh01

import dev.frtgh01.Heading.CardinalPoint
import dev.frtgh01.Heading.Heading

class MarsRover(var position: Point2D, var heading: Heading) {
    companion object MarsRoverClass {
        // Map with all the possible Headings
        // where the key is the CardinalPoint for that Heading.
        val headings: Map<CardinalPoint, Heading> = listOf(
                Heading(CardinalPoint.NORTH, Point2D(0, 1), Point2D(0, -1), CardinalPoint.EAST, leftCardinalPoint = CardinalPoint.WEST),
                Heading(CardinalPoint.EAST, Point2D(1, 0), Point2D(-1, 0), CardinalPoint.SOUTH, leftCardinalPoint = CardinalPoint.NORTH),
                Heading(CardinalPoint.SOUTH, Point2D(0, -1), Point2D(0, 1), CardinalPoint.WEST, leftCardinalPoint = CardinalPoint.EAST),
                Heading(CardinalPoint.WEST, Point2D(-1, 0), Point2D(1, 0), CardinalPoint.NORTH, leftCardinalPoint = CardinalPoint.SOUTH),
            ).associateBy { heading -> heading.cardinalPoint() }

        fun at(position: Point2D, cardinalPoint: CardinalPoint): MarsRover = MarsRover(position, headingFor(cardinalPoint))

        fun headingFor(cardinalPoint: CardinalPoint): Heading = headings.getValue(cardinalPoint)

        fun invalidCommandErrorDescription(): String = "Invalid Command"
    }

    fun process(commands: String) {
        commands.forEach(::processCommand)
    }

    fun isAt(position: Point2D, heading: CardinalPoint): Boolean {
        return this.position == position && this.heading.cardinalPoint() == heading
    }

    private fun processCommand(command: Char) {
        when (command) {
            'f' -> addToPosition(this.heading.forwardPoint())
            'b' -> addToPosition(this.heading.backwardPoint())
            'r' -> newHeadingFor(this.heading.rightCardinalPoint())
            'l' -> newHeadingFor(this.heading.leftCardinalPoint())
            else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
        }
    }

    private fun addToPosition(point: Point2D) {
        this.position += point
    }

    private fun newHeadingFor(cardinalPoint: CardinalPoint) {
        this.heading = headingFor(cardinalPoint)
    }
}
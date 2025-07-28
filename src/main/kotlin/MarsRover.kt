package dev.frtgh01

import dev.frtgh01.Heading.CardinalPoint
import dev.frtgh01.Heading.Heading

class MarsRover(var position: Point2D, var heading: Heading) {
    companion object MarsRoverClass {
        fun at(position: Point2D, heading: Heading): MarsRover = MarsRover(position, heading)
        fun invalidCommandErrorDescription(): String = "Invalid Command"
    }

    fun process(commands: String) {
        commands.forEach(::processCommand)
    }

    fun isAt(position: Point2D, heading: Heading): Boolean {
        return this.position == position && this.heading == heading
    }

    private fun processCommand(command: Char) {
        when (command) {
            'f' -> moveForward()
            'b' -> moveBackward()
            'r' -> rotateRight()
            'l' -> rotateLeft()
            else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
        }
    }

    private fun moveForward() {
        this.position += this.heading.forwardDelta()
    }

    private fun moveBackward() {
        this.position -= this.heading.forwardDelta()
    }

    private fun rotateRight() {
        this.heading = this.heading.rightHeading()
    }

    private fun rotateLeft() {
        this.heading = this.heading.leftHeading()
    }
}
package dev.frtgh01

class MarsRover(var position: Point2D, val heading: Heading) {
    companion object New{
        fun at(position: Point2D, heading: Heading): MarsRover = MarsRover(position, heading)
    }

    fun process(commands: String) {
        commands.forEach { command -> this.position += Point2D(0, 1) }
    }

    fun isAt(position: Point2D, heading: Heading): Boolean {
        return this.position == position && this.heading == heading
    }
}
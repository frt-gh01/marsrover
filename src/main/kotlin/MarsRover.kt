package dev.frtgh01

class MarsRover(val position: Position2D, val heading: Heading) {
    companion object New{
        fun at(position: Position2D, heading: Heading): MarsRover = MarsRover(position, heading)
    }

    fun process(commands: String) {}

    fun isAt(position: Position2D, heading: Heading): Boolean {
        return this.position == position && this.heading == heading
    }
}
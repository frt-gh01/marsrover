package dev.frtgh01

class MarsRover(var position: Point2D, var heading: Heading) {
    companion object New{
        fun at(position: Point2D, heading: Heading): MarsRover = MarsRover(position, heading)
    }

    fun process(commands: String) {
        commands.forEach { command ->
            when (command) {
                'f' -> this.position += Point2D(0, 1)
                'b' -> this.position += Point2D(0, -1)
                'r' -> this.heading = Heading.EAST
                'l' -> this.heading = Heading.WEST
            }
        }
    }

    fun isAt(position: Point2D, heading: Heading): Boolean {
        return this.position == position && this.heading == heading
    }
}
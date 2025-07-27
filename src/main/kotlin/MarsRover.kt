package dev.frtgh01

class MarsRover(var position: Point2D, var heading: Heading) {
    companion object MarsRoverClass {
        fun at(position: Point2D, heading: Heading): MarsRover = MarsRover(position, heading)
        fun invalidCommandErrorDescription(): String = "Invalid Command"
    }

    fun process(commands: String) {
        commands.forEach(::processCommand)
    }

    private fun processCommand(command: Char) {
        when (this.heading) {
            Heading.NORTH -> {
                when (command) {
                    'f' -> this.position += Point2D(0, 1)
                    'b' -> this.position += Point2D(0, -1)
                    'r' -> this.heading = Heading.EAST
                    'l' -> this.heading = Heading.WEST
                    else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
                }
            }
            Heading.EAST -> {
                when (command) {
                    'f' -> this.position += Point2D(1, 0)
                    'b' -> this.position += Point2D(-1, 0)
                    'r' -> this.heading = Heading.SOUTH
                    'l' -> this.heading = Heading.NORTH
                    else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
                }
            }
            Heading.SOUTH -> {
                when (command) {
                    'f' -> this.position += Point2D(0, -1)
                    'b' -> this.position += Point2D(0, 1)
                    'r' -> this.heading = Heading.WEST
                    'l' -> this.heading = Heading.EAST
                    else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
                }
            }
            Heading.WEST -> TODO()
        }

    }

    fun isAt(position: Point2D, heading: Heading): Boolean {
        return this.position == position && this.heading == heading
    }
}
package dev.frtgh01

data class Point2D(val x: Int, val y: Int) {
    operator fun plus(other: Point2D): Point2D = Point2D(x + other.x, y + other.y)
}
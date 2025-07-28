package dev.frtgh01.Heading

import dev.frtgh01.Point2D

class Heading(val cardinalPoint: CardinalPoint, val forwardDelta: Point2D,
              val rightCardinalPoint: CardinalPoint, val leftCardinalPoint: CardinalPoint) {

    fun cardinalPoint(): CardinalPoint = this.cardinalPoint
    fun forwardPoint(): Point2D = this.forwardDelta
    fun rightCardinalPoint(): CardinalPoint = this.rightCardinalPoint
    fun leftCardinalPoint(): CardinalPoint = this.leftCardinalPoint
}
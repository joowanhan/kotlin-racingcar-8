package racingcar.domain.strategy

fun interface MovingStrategy {
	
	fun isMovable(): Boolean
}
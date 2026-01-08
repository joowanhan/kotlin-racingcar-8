package racingcar.domain

import racingcar.domain.strategy.MovingStrategy
import racingcar.dto.CarDto

class Car(val name: String) {
	
	init {
		// require(name.isNotEmpty()) { "이름이 빈칸으로 입력될 수 없습니다." } // 없어도 될듯(InputView에서 빈 이름 처리)
		require(name.length <= 5) { "이름이 5자 초과입니다.: $name" }
	}
	
	var step = 0
	
	companion object {
		
		const val THRESHOLD = 4
		fun extractWinner(cars: List<Car>): List<String> {
			val maxStep = cars.maxOfOrNull { car -> car.step }
			return cars.filter { it.step == maxStep }.map { it.name }
			
		}
	}
	
	fun move(movingStrategy: MovingStrategy) {
		if (movingStrategy.isMovable()) {
			++step
		}
	}
	
	fun toDto(): CarDto {
		return CarDto(name, step)
	}
	
}
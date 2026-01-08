package racingcar.domain

import racingcar.domain.strategy.MovingStrategy
import racingcar.dto.CarDto

class Car(val name: String) {
	
	init {
		// require(name.isNotEmpty()) { "이름이 빈칸으로 입력될 수 없습니다." } // 없어도 될듯(InputView에서 빈 이름 처리)
		require(name.length <= 5) { "이름이 5자 초과입니다.: $name" }
	}
	
	var step = 0
	
	fun move(movingStrategy: MovingStrategy) {
		if (movingStrategy.isMovable()) {
			++step
		}
	}
	
	fun toDto(): CarDto {
		return CarDto(name, step)
	}
	
}
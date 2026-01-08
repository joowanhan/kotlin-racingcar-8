package racingcar.view

import racingcar.domain.Car
import racingcar.dto.CarDto

object OutputView {
	
	val startMessage = "실행결과"
	
	fun printStart() {
		println(startMessage)
	}
	
	fun printRacing(carDto: CarDto) {
		println("${carDto.name} : ${"-".repeat(carDto.step)}")
	}
	
	fun printWinners(winners: List<String>) {
		val winningMessage = winners.joinToString(prefix = "최종 우승자 : ")
		println(winningMessage)
	}
	
	fun getStep(car: Car): String {
		return "-".repeat(car.step)
		
	}
}
package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
	
	val nameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
	val attemptsMessage = "시도할 횟수는 몇 회인가요?"
	
	fun readCarNames(): List<String> {
		println(nameMessage)
		val names = Console.readLine().split(",").filter { it.isNotBlank() }.map { it.trim() } // 빈 이름(,,) 전처리, 앞뒤 공백 제거
		require(names.isNotEmpty()) { "이름 입력값이 없습니다." }
		
		return names
		
	}
	
	fun readAttemptCount(): Int {
		println(attemptsMessage)
		val attempts = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("Invalid number format")
		require(attempts > 0) { "시도 횟수는 1 이상이어야 합니다." }
		return attempts
		
	}
	
}
package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
	// 자동차 이름, 시도 횟수 입력 테스트
	// 자동차 random값에 따른 threshold 및 이동 테스트
	// 공동우승자 출력이 잘 되는지 테스트
	//
	
	@Test
	fun `step에 따른 대시(-) 출력 테스트`() {
		// given
		val car = Car("pobi")
		car.step = 3
		// when
		val result = car.printStep()
		// then
		assertThat(result).isEqualTo("---")
	}
	
	@Test
	fun `extractWinners() 테스트`() {
		// given
		val pobi = Car("pobi")
		pobi.step = 3
		val wany = Car("wany")
		wany.step = 5
		val yeji = Car("yeji")
		yeji.step = 5
		
		val cars = listOf(pobi, wany, yeji)
		
		// when
		val winners = Car.extractWinners(cars)
		// then
		assertThat(winners).contains(wany, yeji)
		assertThat(winners).doesNotContain(pobi)
		
	}
	
	@Test
	fun `winningMessage() 테스트`() {
		// given
		val pobi = Car("pobi")
		pobi.step = 3
		val wany = Car("wany")
		wany.step = 5
		val yeji = Car("yeji")
		yeji.step = 5
		
		val cars = listOf(pobi, wany, yeji)
		
		// when
		val winningMessage = Car.winningMessage(cars)
		// then
		assertThat(winningMessage).contains("최종 우승자 : ", wany.name, yeji.name)
		assertThat(winningMessage).doesNotContain(pobi.name)
		
	}
	
}
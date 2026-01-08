package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.strategy.MovingStrategy

class CarsTest {
	
	@Test
	fun `모든 자동차가 전략에 따라 전진한다`() {
		// given
		val pobi = Car("pobi")
		val wany = Car("wany")
		
		val cars = Cars(listOf(pobi, wany))
		
		// when (SAM) (강추)
		cars.moveAll { true }
		
		// then
		assertThat(pobi.step).isEqualTo(1)
		assertThat(wany.step).isEqualTo(1)
	}
	
	@Test
	fun `전략이 false면 전진하지 않는다`() {
		// given
		val pobi = Car("pobi")
		val wany = Car("wany")
		
		val cars = Cars(listOf(pobi, wany))
		
		// 테스트용 전략: 무조건 true 반환 (람다 사용) SAM (비추)
		val falseStrategy = MovingStrategy { false }
		
		// when
		cars.moveAll(falseStrategy)
		
		// then
		assertThat(pobi.step).isEqualTo(0)
		assertThat(wany.step).isEqualTo(0)
		
	}
	
	@Test
	fun `승자가 한명일 때 제대로 뽑는지 확인한다`() {
		// given
		val pobi = Car("pobi")
		val wany = Car("wany")
		
		val cars = Cars(listOf(pobi, wany))
		
		pobi.move { true }
		pobi.move { true }
		wany.move { true }
		
		// when
		val winner = cars.extractWinner()
		
		// then
		assertThat(winner).contains("pobi")
		assertThat(winner).doesNotContain("wany")
		
	}
	
	fun `승자가 두명일 때 제대로 뽑는지 확인한다`() {
		// given
		val pobi = Car("pobi")
		val wany = Car("wany")
		
		val cars = Cars(listOf(pobi, wany))
		
		pobi.move { true }
		pobi.move { true }
		wany.move { true }
		wany.move { true }
		
		// when
		val winner = cars.extractWinner()
		
		// then
		assertThat(winner).contains("pobi", "wany")
		
	}
}
package racingcar.domain.strategy

import camp.nextstep.edu.missionutils.Randoms

// 이제 "0~9 사이의 랜덤 숫자가 4 이상이면 전진한다"라는 구체적인 규칙은 도메인 객체(Car)가 알 필요가 없어집니다.
// Car는 "전략이 가라고 하면 간다"는 단순한 책임만 가집니다.
// 코틀린에서는 클래스를 상속받을 때도, 인터페이스를 구현할 때도 똑같이 콜론(:)을 써.
// 의미: "나 RandomMovingStrategy는 MovingStrategy라는 규칙을 구현합니다.(이 인터페이스의 규칙을 따르겠습니다."
// 그래서 규칙에 적힌 isMovable() 기능을 반드시 내가 직접 만들어야(Override) 해.
class RandomMovingStrategy : MovingStrategy {
	
	override fun isMovable(): Boolean {
		val number = Randoms.pickNumberInRange(START_RANGE, END_RANGE)
		return number >= THRESHOLD
	}
	
	companion object {
		
		private const val START_RANGE = 0
		private const val END_RANGE = 9
		private const val THRESHOLD = 4
	}
}
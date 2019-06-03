package test.statistics.implementation;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import statistics.exception.StatisticsException;
import statistics.implementation.BasicOfStatistics;

class BasicOfStatisticsTest {

	@Before
	public void setup() {
		// 全体のセットアップ
		// purchase()用のセットアップ
		// history()用のセットアップ
	}

	@Test
	void test_getMaxValue_ok() {
		// テストデータ作成
		BigDecimal[] testDatas = new BigDecimal[5];
		BigDecimal decimal = new BigDecimal(-1);
		testDatas[0] = decimal;
		decimal = new BigDecimal(0);
		testDatas[1] = decimal;
		decimal = new BigDecimal(1);
		testDatas[2] = decimal;
		decimal = new BigDecimal(2);
		testDatas[3] = decimal;
		decimal = new BigDecimal(-2);
		testDatas[4] = decimal;

		BasicOfStatistics testClass = new BasicOfStatistics();
		try {
			assertEquals(new BigDecimal(2), testClass.getMaxValue(testDatas), "最大値の算出OK");
		} catch (StatisticsException e) {
			System.out.println(e.toString());
			fail(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
			fail(e.toString());
		}
	}

	@Test
	void test_getMaxValue_ok2() {
		// テストデータ作成
		BigDecimal[] testDatas = new BigDecimal[1];
		BigDecimal decimal = new BigDecimal(-1);
		testDatas[0] = decimal;

		BasicOfStatistics testClass = new BasicOfStatistics();
		try {
			// 1つのみの配列が渡された場合
			assertEquals(new BigDecimal(-1), testClass.getMaxValue(testDatas), "最大値の算出OK_1つのみの配列が渡された場合");
			// 配列の要素が0の場合
			assertThrows(StatisticsException.class, () -> {testClass.getMaxValue(new BigDecimal[0]);});
			// nullが渡された場合
			assertThrows(Exception.class, () -> {testClass.getMaxValue(null);});
		} catch (StatisticsException e) {
			System.out.println(e.toString());
			fail(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
			fail(e.toString());
		}
	}

}

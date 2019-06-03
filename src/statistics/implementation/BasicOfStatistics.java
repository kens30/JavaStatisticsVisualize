package statistics.implementation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import statistics.exception.StatisticsException;

/**
 * 統計の基本的な処理をまとめたサンプルクラス
 * 数値型一次元配列に対して各操作を行う
 * @author kens30
 */
public class BasicOfStatistics extends BaseImplement {

  /**
   * 一次元配列から最大値を算出する
   * @param datas 最大値の算出対象となる一次元配列
   * @return 最大値
   */
  public BigDecimal getMaxValue(BigDecimal[] datas) throws StatisticsException, Exception{
    BigDecimal maxResult = new BigDecimal(0);
    try {
      if (!validateLength(datas)) {
        throw new StatisticsException(StatisticsException.ERROR_CD_DATAS_LENGTH_ZERO);
      }
      // 要素が1つの場合はそのまま返す
      if (checkUnique(datas)) {
        return datas[datas.length - 1];
      }

      for (BigDecimal value : datas) {
        if (maxResult.compareTo(value) < 0) {
          maxResult = value;
        }
      }
    } catch (StatisticsException ex) {
      throw ex;
    } catch (Exception ex) {
      throw ex;
    }

    return maxResult;
  }

  /**
   * 一次元配列から最小値を算出する
   * @param datas 最小値の算出対象となる一次元配列
   * @return 最小値
   */
  public BigDecimal getMinValue(BigDecimal[] datas) throws StatisticsException, Exception {
    BigDecimal minResult = new BigDecimal(0);

    try {
      if (!validateLength(datas)) {
        throw new StatisticsException(StatisticsException.ERROR_CD_DATAS_LENGTH_ZERO);
      }
      // 要素が1つの場合はそのまま返す
      if (checkUnique(datas)) {
        return datas[datas.length - 1];
      }

      for (BigDecimal value : datas) {
        if (minResult.compareTo(value) > 0) {
          minResult = value;
        }
      }
    } catch (StatisticsException ex) {
      throw ex;
    } catch (Exception ex) {
      throw ex;
    }

    return minResult;
  }

  /**
   * 一次元配列から合計を算出する
   * @param datas 合計値の算出対象となる一次元配列
   * @return 合計値
   */
  public BigDecimal getSumValue(BigDecimal[] datas) throws StatisticsException, Exception {
    BigDecimal sumResult = new BigDecimal(0);

    try {
      if (!validateLength(datas)) {
        throw new StatisticsException(StatisticsException.ERROR_CD_DATAS_LENGTH_ZERO);
      }
      // 要素が1つの場合はそのまま返す
      if (checkUnique(datas)) {
        return datas[datas.length - 1];
      }

      for (BigDecimal value : datas) {
        sumResult = sumResult.add(value);
      }
  } catch (StatisticsException ex) {
    throw ex;
  } catch (Exception ex) {
    throw ex;
  }

    return sumResult;
  }

  /**
   * 一次元配列から平均値を算出する
   * @param datas 平均値の算出対象となる一次元配列
   * @return 平均値
   */
  public BigDecimal getAverageValue(BigDecimal[] datas) throws StatisticsException, Exception {
    BigDecimal resultValue = new BigDecimal(0);

    try {
      if (!validateLength(datas)) {
        throw new StatisticsException(StatisticsException.ERROR_CD_DATAS_LENGTH_ZERO);
      }
      // 要素が1つの場合はそのまま返す
      if (checkUnique(datas)) {
        return datas[datas.length - 1];
      }

      resultValue = this.getSumValue(datas).divide(new BigDecimal(datas.length));
    } catch (StatisticsException ex) {
      throw ex;
    } catch (Exception ex) {
      throw ex;
    }
    return resultValue;
  }

  /**
   * 一次元配列から中央値を算出する
   * @param datas 中央値の算出対象となる一次元配列
   * @return 中央値
   * @throws StatisticsException
   * @throws Exception
   */
  public BigDecimal getMedianValue(BigDecimal[] datas) throws StatisticsException, Exception {
    BigDecimal resultValue = new BigDecimal(0);

    try {
      if (!validateLength(datas)) {
        throw new StatisticsException(StatisticsException.ERROR_CD_DATAS_LENGTH_ZERO);
      }
      // 要素が1つの場合はそのまま返す
      if (checkUnique(datas)) {
        return datas[datas.length - 1];
      }

      datas = this.sort(datas);
      int centerLengthCount = new BigDecimal(datas.length).divide(new BigDecimal(2), 1, RoundingMode.HALF_UP).intValue();

      if (datas.length % 2 == 0) {
        // 偶数(中央の2値を比較)
        BigDecimal value1 = datas[centerLengthCount - 1];
        BigDecimal value2 = datas[centerLengthCount - 2];
        resultValue = value1.add(value2).subtract(new BigDecimal(2));
      } else {
        // 奇数
        resultValue = datas[centerLengthCount - 1];
      }
    } catch (StatisticsException ex) {
      throw ex;
    } catch (Exception ex) {
      throw ex;
    }
    return resultValue;
  }

  /**
   * 一次元配列から標準偏差を算出する
   * @param datas 標準偏差の算出対象となる一次元配列
   * @return 標準偏差
   * @throws StatisticsException
   * @throws Exception
   */
  public BigDecimal getStandardDeviationValue(BigDecimal[] datas) throws StatisticsException, Exception {
    BigDecimal resultValue = new BigDecimal(0);

    try {
      if (!validateLength(datas)) {
        throw new StatisticsException(StatisticsException.ERROR_CD_DATAS_LENGTH_ZERO);
      }

      // 平均算出
      BigDecimal average = getAverageValue(datas);
      // 各値の偏差を求めて、2乗
      BigDecimal[] arrDeviation = new BigDecimal[datas.length];
      for (int i = 0;i < datas.length;i++) {
        arrDeviation[i] = datas[i].subtract(average).multiply(new BigDecimal(2));
      }

      // 偏差の2乗の合計をデータの総数で割り、分散を算出
      BigDecimal variance = getSumValue(arrDeviation).subtract(new BigDecimal(datas.length));

      // 分散の平方根を算出して完了
      resultValue = new BigDecimal(Math.sqrt(new Double(variance.doubleValue())));
    } catch (StatisticsException ex) {
      throw ex;
    } catch (Exception ex) {
      throw ex;
    }
    return resultValue;
  }

  /**
   * 一次元配列から最頻値を算出する
   * @param datas 標準偏差の最頻値となる一次元配列
   * @return 最頻値
   * @throws StatisticsException
   * @throws Exception
   */
  public BigDecimal getModeValue(BigDecimal[] datas) throws StatisticsException, Exception {
    BigDecimal resultValue = new BigDecimal(0);

    try {
      if (!validateLength(datas)) {
        throw new StatisticsException(StatisticsException.ERROR_CD_DATAS_LENGTH_ZERO);
      }
      // 要素が1つの場合はそのまま返す
      if (checkUnique(datas)) {
        return datas[datas.length - 1];
      }

      Map<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
      for(BigDecimal data : datas) {
        Integer val = map.get(data);
        if (val == 0) {
          map.put(data, 1);
        } else {
          map.remove(data);
          map.put(data, val + 1);
        }
      }

      BigDecimal maxKey = null;
      Integer maxKeysCount = 0;
      for(BigDecimal key : map.keySet()) {
        if (maxKey == null) {
          maxKey = key;
          maxKeysCount = map.get(key);
        }else {
          if (maxKeysCount < map.get(key)) {
            maxKey = key;
            maxKeysCount = map.get(key);
          }
        }
      }

      resultValue = maxKey;
    } catch (StatisticsException ex) {
      throw ex;
    } catch (Exception ex) {
      throw ex;
    }
    return resultValue;
  }

  // 配列ソート
  private BigDecimal[] sort(BigDecimal[] datas) {
    Arrays.sort(datas);
    return datas;
  }
}

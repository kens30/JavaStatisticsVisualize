package statistics.implementation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import statistics.exception.StatisticsException;

/**
 * 数学処理を行うクラス
 * @author kens30
 */
public class MathCalculation extends BaseImplement {

	public static final String VECTOR_CALC_TYPE_ADD = "add";
	public static final String VECTOR_CALC_TYPE_SUBTRACT = "subtract";
	public static final String VECTOR_CALC_TYPE_SCALAR_MULTIPL = "scalar";
	public static final String VECTOR_CALC_TYPE_MULTIPL = "multipl";

	/**
	 * 絶対値を算出して返却する
	 * @param value 計算対象の値
	 * @return 絶対値
	 */
	public BigDecimal getAbsoluteValue(BigDecimal value) {
		BigDecimal resultValue = new BigDecimal(0);
		try {
			double tranValue = Math.abs(Double.parseDouble(value.toString()));
			resultValue = new BigDecimal(tranValue);
	    } catch (Exception ex) {
	      throw ex;
	    }

		return resultValue;
	}

	/**
	 * ベクトルに対する計算処理を行う
	 * @param vector1 計算対象のベクトル1
	 * @param vector2 計算対象のベクトル2
	 * @param scalar スカラー値
	 * @param calcType 計算種別
	 * @return 計算結果の配列
	 * @throws StatisticsException 処理例外
	 * @throws Exception 例外
	 */
	public BigDecimal[] calcVector(BigDecimal[] vector1, BigDecimal[] vector2,BigDecimal scalar, String calcType)
			throws StatisticsException, Exception {
		BigDecimal[] resultArr = null;
		try {
			if (calcType == null) {
				throw new StatisticsException(StatisticsException.ERROR_CD_FUNCTION_TYPE_NOT_SETTINGS);
			}
			// ベクトルの長さが異なる場合はエラーとする
			if (!VECTOR_CALC_TYPE_SCALAR_MULTIPL.equals(calcType)) {
				if (vector1.length != vector2.length) {
					throw new StatisticsException(StatisticsException.ERROR_CD_VECTOR_LENGTH_NOT_EQUALS);
				}
			}

			if (VECTOR_CALC_TYPE_ADD.equals(calcType)) {
				resultArr = addVector(vector1, vector2);
			} else if (VECTOR_CALC_TYPE_SUBTRACT.equals(calcType)) {
				resultArr = subtractVector(vector1, vector2);
			} else if (VECTOR_CALC_TYPE_SCALAR_MULTIPL.equals(calcType)) {
				resultArr = multiplScalarVector(vector1, scalar);
			} else if (VECTOR_CALC_TYPE_MULTIPL.equals(calcType)) {
				resultArr = multiplVector(vector1, vector2);
			}

		} catch (StatisticsException ex) {
			throw ex;
	    } catch (Exception ex) {
	    	throw ex;
	    }

		return resultArr;
	}

	/**
	 * ベクトルの加算処理
	 * @param vector1 計算対象のベクトル1
	 * @param vector2 計算対象のベクトル2
	 * @return 計算結果の配列
	 */
	private BigDecimal[] addVector(BigDecimal[] vector1, BigDecimal[] vector2) {
		List<BigDecimal> result = new ArrayList<BigDecimal>();
		for (int i = 0;i < vector1.length; i++) {
			result.add(vector1[i].add(vector2[i]));
		}
		return (BigDecimal[])result.toArray();
	}

	/**
	 * ベクトルの減算処理
	 * @param vector1 計算対象のベクトル1
	 * @param vector2 計算対象のベクトル2
	 * @return 計算結果の配列
	 */
	private BigDecimal[] subtractVector(BigDecimal[] vector1, BigDecimal[] vector2) {
		List<BigDecimal> result = new ArrayList<BigDecimal>();
		for (int i = 0;i < vector1.length; i++) {
			result.add(vector1[i].subtract(vector2[i]));
		}
		return (BigDecimal[])result.toArray();
	}

	/**
	 * ベクトルの定数倍処理
	 * @param vector 計算対象のベクトル
	 * @param scalar スカラー値
	 * @return 計算結果の配列
	 */
	private BigDecimal[] multiplScalarVector(BigDecimal[] vector, BigDecimal scalar) {
		List<BigDecimal> resultVector = new ArrayList<BigDecimal>();

		for(BigDecimal value : vector) {
			resultVector.add(value.multiply(scalar));
		}

		return (BigDecimal[])resultVector.toArray();
	}

	/**
	 * ベクトルの乗算処理
	 * @param vector1 処理対象のベクトル1
	 * @param vector2 処理対象のベクトル2
	 * @return 計算結果の配列
	 */
	private BigDecimal[] multiplVector(BigDecimal[] vector1, BigDecimal[] vector2) {
		List<BigDecimal> resultVector = new ArrayList<BigDecimal>();

		// TODO

		return (BigDecimal[])resultVector.toArray();
	}

	public BigDecimal[][] multiplMatricsVector(BigDecimal[][] matrix, BigDecimal[] vector) {
		// TODO

		return null;
	}

	public BigDecimal[][] multiplMatricsPeers(BigDecimal[][] matrix1, BigDecimal[][] matrix2)
			throws StatisticsException {
		try {
			// 左行列の列数と右行列の行数が等しいことを確認する
			if(matrix1[0].length != matrix2.length) {
				throw new StatisticsException(StatisticsException.ERROR_CD_VECTOR_LENGTH_NOT_EQUALS);
			}

			int matrix2RecordsLength = matrix2.length;
			int matrix2ColumnLength = matrix2[0].length;
			int currentRowIndex = 0;
			int currentColumnIndex = 0;

			// TODO
			BigDecimal[][] resultMatrix = new BigDecimal[matrix2RecordsLength][matrix2ColumnLength];
			int resultRowIndex = 0;
			int resultColumnIndex = 0;
			for(BigDecimal[] matrix1record : matrix1) {
				for(BigDecimal matrix1data : matrix1record) {
					for(int i = 0;i < (matrix2RecordsLength * matrix2ColumnLength);i++) {
						resultMatrix[resultRowIndex][resultColumnIndex] = matrix1data.multiply(matrix2[currentRowIndex][currentColumnIndex]);
						if (currentRowIndex < matrix2RecordsLength) {
							currentRowIndex += 1;
						} else if (currentRowIndex == matrix2RecordsLength) {
							currentRowIndex = 0;
							currentColumnIndex += 1;
						}
					}
				}
			}
		} catch (StatisticsException ex) {
			throw ex;
	    } catch (Exception ex) {
	    	throw ex;
	    }
		return null;
	}
}

package statistics.exception;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class StatisticsException extends Exception {
  public static String ERROR_CD_DATAS_LENGTH_ZERO = "00001";
  public static String ERROR_CD_FUNCTION_TYPE_NOT_SETTINGS = "00002";
  public static String ERROR_CD_VECTOR_LENGTH_NOT_EQUALS = "00003";
  private static String ERROR_MSG_DATAS_LENGTH_ZERO = "処理対象の配列要素が0です。";
  private static String ERROR_MSG_FUNCTION_TYPE_NOT_SETTINGS = "処理種別パラメータが設定されていません。";
  private static String ERROR_MSG_VECTOR_LENGTH_NOT_EQUALS = "計算対象になる複数のベクトルの要素数が異なります。";

  public enum ErrorCdEnum {
    DATAS_LENGTH_ZERO,
	FUNCTION_TYPE_NOT_SETTINGS,
	VECTOR_LENGTH_NOT_EQUALS;
    private final static EnumMap<ErrorCdEnum, String> errorCdMap;
    static{
      errorCdMap = new EnumMap<ErrorCdEnum, String>(ErrorCdEnum.class);
      errorCdMap.put(ErrorCdEnum.DATAS_LENGTH_ZERO, ERROR_CD_DATAS_LENGTH_ZERO);
      errorCdMap.put(ErrorCdEnum.FUNCTION_TYPE_NOT_SETTINGS, ERROR_CD_FUNCTION_TYPE_NOT_SETTINGS);
      errorCdMap.put(ErrorCdEnum.VECTOR_LENGTH_NOT_EQUALS, ERROR_CD_VECTOR_LENGTH_NOT_EQUALS);
    }

    public static String getValue(ErrorCdEnum mapKey) {
      return errorCdMap.get(mapKey);
    }
  }

  Map<ErrorCdEnum, String> errorCdEnum = new HashMap<ErrorCdEnum, String>() {
    {
        put(ErrorCdEnum.DATAS_LENGTH_ZERO, ERROR_MSG_DATAS_LENGTH_ZERO);
        put(ErrorCdEnum.FUNCTION_TYPE_NOT_SETTINGS, ERROR_MSG_FUNCTION_TYPE_NOT_SETTINGS);
        put(ErrorCdEnum.VECTOR_LENGTH_NOT_EQUALS, ERROR_MSG_VECTOR_LENGTH_NOT_EQUALS);
    }
  };

  public String errorCd;

  public StatisticsException() {
  }
  public StatisticsException(String errorCd) {
    this.errorCd = errorCd;
  }

  public String getErrorMessage() {
    return errorCdEnum.get(this.errorCd);
  }
  public String getErrorMessage(String errorCd) {
    return errorCdEnum.get(errorCd);
  }

}

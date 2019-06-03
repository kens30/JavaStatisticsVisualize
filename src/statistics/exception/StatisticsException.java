package statistics.exception;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class StatisticsException extends Exception {
  public static String ERROR_CD_DATAS_LENGTH_ZERO = "00001";
  private static String ERROR_MSG_DATAS_LENGTH_ZERO = "処理対象の配列要素が0です。";

  public enum ErrorCdEnum {
    DATAS_LENGTH_ZERO;
    private final static EnumMap<ErrorCdEnum, String> errorCdMap;
    static{
      errorCdMap = new EnumMap<ErrorCdEnum, String>(ErrorCdEnum.class);
      errorCdMap.put(ErrorCdEnum.DATAS_LENGTH_ZERO, ERROR_CD_DATAS_LENGTH_ZERO);
    }

    public static String getValue(ErrorCdEnum mapKey) {
      return errorCdMap.get(mapKey);
    }
  }

  Map<ErrorCdEnum, String> errorCdEnum = new HashMap<ErrorCdEnum, String>() {
    {
        put(ErrorCdEnum.DATAS_LENGTH_ZERO, ERROR_MSG_DATAS_LENGTH_ZERO);
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

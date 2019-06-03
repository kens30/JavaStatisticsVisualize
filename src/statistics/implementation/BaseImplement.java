package statistics.implementation;

import statistics.exception.StatisticsException;

public class BaseImplement {
  private StatisticsException exception;
  protected StatisticsException getException() {
    return exception;
  }

  protected void setException(StatisticsException exception) {
    this.exception = exception;
  }

  public BaseImplement() {
  }

  protected boolean validateLength(Object[] target) {
    if (target == null) {
      return false;
    }
    if (target.length <= 0) {
      return false;
    }
    return true;
  }
  protected boolean checkUnique(Object[] target) {
    if (target.length == 1) {
      return true;
    }
    return false;
  }
}

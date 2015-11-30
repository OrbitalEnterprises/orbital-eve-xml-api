package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IError;

public class ApiErrorListItem implements IError {
  private int    errorCode;
  private String errorText;

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorText() {
    return errorText;
  }

  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }
}

package enterprises.orbital.impl.evexmlapi;

import java.util.Date;

import enterprises.orbital.evexmlapi.IResponse;

public class ApiResponseProxy implements IResponse {
  protected final ApiResponse proxy;

  public ApiResponseProxy(ApiResponse result) {
    proxy = result;
  }

  @Override
  public Date getCachedUntil() {
    return proxy.getCachedUntil();
  }

  @Override
  public Date getCurrentTime() {
    return proxy.getCurrentTime();
  }

  @Override
  public int getEveAPIVersion() {
    return proxy.getVersion();
  }

  @Override
  public boolean isError() {
    return proxy.hasError();
  }

  @Override
  public int getErrorCode() {
    return isError() ? proxy.getError().getCode() : 0;
  }

  @Override
  public String getErrorString() {
    return isError() ? proxy.getError().getError() : null;
  }

  @Override
  public Date getErrorRetryAfterDate() {
    if (isError()) {
      ApiError err = proxy.getError();
      if (err.hasRetryAfterDate()) return err.getRetryAfterDate();
    }

    return null;
  }

  @Override
  public void reset() {
    // Should never be called on a proxy object.
    throw new UnsupportedOperationException();
  }

}

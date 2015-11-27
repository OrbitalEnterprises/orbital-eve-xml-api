package enterprises.orbital.impl.evexmlapi;

import java.util.Date;

import enterprises.orbital.evexmlapi.IResponse;

public abstract class AbstractAPIRequestAdapter implements IResponse {

  protected ApiResponse lastEveAPIResponse;
  protected ApiAuth     cachedAuth;

  protected void setAuth(ApiAuth auth) {
    cachedAuth = auth;
  }

  public final ApiAuth getAuth() {
    return cachedAuth;
  }

  @Override
  public Date getCachedUntil() {
    return lastEveAPIResponse != null ? lastEveAPIResponse.getCachedUntil() : null;
  }

  @Override
  public Date getCurrentTime() {
    return lastEveAPIResponse != null ? lastEveAPIResponse.getCurrentTime() : null;
  }

  @Override
  public int getEveAPIVersion() {
    return lastEveAPIResponse != null ? lastEveAPIResponse.getVersion() : 0;
  }

  @Override
  public boolean isError() {
    return lastEveAPIResponse != null && lastEveAPIResponse.hasError();
  }

  @Override
  public int getErrorCode() {
    return isError() ? lastEveAPIResponse.getError().getCode() : 0;
  }

  @Override
  public String getErrorString() {
    return isError() ? lastEveAPIResponse.getError().getError() : null;
  }

  @Override
  public Date getErrorRetryAfterDate() {
    if (isError()) {
      ApiError err = lastEveAPIResponse.getError();
      if (err.hasRetryAfterDate()) return err.getRetryAfterDate();
    }

    return null;
  }

  public <A extends ApiResponse> A setFromLastResponse(A r) {
    lastEveAPIResponse = r;
    return r;
  }

  @Override
  public void reset() {
    setFromLastResponse(null);
  }

}

package enterprises.orbital.impl.evexmlapi.act;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class APIKeyInfoResponse extends ApiResponse {
  private ApiAPIKeyInfo keyInfo = null;

  public void setApiKeyInfo(ApiAPIKeyInfo info) {
    keyInfo = info;
  }

  public ApiAPIKeyInfo getAPIKeyInfo() {
    return keyInfo;
  }

}
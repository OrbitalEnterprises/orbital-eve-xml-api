package enterprises.orbital.impl.evexmlapi.act;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.act.IAPIKeyInfo;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class APIKeyInfoParser extends AbstractApiParser<APIKeyInfoResponse, IAPIKeyInfo> {
  public APIKeyInfoParser() {
    super(APIKeyInfoResponse.class, ApiEndpoint.ACT_API_KEY_INFO_V1);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/key", ApiAPIKeyInfo.class);
    digester.addSetProperties("eveapi/result/key");
    digester.addSetNext("eveapi/result/key", "setApiKeyInfo");
    digester.addObjectCreate("eveapi/result/key/rowset/row", ApiCharacter.class);
    digester.addSetProperties("eveapi/result/key/rowset/row");
    digester.addSetNext("eveapi/result/key/rowset/row", "addCharacter");
    return digester;
  }

  @Override
  public IAPIKeyInfo retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    APIKeyInfoResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response.getAPIKeyInfo();
  }
}
package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IMemberTracking;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MemberTrackingParser extends AbstractApiParser<MemberTrackingResponse, Collection<IMemberTracking>> {
  protected boolean extended;

  public MemberTrackingParser(ApiConnector connector, boolean extended) {
    super(connector, MemberTrackingResponse.class, ApiEndpoint.CRP_MEMBER_TRACKING_V2);
    this.extended = extended;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiMember.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addMember");
    return digester;
  }

  @Override
  public Collection<IMemberTracking> retrieveResponse(
                                                      AbstractAPIRequestAdapter adapter)
    throws IOException {
    MemberTrackingResponse response;
    if (extended) {
      Map<String, String> extraParams = new HashMap<String, String>();
      extraParams.put("extended", "1");
      response = getResponse(adapter.getAuth(), extraParams);
    } else {
      response = getResponse(adapter.getAuth());
    }
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMemberTracking> result = new HashSet<IMemberTracking>();
    result.addAll(response.getMembers());
    return result;
  }

}
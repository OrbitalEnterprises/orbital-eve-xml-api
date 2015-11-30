package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IMemberMedal;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MemberMedalsParser extends AbstractApiParser<MemberMedalsResponse, Collection<IMemberMedal>> {
  public MemberMedalsParser(ApiConnector connector) {
    super(connector, MemberMedalsResponse.class, ApiEndpoint.CRP_MEMBER_MEDALS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", MemberMedal.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addMedal");
    return digester;
  }

  @Override
  public Collection<IMemberMedal> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MemberMedalsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMemberMedal> result = new ArrayList<IMemberMedal>();
    result.addAll(response.getMemberMedals());
    return result;
  }

}
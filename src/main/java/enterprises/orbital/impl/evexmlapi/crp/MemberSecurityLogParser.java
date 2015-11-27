package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.crp.IMemberSecurityLog;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MemberSecurityLogParser extends AbstractApiParser<MemberSecurityLogResponse, Collection<IMemberSecurityLog>> {
  public MemberSecurityLogParser() {
    super(MemberSecurityLogResponse.class, ApiEndpoint.CRP_MEMBER_SECURITY_LOG_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiRoleHistory.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addFactoryCreate("eveapi/result/rowset/row/rowset", new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        String name = attributes.getValue("name");
        if (name != null) {
          SecurityRoleBag roleBag = new SecurityRoleBag();
          roleBag.setName(name);
          return roleBag;
        }
        return null;
      }
    });
    digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiSecurityRole.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addSecurityRole");
    digester.addSetNext("eveapi/result/rowset/row/rowset", "addSecurityRoleBag");
    digester.addSetNext("eveapi/result/rowset/row", "addRoleHistory");
    return digester;
  }

  @Override
  public Collection<IMemberSecurityLog> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MemberSecurityLogResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMemberSecurityLog> result = new HashSet<IMemberSecurityLog>();
    result.addAll(response.getRoleHistories());
    return result;
  }

}
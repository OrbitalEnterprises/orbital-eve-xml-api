package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.crp.IMemberSecurity;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MemberSecurityParser extends AbstractApiParser<MemberSecurityResponse, Collection<IMemberSecurity>> {
  public MemberSecurityParser(ApiConnector connector) {
    super(connector, MemberSecurityResponse.class, ApiEndpoint.CRP_MEMBER_SECURITY_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiSecurityMember.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addFactoryCreate("eveapi/result/rowset/row/rowset", new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        String name = attributes.getValue("name");
        if (name != null) {
          SecurityRoleOrTitleBag roleBag = new SecurityRoleOrTitleBag();
          roleBag.setName(name);
          return roleBag;
        }
        return null;
      }
    });
    digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", SecurityRoleOrTitle.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addSecurityRole");
    digester.addSetNext("eveapi/result/rowset/row/rowset", "addSecurityRoleBag");
    digester.addSetNext("eveapi/result/rowset/row", "addMember");
    return digester;
  }

  @Override
  public Collection<IMemberSecurity> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MemberSecurityResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMemberSecurity> result = new HashSet<IMemberSecurity>();
    result.addAll(response.getMembers());
    return result;
  }

}

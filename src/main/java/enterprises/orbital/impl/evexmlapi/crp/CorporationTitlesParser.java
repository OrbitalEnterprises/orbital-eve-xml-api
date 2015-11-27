package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.crp.ITitle;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CorporationTitlesParser extends AbstractApiParser<CorporationTitlesResponse, Collection<ITitle>> {
  public CorporationTitlesParser() {
    super(CorporationTitlesResponse.class, ApiEndpoint.CRP_TITLES_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiTitle.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addFactoryCreate("eveapi/result/rowset/row/rowset", new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        String name = attributes.getValue("name");
        if (name != null) {
          RoleBag roleBag = new RoleBag();
          roleBag.setName(name);
          return roleBag;
        }
        return null;
      }
    });
    digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiRole.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addRole");
    digester.addSetNext("eveapi/result/rowset/row/rowset", "addRoleBag");
    digester.addSetNext("eveapi/result/rowset/row", "addTitle");
    return digester;
  }

  @Override
  public Collection<ITitle> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CorporationTitlesResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<ITitle> result = new ArrayList<ITitle>();
    result.addAll(response.getTitles());
    return result;
  }

}
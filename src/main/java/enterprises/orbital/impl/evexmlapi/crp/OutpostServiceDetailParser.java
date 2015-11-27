package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IOutpostServiceDetail;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class OutpostServiceDetailParser extends AbstractApiParser<OutpostServiceDetailResponse, Collection<IOutpostServiceDetail>> {
  protected Long itemID;

  public OutpostServiceDetailParser(Long itemID) {
    super(OutpostServiceDetailResponse.class, ApiEndpoint.CRP_OUTPOST_SERVICE_DETAIL_V2);
    this.itemID = itemID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiOutpostServiceDetail.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addOutpost");
    return digester;
  }

  public OutpostServiceDetailResponse getResponseWithItemID(ApiAuth auth) throws IOException {
    if (itemID != null)
      return getResponse(auth, "itemID", Long.toString(itemID));
    else
      return getResponse(auth);
  }

  @Override
  public Collection<IOutpostServiceDetail> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    OutpostServiceDetailResponse response = getResponseWithItemID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IOutpostServiceDetail> result = new HashSet<IOutpostServiceDetail>();
    result.addAll(response.getOutposts());
    return result;
  }
}
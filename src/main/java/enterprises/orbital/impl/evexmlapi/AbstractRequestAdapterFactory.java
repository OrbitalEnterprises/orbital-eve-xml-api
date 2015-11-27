package enterprises.orbital.impl.evexmlapi;

import java.io.IOException;

public interface AbstractRequestAdapterFactory<A, B extends AbstractAPIRequestAdapter> {

  public A handleAPIRequest(B adapter, Object args) throws IOException;
}

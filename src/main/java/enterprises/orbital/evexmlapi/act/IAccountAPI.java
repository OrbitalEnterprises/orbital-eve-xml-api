package enterprises.orbital.evexmlapi.act;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.IResponse;

public interface IAccountAPI extends IResponse {

  public IAccountStatus requestAccountStatus() throws IOException;

  public Collection<ICharacter> requestCharacters() throws IOException;

  public IAPIKeyInfo requestAPIKeyInfo() throws IOException;

}

package enterprises.orbital.impl.evexmlapi.act;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.act.IAPIKeyInfo;
import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.act.IAccountStatus;
import enterprises.orbital.evexmlapi.act.ICharacter;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiAuth;

public class AccountAPIAdapter extends AbstractAPIRequestAdapter implements IAccountAPI {

  public AccountAPIAdapter(int keyID, String vCode) {
    setAuth(new ApiAuth(keyID, 0, vCode));
  }

  @Override
  public IAccountStatus requestAccountStatus() throws IOException {
    return new AccountStatusParser().retrieveResponse(this);
  }

  @Override
  public Collection<ICharacter> requestCharacters() throws IOException {
    return new CharactersParser().retrieveResponse(this);
  }

  @Override
  public IAPIKeyInfo requestAPIKeyInfo() throws IOException {
    return new APIKeyInfoParser().retrieveResponse(this);
  }

}

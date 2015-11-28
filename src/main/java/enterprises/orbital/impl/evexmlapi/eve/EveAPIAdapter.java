package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IAlliance;
import enterprises.orbital.evexmlapi.eve.ICharacterInfo;
import enterprises.orbital.evexmlapi.eve.ICharacterLookup;
import enterprises.orbital.evexmlapi.eve.IConquerableStation;
import enterprises.orbital.evexmlapi.eve.IError;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IFacWarSummary;
import enterprises.orbital.evexmlapi.eve.IFacWarTopSummary;
import enterprises.orbital.evexmlapi.eve.IRefType;
import enterprises.orbital.evexmlapi.eve.ISkillGroup;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;

public class EveAPIAdapter extends AbstractAPIRequestAdapter implements IEveAPI {

  public EveAPIAdapter(ApiConnector connector) {
    super(connector);
  }

  @Override
  public Collection<IAlliance> requestAlliances() throws IOException {
    return new AllianceListParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<ICharacterLookup> requestCharacterID(String... names) throws IOException {
    return new CharacterLookupParser(connector, names).retrieveResponse(this);
  }

  @Override
  public ICharacterInfo requestCharacterInfo(long characterID) throws IOException {
    return new CharacterInfoParser(connector, characterID).retrieveResponse(this);
  }

  @Override
  public ICharacterInfo requestCharacterInfo(int keyID, String vCode, long characterID) throws IOException {
    setAuth(new ApiAuth(keyID, characterID, vCode));
    try {
      return new CharacterInfoParser(connector, null).retrieveResponse(this);
    } finally {
      setAuth(null);
    }
  }

  @Override
  public Collection<ICharacterLookup> requestCharacterName(long... ids) throws IOException {
    return new CharacterLookupParser(connector, ids).retrieveResponse(this);
  }

  @Override
  public Collection<IConquerableStation> requestConquerableStations() throws IOException {
    return new ConquerableStationListParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IError> requestErrors() throws IOException {
    return new ErrorListParser(connector).retrieveResponse(this);
  }

  @Override
  public IFacWarSummary requestFacWarStats() throws IOException {
    return new EveFacWarStatsParser(connector).retrieveResponse(this);
  }

  @Override
  public IFacWarTopSummary requestFacWarTopStats() throws IOException {
    return new FacWarTopStatsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IRefType> requestRefTypes() throws IOException {
    return new RefTypesParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<ISkillGroup> requestSkillTree() throws IOException {
    return new SkillTreeParser(connector).retrieveResponse(this);
  }

}

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

public class EveAPIAdapter extends AbstractAPIRequestAdapter implements IEveAPI {

  @Override
  public Collection<IAlliance> requestAlliances() throws IOException {
    return new AllianceListParser().retrieveResponse(this);
  }

  @Override
  public Collection<ICharacterLookup> requestCharacterID(String... names) throws IOException {
    return new CharacterLookupParser(names).retrieveResponse(this);
  }

  @Override
  public ICharacterInfo requestCharacterInfo(long characterID) throws IOException {
    return new CharacterInfoParser(characterID).retrieveResponse(this);
  }

  @Override
  public ICharacterInfo requestCharacterInfo(int keyID, String vCode, long characterID) throws IOException {
    setAuth(new ApiAuth(keyID, characterID, vCode));
    try {
      return new CharacterInfoParser(null).retrieveResponse(this);
    } finally {
      setAuth(null);
    }
  }

  @Override
  public Collection<ICharacterLookup> requestCharacterName(long... ids) throws IOException {
    return new CharacterLookupParser(ids).retrieveResponse(this);
  }

  @Override
  public Collection<IConquerableStation> requestConquerableStations() throws IOException {
    return new ConquerableStationListParser().retrieveResponse(this);
  }

  @Override
  public Collection<IError> requestErrors() throws IOException {
    return new ErrorListParser().retrieveResponse(this);
  }

  @Override
  public IFacWarSummary requestFacWarStats() throws IOException {
    return new EveFacWarStatsParser().retrieveResponse(this);
  }

  @Override
  public IFacWarTopSummary requestFacWarTopStats() throws IOException {
    return new FacWarTopStatsParser().retrieveResponse(this);
  }

  @Override
  public Collection<IRefType> requestRefTypes() throws IOException {
    return new RefTypesParser().retrieveResponse(this);
  }

  @Override
  public Collection<ISkillGroup> requestSkillTree() throws IOException {
    return new SkillTreeParser().retrieveResponse(this);
  }

}

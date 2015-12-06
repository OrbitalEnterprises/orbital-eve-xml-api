package enterprises.orbital.evexmlapi.eve;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.IResponse;

public interface IEveAPI extends IResponse {
  public Collection<IAlliance> requestAlliances() throws IOException;

  public Collection<ICharacterAffiliation> requestCharacterAffiliation(long... ids) throws IOException;

  public Collection<ICharacterLookup> requestCharacterID(String... names) throws IOException;

  /**
   * Request full character info for the listed character ID.
   * 
   * @param keyID
   *          the keyID for authentication.
   * @param vCode
   *          the vCode to use for authentication
   * @param characterID
   *          the character for which we're requesting info.
   * @return null on error, otherwise an instance of ICharacterInfo.
   * @throws IOException
   *           if an error occurs while making the request.
   */
  public ICharacterInfo requestCharacterInfo(int keyID, String vCode, long characterID) throws IOException;

  public ICharacterInfo requestCharacterInfo(long characterID) throws IOException;

  public Collection<ICharacterLookup> requestCharacterName(long... ids) throws IOException;

  public Collection<IConquerableStation> requestConquerableStations() throws IOException;

  public Collection<IError> requestErrors() throws IOException;

  public IFacWarSummary requestFacWarStats() throws IOException;

  public IFacWarTopSummary requestFacWarTopStats() throws IOException;

  public Collection<IRefType> requestRefTypes() throws IOException;

  public Collection<ISkillGroup> requestSkillTree() throws IOException;

  public Collection<ITypeName> requestTypeName(int... typeid) throws IOException;
}

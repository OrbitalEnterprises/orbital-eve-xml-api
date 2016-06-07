package enterprises.orbital.evexmlapi;

import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.api.IApiAPI;
import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.svr.IServerAPI;

/**
 * This interface encapsulates all supported requests to the EVE servers. Implementations of this interface may not implement all functions and are allowed to
 * throw an UnsupportedOperationException for those functions not supported.
 */
public interface IEveXmlApi {

  /**
   * Request a handle for making server API requests.
   * 
   * @return a handle for making API requests.
   */
  public IServerAPI getServerAPIService();

  /**
   * Request handle for making API section requests.
   * 
   * @return a handling for making API requests.
   */
  public IApiAPI getApiAPIService();

  /**
   * Request a handle for making account API requests.
   * 
   * @param keyID
   *          the key ID for authentication of requests.
   * @param vCode
   *          the vCode to use for authenticating requests.
   * @return a handle for making API requests.
   */
  public IAccountAPI getAccountAPIService(int keyID, String vCode);

  /**
   * Request a handle for making character API requests.
   * 
   * @param keyID
   *          the key ID for authentication of requests.
   * @param vCode
   *          the vCode to use for authenticating requests.
   * @param characterID
   *          the character ID for authentication of requests.
   * @return a handle for making API requests.
   */
  public ICharacterAPI getCharacterAPIService(int keyID, String vCode, long characterID);

  /**
   * Request a handle for making corporation API requests.
   * 
   * @param keyID
   *          the user ID for authentication of requests.
   * @param vCode
   *          the vCode to use for authenticating requests.
   * @param characterID
   *          the character ID for authentication of requests.
   * @return a handle for making API requests.
   */
  public ICorporationAPI getCorporationAPIService(int keyID, String vCode, long characterID);

  /**
   * Request a handle for making eve API requests. All but one of these requests do not require credentials. The one request which does require credentials
   * (CharacterInfo) accepts these credentials on the method call.
   * 
   * @return a handle for making API requests.
   */
  public IEveAPI getEveAPIService();

  /**
   * Request a handle for making map API requests.
   * 
   * @return a handle for making API requests.
   */
  public IMapAPI getMapAPIService();

}

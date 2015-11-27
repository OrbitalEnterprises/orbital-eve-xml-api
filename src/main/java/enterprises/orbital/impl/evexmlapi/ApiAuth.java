package enterprises.orbital.impl.evexmlapi;

import java.util.HashMap;
import java.util.Map;

public class ApiAuth implements Comparable<ApiAuth> {
  private final int    keyID;
  private final long   characterID;
  private final String vCode;

  public ApiAuth(int keyID, long characterID, String vCode) {
    this.keyID = keyID;
    this.characterID = characterID;
    this.vCode = vCode;
  }

  public Map<String, String> getParams() {
    Map<String, String> result = new HashMap<String, String>();
    result.put("keyID", Integer.toString(getKeyID()));
    result.put("characterID", Long.toString(getCharacterID()));
    result.put("vCode", getVCode());
    return result;
  }

  public int getKeyID() {
    return keyID;
  }

  public long getCharacterID() {
    return characterID;
  }

  public String getVCode() {
    return vCode;
  }

  @Override
  public int hashCode() {
    return new StringBuilder(keyID).append(characterID).append(vCode).toString().hashCode();
  }

  @Override
  public int compareTo(ApiAuth o) {
    return o.hashCode() - hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ApiAuth) return compareTo((ApiAuth) obj) == 0;
    return false;
  }

  @Override
  public String toString() {
    return "ApiAuth [keyID=" + keyID + ", characterID=" + characterID + ", vCode=" + vCode + "]";
  }

}

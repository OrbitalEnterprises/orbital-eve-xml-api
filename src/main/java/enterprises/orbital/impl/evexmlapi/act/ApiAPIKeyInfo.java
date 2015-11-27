package enterprises.orbital.impl.evexmlapi.act;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enterprises.orbital.evexmlapi.act.IAPIKeyInfo;
import enterprises.orbital.evexmlapi.act.ICharacter;

public class ApiAPIKeyInfo implements IAPIKeyInfo {
  private long                     accessMask;
  private String                   type;
  private Date                     expires;
  private final List<ApiCharacter> characters = new ArrayList<ApiCharacter>();

  @Override
  public long getAccessMask() {
    return accessMask;
  }

  public void setAccessMask(long accessMask) {
    this.accessMask = accessMask;
  }

  @Override
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public Date getExpires() {
    return expires;
  }

  public void setExpires(Date expires) {
    this.expires = expires;
  }

  public void addCharacter(ApiCharacter c) {
    characters.add(c);
  }

  @Override
  public List<ICharacter> getCharacters() {
    List<ICharacter> result = new ArrayList<ICharacter>();
    result.addAll(characters);
    return result;
  }
}
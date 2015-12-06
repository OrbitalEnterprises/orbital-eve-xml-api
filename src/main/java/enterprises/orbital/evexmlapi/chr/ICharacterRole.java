package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICharacterRole.class)
public interface ICharacterRole {

  public CharacterRoleCategory getRoleCategory();

  public long getRoleID();

  public String getRoleName();
}

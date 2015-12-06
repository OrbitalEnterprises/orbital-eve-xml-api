package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICharacterTitle.class)
public interface ICharacterTitle {

  public long getTitleID();

  public String getTitleName();
}

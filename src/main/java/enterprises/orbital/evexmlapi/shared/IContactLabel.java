package enterprises.orbital.evexmlapi.shared;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IContactLabel.class)
public interface IContactLabel {
  public long getLabelID();

  public String getName();
}

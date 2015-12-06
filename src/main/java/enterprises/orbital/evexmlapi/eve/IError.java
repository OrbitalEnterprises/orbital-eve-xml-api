package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IError.class)
public interface IError {
  int getErrorCode();

  String getErrorText();
}

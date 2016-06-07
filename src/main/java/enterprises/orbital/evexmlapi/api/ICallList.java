package enterprises.orbital.evexmlapi.api;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICallList.class)
public interface ICallList {

  public Collection<ICallGroup> getCallGroups();

  public Collection<ICall> getCalls();
}

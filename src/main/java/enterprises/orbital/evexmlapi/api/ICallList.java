package enterprises.orbital.evexmlapi.api;

import java.util.Collection;

public interface ICallList {

  public Collection<ICallGroup> getCallGroups();

  public Collection<ICall> getCalls();
}

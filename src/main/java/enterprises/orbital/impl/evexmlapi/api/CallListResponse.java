package enterprises.orbital.impl.evexmlapi.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import enterprises.orbital.evexmlapi.api.ICall;
import enterprises.orbital.evexmlapi.api.ICallGroup;
import enterprises.orbital.evexmlapi.api.ICallList;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CallListResponse extends ApiResponse implements ICallList {
  private List<ICallGroup> callGroups = new ArrayList<ICallGroup>();
  private List<ICall>      calls      = new ArrayList<ICall>();

  @Override
  public Collection<ICallGroup> getCallGroups() {
    return callGroups;
  }

  @Override
  public Collection<ICall> getCalls() {
    return calls;
  }

  public void addCallOrGroup(ApiCallOrGroup obj) {
    if (obj.getAccessMask() > 0)
      calls.add(obj.asCall());
    else
      callGroups.add(obj.asCallGroup());
  }
}

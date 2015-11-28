package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ContainerLogResponse extends ApiResponse {
  private final List<ApiContainerLog> containerLogs = new ArrayList<ApiContainerLog>();

  public void addContainerLog(ApiContainerLog containerLog) {
    containerLogs.add(containerLog);
  }

  public List<ApiContainerLog> getContainerLogs() {
    return containerLogs;
  }
}
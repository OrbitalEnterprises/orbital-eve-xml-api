package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ErrorListResponse extends ApiResponse {
  private static final long                  serialVersionUID  = 1728468871449111471L;
  private final Collection<ApiErrorListItem> apiErrorListItems = new ArrayList<ApiErrorListItem>();

  public void addApiErrorListItem(ApiErrorListItem errorListItem) {
    apiErrorListItems.add(errorListItem);
  }

  public Collection<ApiErrorListItem> getApiErrorListItems() {
    return apiErrorListItems;
  }
}
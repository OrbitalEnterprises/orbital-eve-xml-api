package enterprises.orbital.impl.evexmlapi.chr;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MailingListsResponse extends ApiResponse {
  private final Set<ApiMailingList> mailingLists = new HashSet<ApiMailingList>();

  public void addMailingList(ApiMailingList mailingList) {
    mailingLists.add(mailingList);
  }

  public Set<ApiMailingList> getMailingLists() {
    return mailingLists;
  }
}
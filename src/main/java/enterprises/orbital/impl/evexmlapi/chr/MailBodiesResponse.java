package enterprises.orbital.impl.evexmlapi.chr;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MailBodiesResponse extends ApiResponse {
  Set<ApiMailBody> mailBodies = new HashSet<ApiMailBody>();

  public void add(ApiMailBody member) {
    mailBodies.add(member);
  }

  public Set<ApiMailBody> getMailBodies() {
    return mailBodies;
  }
}
package enterprises.orbital.impl.evexmlapi.chr;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MailBodiesResponse extends ApiResponse {
  private static final long serialVersionUID = -4513697717628590080L;
  Set<ApiMailBody>          mailBodies       = new HashSet<ApiMailBody>();

  public void add(ApiMailBody member) {
    mailBodies.add(member);
  }

  public Set<ApiMailBody> getMailBodies() {
    return mailBodies;
  }
}
package enterprises.orbital.impl.evexmlapi.chr;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MailMessagesResponse extends ApiResponse {
  private static final long serialVersionUID = -8150569807965385413L;
  Set<ApiMailMessage>       mails            = new HashSet<ApiMailMessage>();

  public void addApiMail(ApiMailMessage member) {
    mails.add(member);
  }

  public Set<ApiMailMessage> getApiMails() {
    return mails;
  }
}
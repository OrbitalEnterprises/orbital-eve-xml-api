package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractContactListParser;

public class ContactListParser extends AbstractContactListParser {
  public ContactListParser() {
    super(ApiEndpoint.CHR_CONTACT_LIST_V2);
  }

}
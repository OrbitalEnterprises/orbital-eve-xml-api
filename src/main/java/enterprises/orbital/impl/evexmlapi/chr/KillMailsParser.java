package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractKillMailsParser;

public class KillMailsParser extends AbstractKillMailsParser {
  public KillMailsParser(ApiConnector connector, Long beforeKillID) {
    super(connector, ApiEndpoint.CHR_KILL_MAILS_V2, beforeKillID);
  }

}

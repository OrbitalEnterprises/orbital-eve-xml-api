package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractBlueprintsParser;

public class BlueprintsParser extends AbstractBlueprintsParser {
  public BlueprintsParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CHR_BLUEPRINTS_V2);
  }
}
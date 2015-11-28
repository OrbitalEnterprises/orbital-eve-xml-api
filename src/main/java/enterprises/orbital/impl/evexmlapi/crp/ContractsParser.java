package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractContractsParser;

public class ContractsParser extends AbstractContractsParser {
  public ContractsParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CRP_CONTRACTS_V1);
  }
}
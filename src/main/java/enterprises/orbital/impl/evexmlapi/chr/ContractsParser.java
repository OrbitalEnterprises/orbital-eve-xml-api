package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractContractsParser;

public class ContractsParser extends AbstractContractsParser {
  public ContractsParser() {
    super(ApiEndpoint.CHR_CONTRACTS_V1);
  }
}
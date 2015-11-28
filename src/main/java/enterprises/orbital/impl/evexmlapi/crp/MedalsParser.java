package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.ICorporationMedal;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractMedalsParser;

public class MedalsParser extends AbstractMedalsParser<CorporationMedal, ICorporationMedal> {
  public MedalsParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CRP_MEDALS_V2, CorporationMedal.class);
  }
}
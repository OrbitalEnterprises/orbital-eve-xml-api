package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.ICharacterMedal;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractMedalsParser;

public class MedalsParser extends AbstractMedalsParser<CharacterMedal, ICharacterMedal> {
  public MedalsParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CHR_MEDALS_V2, CharacterMedal.class);
  }
}
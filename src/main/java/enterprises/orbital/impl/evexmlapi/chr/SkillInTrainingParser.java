package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.ISkillInTraining;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class SkillInTrainingParser extends AbstractApiParser<SkillInTrainingResponse, ISkillInTraining> {
  public SkillInTrainingParser(ApiConnector connector) {
    super(connector, SkillInTrainingResponse.class, ApiEndpoint.CHR_SKILL_IN_TRAINING_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/currentTQTime");
    digester.addBeanPropertySetter("eveapi/result/trainingEndTime");
    digester.addBeanPropertySetter("eveapi/result/trainingStartTime");
    digester.addBeanPropertySetter("eveapi/result/trainingTypeID");
    digester.addBeanPropertySetter("eveapi/result/trainingStartSP");
    digester.addBeanPropertySetter("eveapi/result/trainingDestinationSP");
    digester.addBeanPropertySetter("eveapi/result/trainingToLevel");
    digester.addBeanPropertySetter("eveapi/result/skillInTraining");
    return digester;
  }

  @Override
  public ISkillInTraining retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    SkillInTrainingResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}
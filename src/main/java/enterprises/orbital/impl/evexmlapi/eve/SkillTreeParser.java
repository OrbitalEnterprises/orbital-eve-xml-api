package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.BeanPropertySetterRule;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.eve.ISkillGroup;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class SkillTreeParser extends AbstractApiParser<SkillTreeResponse, Collection<ISkillGroup>> {
  public SkillTreeParser() {
    super(SkillTreeResponse.class, ApiEndpoint.EVE_SKILL_TREE_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiSkillGroup.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addSkillGroup");
    digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiSkill.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
    // digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/description");
    digester.addRule("eveapi/result/rowset/row/rowset/row/description", new MyBeanPropertySetterRule("description"));
    digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/rank");
    digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/requiredAttributes/primaryAttribute");
    digester.addBeanPropertySetter("eveapi/result/rowset/row/rowset/row/requiredAttributes/secondaryAttribute");
    digester.addFactoryCreate("eveapi/result/rowset/row/rowset/row/rowset/row", new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        if (attributes.getValue("typeID") != null) return new ApiRequirement();
        if (attributes.getValue("bonusType") != null) return new ApiBonus();
        return null;
      }
    });
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row/rowset/row", "addSkillDetail");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addSkill");
    return digester;
  }

  // Inner class to handle setting description. We have to do this because
  // the usual BeanPropertySetter rule has this annoying feature that it trims
  // text when it sets a text property.
  private class MyBeanPropertySetterRule extends BeanPropertySetterRule {

    public MyBeanPropertySetterRule(String propertyName) {
      super(propertyName);
    }

    @Override
    public void body(String namespace, String name, String text) throws Exception {

      bodyText = text;
    }
  }

  @Override
  public Collection<ISkillGroup> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    SkillTreeResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response.getSkillGroups();
  }

}

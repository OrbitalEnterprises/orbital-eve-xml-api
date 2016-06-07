package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IImplant;
import enterprises.orbital.evexmlapi.chr.IJumpClone;
import enterprises.orbital.evexmlapi.chr.IJumpCloneImplant;
import enterprises.orbital.evexmlapi.chr.IPartialCharacterSheet;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharPartialCharacterSheetConverter extends ResponseConverter {

  public static String convert(
                               ICharacterAPI request,
                               IPartialCharacterSheet response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder.append("<DoB>").append(toEveDateFormat(response.getDoB())).append("</DoB>\n");
    builder.append("<race>").append(response.getRace()).append("</race>\n");
    builder.append("<bloodLineID>").append(response.getBloodlineID()).append("</bloodLineID>\n");
    builder.append("<bloodLine>").append(response.getBloodline()).append("</bloodLine>\n");
    builder.append("<ancestryID>").append(response.getAncestryID()).append("</ancestryID>\n");
    builder.append("<ancestry>").append(response.getAncestry()).append("</ancestry>\n");
    builder.append("<gender>").append(response.getGender()).append("</gender>\n");
    builder.append("<freeRespecs>").append(response.getFreeRespecs()).append("</freeRespecs>\n");
    builder.append("<cloneJumpDate>").append(toEveDateFormat(response.getCloneJumpDate())).append("</cloneJumpDate>\n");
    builder.append("<lastRespecDate>").append(toEveDateFormat(response.getLastRespecDate())).append("</lastRespecDate>\n");
    builder.append("<lastTimedRespec>").append(toEveDateFormat(response.getLastTimedRespec())).append("</lastTimedRespec>\n");
    builder.append("<remoteStationDate>").append(toEveDateFormat(response.getRemoteStationDate())).append("</remoteStationDate>\n");

    builder.append("<attributes>\n");
    builder.append("<intelligence>").append(response.getIntelligence()).append("</intelligence>\n");
    builder.append("<memory>").append(response.getMemory()).append("</memory>\n");
    builder.append("<charisma>").append(response.getCharisma()).append("</charisma>\n");
    builder.append("<perception>").append(response.getPerception()).append("</perception>\n");
    builder.append("<willpower>").append(response.getWillpower()).append("</willpower>\n");
    builder.append("</attributes>\n");

    builder.append("<rowset name=\"implants\" key=\"typeID\" columns=\"typeID,typeName\"");
    if (response.getImplants().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (IImplant nextImplant : response.getImplants()) {
        builder.append("<row typeID=\"").append(nextImplant.getTypeID());
        builder.append("\" typeName=\"").append(nextImplant.getTypeName()).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<rowset name=\"jumpClones\" key=\"jumpCloneID\" columns=\"jumpCloneID,typeID,locationID,cloneName\"");
    if (response.getJumpClones().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (IJumpClone nextClone : response.getJumpClones()) {
        builder.append("<row jumpCloneID=\"").append(nextClone.getJumpCloneID());
        builder.append("\" typeID=\"").append(nextClone.getTypeID());
        builder.append("\" locationID=\"").append(nextClone.getLocationID());
        builder.append("\" cloneName=\"").append(nextClone.getCloneName()).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<rowset name=\"jumpCloneImplants\" key=\"jumpCloneID\" columns=\"jumpCloneID,typeID,typeName\"");
    if (response.getJumpCloneImplants().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (IJumpCloneImplant nextImplant : response.getJumpCloneImplants()) {
        builder.append("<row jumpCloneID=\"").append(nextImplant.getJumpCloneID());
        builder.append("\" typeID=\"").append(nextImplant.getTypeID());
        builder.append("\" typeName=\"").append(nextImplant.getTypeName()).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<jumpActivation>").append(toEveDateFormat(response.getJumpActivation())).append("</jumpActivation>\n");
    builder.append("<jumpFatigue>").append(toEveDateFormat(response.getJumpFatigue())).append("</jumpFatigue>\n");
    builder.append("<jumpLastUpdate>").append(toEveDateFormat(response.getJumpLastUpdate())).append("</jumpLastUpdate>\n");

    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}

package enterprises.orbital.impl.evexmlapi.unittest.test.act;

import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.act.IAccountStatus;
import enterprises.orbital.evexmlapi.act.IMultiCharacterTraining;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class AcctAccountStatusConverter extends ResponseConverter {

  public static String convert(IAccountAPI request, IAccountStatus response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);

    builder.append("<result>\n");
    builder.append("<paidUntil>").append(toEveDateFormat(response.getPaidUntil()));
    builder.append("</paidUntil>\n");
    builder.append("<createDate>").append(toEveDateFormat(response.getCreateDate()));
    builder.append("</createDate>\n");
    builder.append("<logonCount>").append(response.getLogonCount()).append("</logonCount>\n");
    builder.append("<logonMinutes>").append(response.getLogonMinutes()).append("</logonMinutes>\n");
    builder.append("<rowset name=\"multiCharacterTraining\" key=\"trainingEnd\" columns=\"trainingEnd\"");
    if (response.getMultiCharacterTraining().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (IMultiCharacterTraining training : response.getMultiCharacterTraining()) {
        builder.append("<row trainingEnd=\"").append(toEveDateFormat(training.getTrainingEnd())).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }
    builder.append("</result>\n");

    convertCloser(request, builder);

    return builder.toString();
  }
}

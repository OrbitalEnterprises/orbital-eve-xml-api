package enterprises.orbital.impl.evexmlapi.unittest.test.api;

import enterprises.orbital.evexmlapi.api.IApiAPI;
import enterprises.orbital.evexmlapi.api.ICall;
import enterprises.orbital.evexmlapi.api.ICallGroup;
import enterprises.orbital.evexmlapi.api.ICallList;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CallListConverter extends ResponseConverter {

  public static String convert(IApiAPI request, ICallList response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder.append("<rowset name=\"callGroups\" key=\"groupID\" columns=\"groupID,name,description\">\n");
    for (ICallGroup i : response.getCallGroups()) {
      builder.append("<row groupID=\"");
      builder.append(i.getGroupID());
      builder.append("\" name=\"");
      builder.append(i.getName());
      builder.append("\" description=\"");
      builder.append(i.getDescription());
      builder.append("\" />\n");
    }
    builder.append("</rowset>\n");
    builder.append("<rowset name=\"calls\" key=\"accessMask,type\" columns=\"accessMask,type,name,groupID,description\">\n");
    for (ICall i : response.getCalls()) {
      builder.append("<row accessMask=\"");
      builder.append(i.getAccessMask());
      builder.append("\" type=\"");
      builder.append(i.getType());
      builder.append("\" name=\"");
      builder.append(i.getName());
      builder.append("\" groupID=\"");
      builder.append(i.getGroupID());
      builder.append("\" description=\"");
      builder.append(i.getDescription());
      builder.append("\" />\n");
    }
    builder.append("</rowset>\n");
    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}

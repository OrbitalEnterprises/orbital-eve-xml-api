package enterprises.orbital.impl.evexmlapi.unittest.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import enterprises.orbital.evexmlapi.IResponse;

public class ResponseConverter {

  protected static SimpleDateFormat dateFormatter;

  static {
    dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    dateFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
  }

  public static String toEveDateFormat(Date time) {
    return dateFormatter.format(time);
  }

  public static String convert(IResponse obj) {
    StringBuilder temp = new StringBuilder();
    convertOpener(obj, temp);
    convertCloser(obj, temp);

    return temp.toString();
  }

  public static void convertOpener(IResponse obj, StringBuilder progress) {
    progress.append("<?xml version='1.0' encoding='UTF-8'?>\n");
    progress.append("<eveapi version=\"").append(obj.getEveAPIVersion()).append("\">\n");
    progress.append("<currentTime>");
    progress.append(toEveDateFormat(obj.getCurrentTime()));
    progress.append("</currentTime>\n");
  }

  public static void convertCloser(IResponse obj, StringBuilder progress) {
    progress.append("<cachedUntil>");
    progress.append(toEveDateFormat(obj.getCachedUntil()));
    progress.append("</cachedUntil>\n");
    progress.append("</eveapi>");
  }

}

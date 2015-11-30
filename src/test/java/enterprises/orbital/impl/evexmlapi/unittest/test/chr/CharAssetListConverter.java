package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IAsset;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharAssetListConverter extends ResponseConverter {

  public static String convert(ICharacterAPI req, Collection<IAsset> assets) {
    StringBuilder builder = new StringBuilder();

    convertOpener(req, builder);
    builder.append("<result");
    if (assets.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      builder.append("<rowset name=\"assets\" key=\"itemID\" columns=\"itemID,locationID,typeID,quantity,flag,singleton\" >\n");
      for (IAsset next : assets)
        assetDescentWriter(next, builder);
      builder.append("</rowset>\n");
      builder.append("</result>\n");
    }

    convertCloser(req, builder);
    return builder.toString();
  }

  protected static void assetDescentWriter(IAsset parent, StringBuilder builder) {
    builder.append("<row itemID=\"").append(parent.getItemID());
    if (parent.getLocationID() != 0) builder.append("\" locationID=\"").append(parent.getLocationID());
    builder.append("\" typeID=\"").append(parent.getTypeID());
    builder.append("\" quantity=\"").append(parent.getQuantity());
    builder.append("\" flag=\"").append(parent.getFlag());
    builder.append("\" singleton=\"").append(parent.isSingleton() ? 1 : 0);

    if (parent.isSingleton())
      // Singletons will have a rawQuantity field as well
      builder.append("\" rawQuantity=\"").append(parent.getRawQuantity());

    builder.append("\"");

    Collection<IAsset> contained = parent.getContainedAssets();
    if (contained.size() == 0) {
      builder.append(" />\n");
      return;
    }

    builder.append(">\n");
    builder.append("<rowset name=\"contents\" key=\"itemID\" columns=\"itemID,typeID,quantity,flag,singleton\">\n");
    for (IAsset next : contained)
      assetDescentWriter(next, builder);
    builder.append("</rowset>\n");
    builder.append("</row>\n");
  }
}

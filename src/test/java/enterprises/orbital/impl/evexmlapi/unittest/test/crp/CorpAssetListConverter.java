package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IAsset;
import enterprises.orbital.impl.evexmlapi.unittest.test.chr.CharAssetListConverter;

public class CorpAssetListConverter extends CharAssetListConverter {

  public static String convert(ICorporationAPI req, Collection<IAsset> assets) {
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

}

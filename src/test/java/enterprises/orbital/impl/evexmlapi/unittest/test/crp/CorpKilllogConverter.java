package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IKill;
import enterprises.orbital.evexmlapi.shared.IKillAttacker;
import enterprises.orbital.evexmlapi.shared.IKillItem;
import enterprises.orbital.evexmlapi.shared.IKillVictim;
import enterprises.orbital.evexmlapi.shared.IStanding;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpKilllogConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<IKill> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      builder.append("<rowset name=\"kills\" key=\"killID\" columns=\"killID,solarSystemID,killTime,moonID\">\n");

      for (IKill next : response) {
        // Main kill info
        builder.append("<row killID=\"").append(next.getKillID());
        builder.append("\" solarSystemID=\"").append(next.getSolarSystemID());
        builder.append("\" killTime=\"").append(toEveDateFormat(next.getKillTime()));
        builder.append("\" moonID=\"").append(next.getMoonID());
        builder.append("\" >\n");

        // Victim info
        IKillVictim victim = next.getVictim();
        builder.append("<victim characterID=\"").append(victim.getCharacterID());
        builder.append("\" characterName=\"").append(victim.getCharacterName());
        builder.append("\" corporationID=\"").append(victim.getCorporationID());
        builder.append("\" corporationName=\"").append(victim.getCorporationName());
        builder.append("\" allianceID=\"").append(victim.getAllianceID());
        builder.append("\" allianceName=\"").append(victim.getAllianceName());
        if (victim.getFactionName() != null) {
          builder.append("\" factionID=\"").append(victim.getFactionID());
          builder.append("\" factionName=\"").append(victim.getFactionName());
        }
        builder.append("\" damageTaken=\"").append(victim.getDamageTaken());
        builder.append("\" shipTypeID=\"").append(victim.getShipTypeID());
        builder.append("\" />\n");

        // Attackers
        builder
            .append("<rowset name=\"attackers\" columns=\"characterID,characterName,corporationID,corporationName,allianceID,allianceName,factionID,factionName,securityStatus,damageDone,finalBlow,weaponTypeID,shipTypeID\"");
        Collection<IKillAttacker> attackers = next.getAttackers();
        if (attackers.size() == 0)
          builder.append("/>\n");
        else {
          builder.append(">\n");

          for (IKillAttacker nextA : attackers) {
            builder.append("<row characterID=\"").append(nextA.getCharacterID());
            builder.append("\" characterName=\"").append(nextA.getCharacterName());
            builder.append("\" corporationID=\"").append(nextA.getCorporationID());
            builder.append("\" corporationName=\"").append(nextA.getCorporationName());
            builder.append("\" allianceID=\"").append(nextA.getAllianceID());
            builder.append("\" allianceName=\"").append(nextA.getAllianceName());
            if (nextA.getFactionName() != null) {
              builder.append("\" factionID=\"").append(nextA.getFactionID());
              builder.append("\" factionName=\"").append(nextA.getFactionName());
            }
            builder.append("\" securityStatus=\"");
            if (nextA.getSecurityStatus() == (int) nextA.getSecurityStatus())
              builder.append((int) nextA.getSecurityStatus());
            else
              builder.append(nextA.getSecurityStatus());
            builder.append("\" damageDone=\"").append(nextA.getDamageDone());
            builder.append("\" finalBlow=\"").append(nextA.isFinalBlow() ? 1 : 0);
            builder.append("\" weaponTypeID=\"").append(nextA.getWeaponTypeID());
            builder.append("\" shipTypeID=\"").append(nextA.getShipTypeID());
            builder.append("\" />\n");
          }

          builder.append("</rowset>\n");
        }

        // Items
        builder.append("<rowset name=\"items\" columns=\"typeID,flag,qtyDropped,qtyDestroyed,singleton\"");
        Collection<IKillItem> items = next.getItems();
        if (items.size() == 0)
          builder.append("/>\n");
        else {
          builder.append(">\n");
          for (IKillItem nextI : items)
            itemDescentWriter(nextI, builder);
          builder.append("</rowset>\n");
        }

        // Done
        builder.append("</row>\n");
      }

      builder.append("</rowset>\n");
      builder.append("</result>\n");
    }

    convertCloser(request, builder);
    return builder.toString();
  }

  protected static void itemDescentWriter(IKillItem parent, StringBuilder builder) {
    builder.append("<row typeID=\"").append(parent.getTypeID());
    builder.append("\" flag=\"").append(parent.getFlag());
    builder.append("\" qtyDropped=\"").append(parent.getQtyDropped());
    builder.append("\" qtyDestroyed=\"").append(parent.getQtyDestroyed());
    builder.append("\" singleton=\"").append(parent.isSingleton() ? "1" : "0");
    builder.append("\"");

    Collection<IKillItem> contained = parent.getContainedItems();
    if (contained.size() == 0) {
      builder.append(" />\n");
      return;
    }

    builder.append(">\n");
    builder.append("<rowset name=\"items\" columns=\"typeID,flag,qtyDropped,qtyDestroyed,singleton\">\n");
    for (IKillItem next : contained)
      itemDescentWriter(next, builder);
    builder.append("</rowset>\n");
    builder.append("</row>\n");
  }

  protected static void dumpStanding(IStanding standing, StringBuilder builder) {
    builder.append("<row fromID=\"").append(standing.getFromID());
    builder.append("\" fromName=\"").append(standing.getFromName());
    builder.append("\" standing=\"").append(String.format("%1.2f", standing.getStanding()));
    builder.append("\" />\n");
  }
}

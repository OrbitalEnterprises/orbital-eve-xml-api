package enterprises.orbital.impl.evexmlapi.unittest.test;

import java.util.HashSet;
import java.util.Set;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceConstants;
import org.custommonkey.xmlunit.DifferenceListener;
import org.w3c.dom.Node;

// Hack to avoid text differences from certain node types
// which will not have text contents (e.g. <eveapi> tag)
public class EveApiDifferenceIgnorer implements DifferenceListener {

  protected static final Set<String> ignoreSet = new HashSet<String>();

  static {
    ignoreSet.add("eveapi");
    ignoreSet.add("result");
    ignoreSet.add("rowset");
    ignoreSet.add("row");
    ignoreSet.add("characterNPCStandings");
    ignoreSet.add("corporationNPCStandings");
    ignoreSet.add("attributeEnhancers");
    ignoreSet.add("memoryBonus");
    ignoreSet.add("intelligenceBonus");
    ignoreSet.add("charismaBonus");
    ignoreSet.add("perceptionBonus");
    ignoreSet.add("willpowerBonus");
    ignoreSet.add("attributes");
    ignoreSet.add("logo");
    ignoreSet.add("generalSettings");
    ignoreSet.add("combatSettings");
    ignoreSet.add("totals");
    ignoreSet.add("characters");
    ignoreSet.add("corporations");
    ignoreSet.add("factions");
    ignoreSet.add("requiredAttributes");
    ignoreSet.add("key");
  }

  protected boolean isIgnoredDifference(Difference difference) {
    Node control = difference.getControlNodeDetail().getNode();

    if (control.getNodeType() == Node.TEXT_NODE) {
      control = control.getParentNode();
      String nodeName = control.getNodeName();
      return ignoreSet.contains(nodeName) && difference.getId() == DifferenceConstants.TEXT_VALUE.getId();
    }

    return false;
  }

  /**
   * @return RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR to ignore differences in values of TEXT or ATTRIBUTE nodes, and RETURN_ACCEPT_DIFFERENCE to accept all other
   *         differences.
   * @see DifferenceListener#differenceFound(Difference)
   */
  @Override
  public int differenceFound(Difference difference) {
    if (isIgnoredDifference(difference)) {
      return RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR;
    } else {
      return RETURN_ACCEPT_DIFFERENCE;
    }
  }

  /**
   * Do nothing
   * 
   * @see DifferenceListener#skippedComparison(Node, Node)
   */
  @Override
  public void skippedComparison(Node control, Node test) {}

}

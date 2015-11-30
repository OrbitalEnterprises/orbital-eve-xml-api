package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IChatChannel;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class ChatChannelsParser extends AbstractApiParser<ChatChannelsResponse, Collection<IChatChannel>> {
  public ChatChannelsParser(ApiConnector connector) {
    super(connector, ChatChannelsResponse.class, ApiEndpoint.CHR_CHAT_CHANNELS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiChatChannel.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addObjectCreate("eveapi/result/rowset/row/rowset", MemberCollector.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset");
    digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiChatChannelMember.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addMember");
    digester.addSetNext("eveapi/result/rowset/row/rowset", "addMemberCollector");
    digester.addSetNext("eveapi/result/rowset/row", "addChannel");
    return digester;
  }

  public static class MemberCollector {
    private String                           name;
    private final List<ApiChatChannelMember> members = new ArrayList<ApiChatChannelMember>();

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public List<ApiChatChannelMember> getMembers() {
      return members;
    }

    public void addMember(ApiChatChannelMember mem) {
      members.add(mem);
    }

  }

  @Override
  public Collection<IChatChannel> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ChatChannelsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IChatChannel> result = new ArrayList<IChatChannel>();
    result.addAll(response.getChatChannels());
    return result;
  }
}

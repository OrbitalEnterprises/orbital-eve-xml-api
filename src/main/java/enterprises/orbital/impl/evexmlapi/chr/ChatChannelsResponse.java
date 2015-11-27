package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ChatChannelsResponse extends ApiResponse {
  private static final long          serialVersionUID = -6236652740529328822L;
  private final List<ApiChatChannel> channels         = new ArrayList<ApiChatChannel>();

  public List<ApiChatChannel> getChatChannels() {
    return channels;
  }

  public void addChannel(ApiChatChannel channel) {
    channels.add(channel);
  }
}
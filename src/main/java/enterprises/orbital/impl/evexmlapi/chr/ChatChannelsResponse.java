package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ChatChannelsResponse extends ApiResponse {
  private final List<ApiChatChannel> channels = new ArrayList<ApiChatChannel>();

  public List<ApiChatChannel> getChatChannels() {
    return channels;
  }

  public void addChannel(ApiChatChannel channel) {
    channels.add(channel);
  }
}
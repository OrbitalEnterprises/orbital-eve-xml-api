package enterprises.orbital.evexmlapi;

import java.util.Date;

/**
 * Parent interface for all EVE server request handles. The fields below are populated on completion of an API request. This means that a given handle can't be
 * used for concurrent requests. If you need to do that, request separate handles.
 * 
 * A note about error processing:
 * 
 * Almost all API methods declare "throws IOException". An IOException is thrown if the API request failed to return any usable value. This can mean that the
 * request was never sent (for a variety of reasons), or that the request was sent but could not be parsed properly.
 * 
 * If IOException is NOT thrown, then the request was successfully sent and the response was successfully parsed, but the response may be an error. Callers
 * should check handle.isError before attempting to process the data value returned by a call. In many cases, the data value will be null if the result was an
 * error response.
 */
public interface IResponse {
  public int getEveAPIVersion();

  public Date getCurrentTime();

  public Date getCachedUntil();

  public boolean isError();

  public int getErrorCode();

  public String getErrorString();

  public Date getErrorRetryAfterDate();

  /**
   * Clear the current error code and error string.
   */
  public void reset();
}

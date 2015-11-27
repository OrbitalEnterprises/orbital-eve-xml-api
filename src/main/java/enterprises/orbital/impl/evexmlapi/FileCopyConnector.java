package enterprises.orbital.impl.evexmlapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.digester.Digester;

import enterprises.orbital.impl.evexmlapi.utils.InputStreamSplitter;

public class FileCopyConnector extends ApiConnector {
  private final Logger       logger = Logger.getLogger(FileCopyConnector.class.getName());
  private final ApiConnector baseConnector;
  private final File         destinationDirectory;

  public FileCopyConnector(File destinationDirectory) {
    this(null, destinationDirectory);
  }

  public FileCopyConnector(ApiConnector baseConnector, File destinationDirectory) {
    this.baseConnector = baseConnector;
    this.destinationDirectory = destinationDirectory;
    if (!this.destinationDirectory.exists()) this.destinationDirectory.mkdirs();
  }

  @Override
  public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws IOException {
    ApiConnector connector = getConnector();
    URI uri = connector.getURI(request);
    Map<String, String> params = connector.getParams(request);
    InputStream inputStream = connector.getInputStream(uri, params);
    String outputFileName = request.getEndpoint().getFileName() + "-" + new Date().getTime() + ".xml";
    File outputFile = new File(destinationDirectory, outputFileName);
    FileOutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream(outputFile);
      inputStream = new InputStreamSplitter(inputStream, outputStream);
    } catch (FileNotFoundException e) {
      logger.log(Level.SEVERE, "Could not write response xml to file: ", e);
    }
    E response = getApiResponse(digester, inputStream, clazz);
    if (outputStream != null) {
      try {
        outputStream.flush();
        outputStream.close();
      } catch (IOException e) {
        logger.log(Level.SEVERE, "Could not flush/close response xml file: ", e);
      }
    }
    return response;
  }

  @Override
  protected ApiConnector getConnector() {
    if (baseConnector != null) return baseConnector;
    return super.getConnector();
  }
}
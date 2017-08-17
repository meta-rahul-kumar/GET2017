package DefaultNamespace;

public class SOAPServerProxy implements DefaultNamespace.SOAPServer {
  private String _endpoint = null;
  private DefaultNamespace.SOAPServer sOAPServer = null;
  
  public SOAPServerProxy() {
    _initSOAPServerProxy();
  }
  
  public SOAPServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAPServerProxy();
  }
  
  private void _initSOAPServerProxy() {
    try {
      sOAPServer = (new DefaultNamespace.SOAPServerServiceLocator()).getSOAPServer();
      if (sOAPServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAPServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAPServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAPServer != null)
      ((javax.xml.rpc.Stub)sOAPServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.SOAPServer getSOAPServer() {
    if (sOAPServer == null)
      _initSOAPServerProxy();
    return sOAPServer;
  }
  
  public double convertFahrenheitToCelsius(double temperature) throws java.rmi.RemoteException{
    if (sOAPServer == null)
      _initSOAPServerProxy();
    return sOAPServer.convertFahrenheitToCelsius(temperature);
  }
  
  
}
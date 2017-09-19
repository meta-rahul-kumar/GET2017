package DefaultNamespace;

public class TempProxy implements DefaultNamespace.Temp {
  private String _endpoint = null;
  private DefaultNamespace.Temp temp = null;
  
  public TempProxy() {
    _initTempProxy();
  }
  
  public TempProxy(String endpoint) {
    _endpoint = endpoint;
    _initTempProxy();
  }
  
  private void _initTempProxy() {
    try {
      temp = (new DefaultNamespace.TempServiceLocator()).getTemp();
      if (temp != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)temp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)temp)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (temp != null)
      ((javax.xml.rpc.Stub)temp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Temp getTemp() {
    if (temp == null)
      _initTempProxy();
    return temp;
  }
  
  public double convertFahrenheitToCelsius(double temperature) throws java.rmi.RemoteException{
    if (temp == null)
      _initTempProxy();
    return temp.convertFahrenheitToCelsius(temperature);
  }
  
  
}
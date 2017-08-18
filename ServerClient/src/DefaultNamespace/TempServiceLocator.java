/**
 * TempServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class TempServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.TempService {

    public TempServiceLocator() {
    }


    public TempServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TempServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Temp
    private java.lang.String Temp_address = "http://localhost:8080/Server/services/Temp";

    public java.lang.String getTempAddress() {
        return Temp_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TempWSDDServiceName = "Temp";

    public java.lang.String getTempWSDDServiceName() {
        return TempWSDDServiceName;
    }

    public void setTempWSDDServiceName(java.lang.String name) {
        TempWSDDServiceName = name;
    }

    public DefaultNamespace.Temp getTemp() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Temp_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTemp(endpoint);
    }

    public DefaultNamespace.Temp getTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.TempSoapBindingStub _stub = new DefaultNamespace.TempSoapBindingStub(portAddress, this);
            _stub.setPortName(getTempWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTempEndpointAddress(java.lang.String address) {
        Temp_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.Temp.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.TempSoapBindingStub _stub = new DefaultNamespace.TempSoapBindingStub(new java.net.URL(Temp_address), this);
                _stub.setPortName(getTempWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Temp".equals(inputPortName)) {
            return getTemp();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "TempService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "Temp"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Temp".equals(portName)) {
            setTempEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

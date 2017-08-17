/**
 * SOAPServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class SOAPServerServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.SOAPServerService {

    public SOAPServerServiceLocator() {
    }


    public SOAPServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOAPServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOAPServer
    private java.lang.String SOAPServer_address = "http://localhost:8080/SOAPServer/services/SOAPServer";

    public java.lang.String getSOAPServerAddress() {
        return SOAPServer_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOAPServerWSDDServiceName = "SOAPServer";

    public java.lang.String getSOAPServerWSDDServiceName() {
        return SOAPServerWSDDServiceName;
    }

    public void setSOAPServerWSDDServiceName(java.lang.String name) {
        SOAPServerWSDDServiceName = name;
    }

    public DefaultNamespace.SOAPServer getSOAPServer() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOAPServer_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAPServer(endpoint);
    }

    public DefaultNamespace.SOAPServer getSOAPServer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.SOAPServerSoapBindingStub _stub = new DefaultNamespace.SOAPServerSoapBindingStub(portAddress, this);
            _stub.setPortName(getSOAPServerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOAPServerEndpointAddress(java.lang.String address) {
        SOAPServer_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.SOAPServer.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.SOAPServerSoapBindingStub _stub = new DefaultNamespace.SOAPServerSoapBindingStub(new java.net.URL(SOAPServer_address), this);
                _stub.setPortName(getSOAPServerWSDDServiceName());
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
        if ("SOAPServer".equals(inputPortName)) {
            return getSOAPServer();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "SOAPServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "SOAPServer"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOAPServer".equals(portName)) {
            setSOAPServerEndpointAddress(address);
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

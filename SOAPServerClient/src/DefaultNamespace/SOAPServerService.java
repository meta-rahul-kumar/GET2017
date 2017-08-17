/**
 * SOAPServerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface SOAPServerService extends javax.xml.rpc.Service {
    public java.lang.String getSOAPServerAddress();

    public DefaultNamespace.SOAPServer getSOAPServer() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.SOAPServer getSOAPServer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

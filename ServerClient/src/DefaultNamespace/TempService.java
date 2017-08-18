/**
 * TempService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface TempService extends javax.xml.rpc.Service {
    public java.lang.String getTempAddress();

    public DefaultNamespace.Temp getTemp() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.Temp getTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

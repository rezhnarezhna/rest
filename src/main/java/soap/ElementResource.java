/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package soap;

import java.sql.SQLException;
import java.util.Base64;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @WebService Marks a Java class as implementing a Web Service
 * <p>
 * name -> The name of the Web Service. Used as the name of the wsdl:portType
 * when mapped to WSDL 1.1.
 * <p>
 * targetNamespace -> defining the name space for the WSDL document that
 * describes your service. serviceName -> is used to specify the name of the web
 * service as it appears in the generated WSDL document.
 * @WebMethod to mark a public method as an operation of the web service. It is
 * used at the method level and takes parameters such as operationName, action,
 * exclude, etc.
 * @WebParam: to specify the input and output parameters of a web service
 * operation. It is used at the method level and takes parameters such as name,
 * targetNamespace, mode, header, etc.
 * @WebResult: This annotation is used to specify the return value of a web
 * service operation. It is used at the method level and takes parameters such
 * as name, targetNamespace, header, etc.
 * @author
 *
 */
@WebService(targetNamespace = "http://localhost:8080/soapapi", serviceName = "elements", wsdlLocation = "http://localhost:8080/soapapi/elements?wsdl")
public class ElementResource {

    private ElementDAO elementDAO;

    public ElementResource() {

    }

    @WebMethod(operationName = "getElementByIdAndSize")
    public String getElementByIdAndSize(@WebParam(name = "id") int id,
            @WebParam(name = "size") String size) {
        try {
            elementDAO = new ElementDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Element element = elementDAO.getElement(id, size);

        String encodedData = Base64.getEncoder().encodeToString(element.getData());

        return encodedData;
    }
}

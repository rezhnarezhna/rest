/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import java.util.Base64;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import javax.ws.rs.QueryParam;

@Path("/elements")
public class ElementResource {

    private ElementDAO elementDAO;

    public ElementResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getElementByIdAndSize(@QueryParam("id") int id, @QueryParam("size") String size) {
        try {
            elementDAO = new ElementDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Element element = elementDAO.getElement(id, size);

        String encodedData = Base64.getEncoder().encodeToString(element.getData());
        
        return "{\"data\":"+encodedData+"}";
       
    }
}

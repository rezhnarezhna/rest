package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import soap.Element;
import elements.Max16MBElement;
import elements.Max4GBElement;
import elements.Max1byteElement;
import elements.Max255bytesElement;
import elements.Max64KBElement;

public class ResultSetConverter {

    public static Element convertResultSetToElement(ResultSet rs, String sizeCol) throws SQLException {
        Element element = null;
        switch (sizeCol) {
            case "max_1byte":
                element = new Max1byteElement(rs.getBytes(sizeCol));
                break;
            case "max_255bytes":
                element = new Max255bytesElement(rs.getBytes(sizeCol));
                break;
            case "max_64KB":
                element = new Max64KBElement(rs.getBytes(sizeCol));
                break;
            case "max_16MB":
                element = new Max16MBElement(rs.getBytes(sizeCol));
                break;
            case "max_4GB":
                element = new Max4GBElement(rs.getBytes(sizeCol));
                break;
            default:
                System.err.println("Wrong Size Parameter!");
        }
        return element;
    }
}

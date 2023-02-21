package rest;

/**
 * the Element class has four fields: id, small, medium, and large. The class
 * has two constructors: an empty constructor required by JAXB, and a
 * parameterized constructor that takes values for all fields.
 *
 * @author API Project Group
 *
 */
public interface Element {

    byte[] getData();

    void setData(byte[] size);

}

package elements;

import soap.Element;

public class Max1byteElement implements Element {

    private byte[] data;

    public Max1byteElement(byte[] size) {
        this.data = size;
    }

    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public void setData(byte[] size) {
        this.data = size;
    }
}

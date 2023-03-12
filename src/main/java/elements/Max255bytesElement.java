package elements;

import soap.Element;

public class Max255bytesElement implements Element {

    private byte[] data;

    public Max255bytesElement(byte[] size) {
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

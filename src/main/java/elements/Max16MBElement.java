package elements;

import soap.Element;

public class Max16MBElement implements Element {

    private byte[] data;

    public Max16MBElement(byte[] size) {
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

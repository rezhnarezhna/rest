package elements;

import rest.Element;

public class Max4GBElement implements Element {

    private byte[] data;

    public Max4GBElement(byte[] size) {
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

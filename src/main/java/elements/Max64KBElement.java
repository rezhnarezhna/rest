package elements;

import rest.Element;

public class Max64KBElement implements Element {

    private byte[] data;

    public Max64KBElement(byte[] size) {
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

package gameboj.component.memory;

import gameboj.Preconditions;

import java.util.Arrays;

/**
 * Represents a physical rom
 *
 * @author Francois BURGUET
 */
public final class Rom {

    private final byte[] data;

    /**
     * Constructor of Rom, copies the ArrayList "data"
     *
     * @param data : the ArrayList to copy
     */
    public Rom(byte[] data) {
        Preconditions.checkArgument(data.length > 0);
        this.data = Arrays.copyOf(data, data.length);
    }

    /**
     * Returns the size of the actual ArrayList "data"
     *
     * @return size of data
     */
    public int size() {
        return data.length;
    }

    /**
     * Returns the byte at index of the ArrayList "data"
     *
     * @param index : index of the byte to read
     * @return data written at index
     */
    public int read(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return Byte.toUnsignedInt(data[index]);
    }

}

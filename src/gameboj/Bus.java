package gameboj;

import gameboj.component.Component;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a physical 16-bits data bus
 *
 * @author Francois BURGUET
 */

public final class Bus {

    private final ArrayList<Component> comp = new ArrayList<>();

    /**
     * Attaches the component to this bus
     *
     * @param component : component to add, non-null
     * @throws NullPointerException if the given component is null
     */
    public void attach(Component component) {
        comp.add(Objects.requireNonNull(component));
    }

    /**
     * Retrieves the first data that is not <code>0xFF</code> from the list
     * of components attached to this bus. If no component can be read on the
     * given address, returns <code>0xFF</code>.
     *
     * @param address : address to read at, must be 16-bits
     * @return first readable data (non NO_DATA) in <code>components</code> at <code>address</code>
     * @throws IllegalArgumentException if the address is invalid
     */
    public int read(int address) {
        Preconditions.checkBits16(address);

        for (Component c : comp) {
            int result = c.read(address);
            if (result != Component.NO_DATA)
                return result;
        }
        return 0xFF;
    }

    /**
     * Writes the value <code>data</code> at the given <code>address</code>
     * on this bus.
     *
     * @param address : address of the data, must be 16-bits
     * @param data    : data to write, must be 8-bits
     * @throws IllegalArgumentException if the address or data is invalid
     */
    public void write(int address, int data) {
        Preconditions.checkBits16(address);
        Preconditions.checkBits8(data);

        for (Component c : comp) {
            c.write(address, data);
        }
    }
}

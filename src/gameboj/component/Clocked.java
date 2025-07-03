package gameboj.component;

/**
 * Represents a clocked object
 *
 * @author Francois BURGUET
 */

public interface Clocked {

    /**
     * Updates the object during the specified cycle
     *
     * @param cycle : current cycle simulated
     */
    void cycle(long cycle);

}

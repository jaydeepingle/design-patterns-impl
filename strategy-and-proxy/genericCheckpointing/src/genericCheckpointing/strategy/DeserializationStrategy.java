package genericCheckpointing.strategy;

/**
 * Deserialization Strategy Interface
 */
public interface DeserializationStrategy {
    /**
     * processOutput method
     * @return
     */
    Object processOutput();
}
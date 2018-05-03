package genericCheckpointing.strategy;

import genericCheckpointing.util.SerializableObject;

/**
 * Serialization Strategy Interface
 */
public interface SerializationStrategy {
    /**
     * process input method
     * @param serializationObject
     */
    void processInput(SerializableObject serializableObject);
}
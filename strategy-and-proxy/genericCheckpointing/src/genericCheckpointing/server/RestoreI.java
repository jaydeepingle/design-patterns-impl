package genericCheckpointing.server;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

/**
 * RestoreI interface
 */
public interface RestoreI extends StoreRestoreI {
    /**
     * method to read an object
     * @param wireFormat - takes the string in wireFormat as an input
     * @return SerializableObject
     */
    SerializableObject readObj(String wireFormat, FileProcessor fileProcessor);
}

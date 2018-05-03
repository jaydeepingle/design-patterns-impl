package genericCheckpointing.server;

import genericCheckpointing.store.Results;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
/**
 * StoreI interface
 */
public interface StoreI extends StoreRestoreI {
    /**
     * function which writes an object for First
     * @param aRecord
     * @param authID
     * @param wireFormat
     */
    void writeObj(MyAllTypesFirst aRecord, int authID, String wireFormat, Results results);

    /**
     * function which writes an object for second
     * @param bRecord
     * @param authID
     * @param wireFormat
     */
    void writeObj(MyAllTypesSecond bRecord, int authID, String wireFormat, Results results);
}
package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.strategy.DeserializationStrategy;
import genericCheckpointing.strategy.SerializationStrategy;
import genericCheckpointing.strategy.DeserializationXML;
import genericCheckpointing.strategy.SerializationXML;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.store.Results;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler {
    /**
     * invoke method
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        switch(methodName) {
            case "writeObj":
                if (args[2].equals("XML")) {
                    serializeData((SerializableObject) args[0], new SerializationXML((Results) args[3]));
                }
                break;
            case "readObj":
                if (args[0].equals("XML")) {
                    return deserializeData(new DeserializationXML((FileProcessor) args[1]));
                }
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * Function to serialize data
     * @param serializableObject
     * @param serializationStrategy
     */
    private void serializeData(SerializableObject serializableObject, SerializationStrategy serializationStrategy) {
        serializationStrategy.processInput(serializableObject);
    }

    /**
     * Function to deserialize data
     * @param deserializationStrategy
     * @return
     */
    private Object deserializeData(DeserializationStrategy deserializationStrategy) {
        Object object = deserializationStrategy.processOutput();
        return object;
    }
}
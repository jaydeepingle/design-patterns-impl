package genericCheckpointing.strategy;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.store.Results;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * class Serialization XML
 */
public class SerializationXML implements SerializationStrategy{
    private FileProcessor fileProcessor;
    public Results results;

    /**
     * Results
     * @param results
     */
    public SerializationXML(Results resultsInput) {
        this.results = resultsInput;
    }

    /**
     *
     * @param serializableObject
     */
    public void processInput(SerializableObject serializableObject) {

        Class<? extends Object> className = serializableObject.getClass();
        String fieldName, fieldType, typeFormat;
        Field[] fieldList;
        SerializeTypes serializeTypes = new SerializeTypes();
        fieldList = className.getDeclaredFields();
        results.writeToFile("<DPSerialization>\n");
        results.writeToFile(" <complexType xsi:type=\"" + className.getCanonicalName() + "\">\n");

        for (Field field : fieldList) {
            fieldName = field.getName();
            fieldType = field.getType().getTypeName();
            typeFormat = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = null;
            Object result = null;
            try {
                method = className.getMethod(typeFormat);
                method.setAccessible(true);
                result = method.invoke(serializableObject, (Object[]) null);
            } catch(Exception e) {
                e.printStackTrace();
            }

            switch (fieldType) {
                case "int":
                    results.writeToFile(serializeTypes.serializeInt((int) result, fieldName) + "\n");
                    break;

                case "double":
                    results.writeToFile(serializeTypes.serializeDouble((double) result, fieldName) + "\n");
                    break;

                case "float":
                    results.writeToFile(serializeTypes.serializeFloat((float) result, fieldName) + "\n");
                    break;

                case "long":
                    results.writeToFile(serializeTypes.serializeLong((long) result, fieldName) + "\n");
                    break;

                case "java.lang.String":
                    results.writeToFile(serializeTypes.serializeString((String) result, fieldName) + "\n");
                    break;

                case "boolean":
                    results.writeToFile(serializeTypes.serializeBoolean((boolean) result, fieldName) + "\n");
                    break;

                case "short":
                    results.writeToFile(serializeTypes.serializeShort((short) result, fieldName) + "\n");
                    break;

                case "char":
                    results.writeToFile(serializeTypes.serializeChar((char) result, fieldName) + "\n");
                    break;

                default:
                    break;

            }
        }
        results.writeToFile(" </complexType>\n</DPSerialization>\n");
    }
}
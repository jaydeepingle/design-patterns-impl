package genericCheckpointing.strategy;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.strategy.DeserializationStrategy;
//import genericCheckpointing.util.DeserializeTypes;

public class DeserializationXML implements DeserializationStrategy {
    FileProcessor fileProcessor;

    /**
     * Deserialization Function
     * @param fileProcessor
     */
    public DeserializationXML(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    /**
     * function for processing output
     * @return
     */
    public Object processOutput() {
        Object object = null;
        String line, className, fieldName, fieldType, value;
        Class classObject;
        DeserializeTypes deserializeTypes = new DeserializeTypes();
        while ((line = fileProcessor.readLine()) != null) {
            if (line.trim().contains("<DPSerialization>") || line.trim().contains("</DPSerialization>")) {
                continue;
            } else if (line.contains("</complexType>")) {
                return object;
            } else if (line.trim().contains("<complexType xsi:type=\"")) {
                className = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
                try {
                    classObject = Class.forName(className);
                    object = classObject.newInstance();
                } catch (InstantiationException ie) {
                    ie.printStackTrace();
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                } catch (IllegalAccessException iae) {
                    iae.printStackTrace();
                }
            } else {
                fieldName = line.substring(line.indexOf('<') + 1, line.indexOf('x') - 1);

                fieldType = line.substring(line.lastIndexOf(':') + 1, line.lastIndexOf('"'));
                value = line.substring(line.indexOf('>') + 1, line.lastIndexOf('<'));

                switch (fieldType) {
                    case "double":
                        deserializeTypes.deserializeDouble(Double.parseDouble(value), fieldName, object);
                        break;

                    case "float":
                        deserializeTypes.deserializeFloat(Float.parseFloat(value), fieldName, object);
                        break;

                    case "short":
                        deserializeTypes.deserializeShort(Short.parseShort(value), fieldName, object);
                        break;

                    case "char":
                        deserializeTypes.deserializeChar(value.charAt(0), fieldName, object);
                        break;

                    case "int":
                        deserializeTypes.deserializeInt(Integer.parseInt(value), fieldName, object);
                        break;

                    case "long":
                        deserializeTypes.deserializeLong(Long.parseLong(value), fieldName, object);
                        break;

                    case "string":
                        deserializeTypes.deserializeString(value, fieldName, object);
                        break;

                    case "boolean":
                        deserializeTypes.deserializeBoolean(Boolean.parseBoolean(value), fieldName, object);
                        break;

                    default:
                        System.out.println("fieldType mismatch.");
                        break;
                }
            }
        }
        return object;
    }

}
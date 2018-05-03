package genericCheckpointing.strategy;

public class SerializeTypes {
    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeInt(int value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:int\">" + Integer.toString(value) + "</" + tagName + ">";
    }

    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeLong(long value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:long\">" + Long.toString(value) + "</" + tagName + ">";
    }

    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeString(String value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:string\">" + value + "</" + tagName + ">";
    }

    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeBoolean(boolean value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:boolean\">" + Boolean.toString(value) + "</" + tagName + ">";
    }

    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeDouble(double value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:double\">" + Double.toString(value) + "</" + tagName + ">";
    }

    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeFloat(float value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:float\">" + Float.toString(value) + "</" + tagName + ">";
    }

    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeShort(short value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:short\">" + Short.toString(value) + "</" + tagName + ">";
    }

    /**
     *
     * @param value
     * @param tagName
     * @return
     */
    public String serializeChar(char value, String tagName) {
        return "  <" + tagName + " xsi:type=\"xsd:char\">" + Character.toString(value) + "</" + tagName + ">";
    }
}
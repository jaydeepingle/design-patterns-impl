package genericCheckpointing.strategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeserializeTypes {
    String typeFormat;
    Method method;
    Class[] param;

    public DeserializeTypes() {
        typeFormat = "";
        method = null;
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeInt(int value, String tagName, Object object) {
        param = new Class[1];
        param[0] = Integer.TYPE;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeLong(long value, String tagName, Object object) {
        param = new Class[1];
        param[0] = Long.TYPE;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeString(String value, String tagName, Object object) {
        param = new Class[1];
        param[0] = String.class;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeBoolean(boolean value, String tagName, Object object) {
        param = new Class[1];
        param[0] = Boolean.TYPE;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeShort(short value, String tagName, Object object) {
        param = new Class[1];
        param[0] = Short.TYPE;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeChar(char value, String tagName, Object object) {
        param = new Class[1];
        param[0] = Character.TYPE;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeDouble(double value, String tagName, Object object) {
        param = new Class[1];
        param[0] = Double.TYPE;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param value
     * @param tagName
     * @param object
     */
    public void deserializeFloat(float value, String tagName, Object object) {
        param = new Class[1];
        param[0] = Float.TYPE;
        method = null;
        typeFormat = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
        try {
            method = object.getClass().getMethod(typeFormat, param);
            method.invoke(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

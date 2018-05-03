package genericCheckpointing.driver;

import java.util.UUID;
import java.util.Random;
import genericCheckpointing.store.Results;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import genericCheckpointing.util.FileProcessor;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Driver class
 */
public class Driver {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        if(args.length != 3) {
            System.err.println("Invalid number of arguments.");
            System.exit(1);
        } else {
            String modeName = args[0];
            int numberOfObjects = Integer.parseInt(args[1]); //Handle NumberFormatException
            String checkpointFile = args[2];
            ProxyCreator pc = new ProxyCreator();

            Random random = new Random();

            List<Object> serializeList = new ArrayList<>();
            List<Object> deserializeList = new ArrayList<>();
            // create a proxy
            StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                    new Class[]{
                            StoreI.class, RestoreI.class
                    },
                    new StoreRestoreHandler()
            );

            MyAllTypesFirst myFirst;
            MyAllTypesSecond mySecond;

            FileProcessor fileProcessor = null;
            SerializableObject serializableObject = null;

            fileProcessor = new FileProcessor(checkpointFile);

            switch (modeName) {
                case "serdeser":
                    int count = 0;
                    short randomShort = (short) random.nextInt(Short.MAX_VALUE + 1);

                    for (int i = 0; i < numberOfObjects; i++) {
                        myFirst = new MyAllTypesFirst(random.nextInt(), random.nextInt(),
                                random.nextLong(), random.nextLong(),
                                UUID.randomUUID().toString().replace("-", ""), random.nextBoolean());
                        mySecond = new MyAllTypesSecond(random.nextDouble(),
                                random.nextDouble(), random.nextFloat(),
                                randomShort, (char) (53 * (i + 1)));

                        serializableObject = ((RestoreI) cpointRef).readObj("XML", fileProcessor);
                        deserializeList.add(serializableObject);
                        serializableObject = ((RestoreI) cpointRef).readObj("XML", fileProcessor);
                        deserializeList.add(serializableObject);

                        Results results = new Results(checkpointFile);
                        ((StoreI) cpointRef).writeObj(myFirst, i, "XML", results);
                        ((StoreI) cpointRef).writeObj(mySecond, i, "XML", results);
                        serializeList.add(myFirst);
                        serializeList.add(mySecond);
                    }

                    for (int i = 0; i < serializeList.size(); i++) {
                        Object object = serializeList.get(i);
                        Object deObject = deserializeList.get(i);

                        if (!object.equals(deObject)) {
                            count++;
                        }
                    }

                    for (Object object : serializeList) {
                        if(object != null) {
                            System.out.println("Object: " + object.toString());
                        }
                    }

                    for (Object object : deserializeList) {
                        if (object != null) {
                            System.out.println("Object: " + object.toString());
                        }
                    }
                    break;

                case "deser":
                    for (int i = 0; i < (2 * numberOfObjects); i++) {
                        serializableObject = ((RestoreI) cpointRef).readObj("XML", fileProcessor);
                        deserializeList.add(serializableObject);
                    }
                    for (Object object : deserializeList) {
                        if (object != null) {
                            System.out.println("Object: " + object.toString());
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
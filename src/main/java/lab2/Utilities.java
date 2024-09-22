package lab2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Utilities implements Serializable {

    private static Utilities instance;
    private static final long serialVersionUID = 1L;

    private Utilities() {}

    public static Utilities getInstance() {
        if (instance == null) {
            instance = new Utilities();
        }
        return instance;
    }

    // Serialize a object in xml format.
    public void serializeObjectXML(String file, Object object) throws IOException {
        try (ObjectOutputStream exit = new ObjectOutputStream(new FileOutputStream(file))) {
            exit.writeObject(object);
        }
    }

    // Deserialize a object in xml format.
    public Object deserializeObjectXML(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrance = new ObjectInputStream(new FileInputStream(file))) {
            return entrance.readObject();
        }
    }

    // Serialize a object in dat format.

    public void serializeObject(String file, Object object) throws IOException {
        try (ObjectOutputStream exit = new ObjectOutputStream(new FileOutputStream(file))) {
            exit.writeObject(object);
        }
    }

    // Deserialize a object in dat format.
    public Object deserializeObject(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrance = new ObjectInputStream(new FileInputStream(file))) {
            return entrance.readObject();
        }
    }
}


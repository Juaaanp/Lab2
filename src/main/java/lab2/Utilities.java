package lab2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Utilities implements Serializable {

    private static Utilities instance;
    private static final long serialVersionUID = 1L;

    // Logger instance for logging actions
    private static final Logger logger = Logger.getLogger(Utilities.class.getName());
    private static FileHandler fileHandler;

    // Singleton Pattern
    private Utilities() {
        setupLogger(); // Initialize the logger during instantiation
    }

    public static Utilities getInstance() {
        if (instance == null) {
            instance = new Utilities();
        }
        return instance;
    }

    // Set up the logger with file output
    private void setupLogger() {
        try {
            fileHandler = new FileHandler("session.log", true); 
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL); 
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to set up logger", e);
        }
    }

    // This the method of the second Point, we include the Level
    // of the Log because the problem says "todos los mensajes tipo
    // error o éxito deben estar presentes usando los diferentes niveles de severidad."
    @SuppressWarnings("exports")
    public void writeLog(String message, Level level) {
        logger.log(level, message);
    }
    // Serialize an object in XML format
    public void serializeObjectXML(String file, Object object) throws IOException {
        writeLog("Serializing object to XML file: " + file, Level.INFO);
        try (ObjectOutputStream exit = new ObjectOutputStream(new FileOutputStream(file))) {
            exit.writeObject(object);
        } catch (IOException e) {
            writeLog("Failed to serialize object to XML: " + e.getMessage(), Level.WARNING);
            throw e;
        }
    }

    // Deserialize an object in XML format
    public Object deserializeObjectXML(String file) throws IOException, ClassNotFoundException {
        writeLog("Deserializing object from XML file: " + file, Level.INFO);
        try (ObjectInputStream entrance = new ObjectInputStream(new FileInputStream(file))) {
            return entrance.readObject();
        } catch (IOException | ClassNotFoundException e) {
            writeLog("Failed to deserialize object from XML: " + e.getMessage(), Level.WARNING);
            throw e;
        }
    }

    // Serialize an object in DAT format
    public void serializeObject(String file, Object object) throws IOException {
        writeLog("Serializing object to DAT file: " + file, Level.INFO);
        try (ObjectOutputStream exit = new ObjectOutputStream(new FileOutputStream(file))) {
            exit.writeObject(object);
        } catch (IOException e) {
            writeLog("Failed to serialize object to DAT: " + e.getMessage(), Level.WARNING);
            throw e;
        }
    }

    // Deserialize an object in DAT format
    public Object deserializeObject(String file) throws IOException, ClassNotFoundException {
        writeLog("Deserializing object from DAT file: " + file, Level.INFO);
        try (ObjectInputStream entrance = new ObjectInputStream(new FileInputStream(file))) {
            return entrance.readObject();
        } catch (IOException | ClassNotFoundException e) {
            writeLog("Failed to deserialize object from DAT: " + e.getMessage(), Level.WARNING);
            throw e;
        }
    }
}


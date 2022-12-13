package data;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class textFileTest {

    @Test
    void leerArchivo()  {
        ArrayList<String> actual = FileReader.leerArchivo("src/test/java/data/readerTest");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("hola");
        assertEquals(expected, actual);

    }

}
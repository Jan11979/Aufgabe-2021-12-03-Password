import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyPasswortManagerTest {

    @Test
    public void shouldCalculateTwo() {
        MyPasswortManager test = new MyPasswortManager();
        assertTrue(test.getPasswort().equals("Geheim"));
        assertFalse(test.getPasswort().equals("Falsch"));
    }

}
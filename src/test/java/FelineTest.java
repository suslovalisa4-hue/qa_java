import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    private Feline feline;

    @BeforeEach
    public void setUps() {
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());

    }

    @Test
    public void testGetKittenDefault() {
        assertEquals(1, feline.getKittens());
    }

}

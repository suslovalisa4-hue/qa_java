import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {
    private Feline feline; // Объявляем переменную для класса Feline
    private Cat cat;

    @BeforeEach
    public void setUp() {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void testGetSounds() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Мясо"), food);
        Mockito.verify(feline).eatMeat();
    }


}

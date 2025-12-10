import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTests {
    private static final String validGender = "Самец";
    private static final String invalidGender = "invalidGender";
    private static final String exceptionMessage =
            "Используйте допустимые значения пола животного - самец или самка";

    @Mock
    private Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(validGender, feline);
        when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(validGender, feline);
        boolean actual = lion.doesHaveMane();

        assertTrue(actual);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(validGender, feline);
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }

    @Test
    public void checkExceptionByCreateLion() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(invalidGender, feline);
        });

        assertEquals(exceptionMessage, exception.getMessage());
    }
}
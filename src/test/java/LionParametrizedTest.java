import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionParametrizedTest {

    @Mock
    private Feline feline;

    @ParameterizedTest(name = "Проверка наличия гривы: пол = {0}, ожидается грива = {1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void lionConstructorAndDoesHaveManeTest(String gender, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(gender, feline);
        boolean actualHasMane = lion.doesHaveMane();

        assertEquals(expectedHasMane, actualHasMane,
                String.format("Для пола '%s' ожидается hasMane = %s, но получено %s",
                        gender, expectedHasMane, actualHasMane));
    }
}

import com.example.Animal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    @Test
    @DisplayName("Проверка, что травоядное получает определенную еду")
    public void testGetFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    @DisplayName("Проверка, что хищник принимает определенную еду")
    public void testGetFoodPredator() throws Exception{
        Animal animal = new Animal();
        List<String> food = animal.getFood( "Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);

    }

    @Test
    @DisplayName("Проверка, что при неизвестном животном выпадает исключение")
    public void testGetFoodUnknown() {
        Animal animal = new Animal();
        Exception exception = assertThrows(
                Exception.class,
                () -> animal.getFood("Птица")
        );
       assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    @DisplayName("Проверка работы метода getFamily")
       public void testGetFamily() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }


}

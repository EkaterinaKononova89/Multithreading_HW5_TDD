import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    PhoneBook sut;

    @BeforeEach
    public void beforeEach() {
        sut = new PhoneBook();
    }

    @AfterEach
    public void afterEach() {
        sut = null;
    }

    @Test
    public void testAdd1_simpleAdd() { // добавить имя с номером, возвращает количество контактов после добавления
        // given
        String name1 = "Sister";
        String phone1 = "111-111-111";

        String name2 = "Bro";
        String phone2 = "222-222-222";

        //when
        int addResult1 = sut.add(name1, phone1);
        int addResult2 = sut.add(name2, phone2);

        //then
        Assertions.assertEquals(1, addResult1);
        Assertions.assertEquals(2, addResult2);
    }

    @Test
    public void testAdd2_onlyDifferentName() { // возвращает количество контактов после добавления,
                                               // при этом гарантируется, что не будут добавляться повторяющиеся имена;
        // given
        String name1 = "Bro";
        String phone1 = "111-111-111";

        String name2 = "Bro";
        String phone2 = "222-222-222";

        //when
        int addResult1 = sut.add(name1, phone1);
        int addResult2 = sut.add(name2, phone2);

        //then
        Assertions.assertEquals(1, addResult1);
        Assertions.assertEquals(1, addResult2);
    }
}

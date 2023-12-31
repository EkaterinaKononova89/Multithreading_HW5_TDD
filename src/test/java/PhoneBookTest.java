import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void testFindByNumber() { //найти имя по номеру без полного перебора
        // given
        String name1 = "Mariya";
        String number1 = "111-111-111";

        String name2 = "Sasha";
        String number2 = "111-111-222";

        //when
        sut.add(name1, number1); // вроде нежелательно использовать метод при проверке другого метода?
        sut.add(name2, number2);
        String name = sut.findByNumber("111-111-111");

        //then
        Assertions.assertEquals("Mariya", name);
        Assertions.assertNotEquals("Sasha", name); // надо этот тест или нет?
    }

    @Test
    public void testFindByName() { //найти номер по имени без полного перебора
        // given
        String name1 = "Mariya";
        String number1 = "111-111-111";

        String name2 = "Sasha";
        String number2 = "111-111-222";

        //when
        sut.add(name1, number1);
        sut.add(name2, number2);
        String number = sut.findByName("Mariya");

        //then
        Assertions.assertEquals("111-111-111", number);
        Assertions.assertNotEquals("111-111-222", number);
    }

    @Test
    public void testPrintAllNames() {
        // given
        String name1 = "Mariya";
        String number1 = "111-111-111";

        String name2 = "Sasha";
        String number2 = "111-111-222";

        String name3 = "Sister";
        String number3 = "333-333-333";

        String name4 = "Brother";
        String number4 = "444-444-444";

        String name5 = "Mom";
        String number5 = "555-555-555";

        String name6 = "Dad";
        String number6 = "666-666-666";

        //when
        sut.add(name1, number1);
        sut.add(name2, number2);
        sut.add(name3, number3);
        sut.add(name4, number4);
        sut.add(name5, number5);
        sut.add(name6, number6);
        List<String> namesInNaturalOrder = sut.printAllNames();

        //then
        Assertions.assertEquals(namesInNaturalOrder, List.of("Brother", "Dad", "Mariya", "Mom", "Sasha", "Sister"));
    }
}

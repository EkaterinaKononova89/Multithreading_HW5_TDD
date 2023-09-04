import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, String> phoneBook_nameKey = new TreeMap<>();
    Map <String, String> phoneBook_numberKey = new TreeMap<>();

    public int add(String name, String phone) {
        if (!phoneBook_nameKey.containsKey(name)) {
            phoneBook_nameKey.put(name, phone);
            phoneBook_numberKey.put(phone, name);
        } else {
            System.out.println("Такое имя уже есть");
        }
        return phoneBook_nameKey.size();
    }

    public String findByNumber (String number) {
        return phoneBook_numberKey.get(number);
    }
}

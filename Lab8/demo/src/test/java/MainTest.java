
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.example.Main;

public class MainTest {

    // Створюємо екземпляр Main для тестування його методів.
    Main mainObj = new Main();

    // Тест для методу getLength()
    @Test(dataProvider = "lengthData")
    public void testGetLength(String input, int expectedLength) {
        int actual = mainObj.getLength(input);
        Assert.assertEquals(actual, expectedLength, "Невідповідність довжини для вхідного рядка: " + input);
    }

    // Data Provider для тесту testGetLength()
    @DataProvider(name = "lengthData")
    public Object[][] lengthData() {
        return new Object[][] {
                { "Hello, Java World!", 18 },
                { "TestNG", 6 },
                { "", 0 }
        };
    }

    // Тест для методу getSubstring()
    @Test(dataProvider = "substringData")
    public void testGetSubstring(String input, int start, int end, String expected) {
        String actual = mainObj.getSubstring(input, start, end);
        Assert.assertEquals(actual, expected, "Невідповідність підрядка для вхідного рядка: " + input);
    }

    // Data Provider для тесту testGetSubstring()
    @DataProvider(name = "substringData")
    public Object[][] substringData() {
        return new Object[][] {
                { "Hello, Java World!", 7, 11, "Java" },
                { "TestNG Automation", 0, 4, "Test" },
                { "abcdef", 2, 5, "cde" }
        };
    }

    // Тест для методу findIndex()
    @Test(dataProvider = "indexOfData")
    public void testFindIndex(String input, String search, int expectedIndex) {
        int actual = mainObj.findIndex(input, search);
        Assert.assertEquals(actual, expectedIndex, "Невідповідність індексу для вхідного рядка: "
                + input + " з пошуком: " + search);
    }

    // Data Provider для тесту testFindIndex()
    @DataProvider(name = "indexOfData")
    public Object[][] indexOfData() {
        return new Object[][] {
                { "Hello, Java World!", "Java", 7 },
                { "Hello", "l", 2 },
                { "abcdef", "x", -1 }
        };
    }

    // Тест, що приймає параметри з testng.xml
    @Test
    @Parameters({ "paramInput", "paramSearch", "paramExpected" })
    public void testWithParameters(String paramInput, String paramSearch, int paramExpected) {
        int actual = mainObj.findIndex(paramInput, paramSearch);
        Assert.assertEquals(actual, paramExpected, "Тест з параметрами не пройшов для вхідного рядка: " + paramInput);
    }
}

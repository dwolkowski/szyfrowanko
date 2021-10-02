import com.cwiczenia.type.CesarCipher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCesarCipher {
    CesarCipher cesarPositive = new CesarCipher(3);
    CesarCipher cesarNegative = new CesarCipher(-3);

    @Before
    private void setUp(){

    }

    @Test
    // Sprawdza działanie metody encodeText() z przesunięciem szyfru dodatnim o 3
    public void EncoderPositive(){
        Assert.assertEquals(cesarPositive.encodeText("test"), "WHVW");
    }

    @Test
    // Sprawdza działanie metody encodeTextWithRecursion() z przesunięciem szyfru dodatnim o 3
    public void EncoderPositiveWithRecursion(){
        Assert.assertEquals(cesarPositive.encodeTextWithRecursion("test"), "WHVW");
    }

    @Test
    // Sprawdza działanie metody encodeText() z przesunięciem szyfru ujemnym o -3
    public void EncoderNegative(){
        Assert.assertEquals(cesarNegative.encodeText("test"),"QBPQ");
    }

    @Test
    // Sprawdza działanie metody encodeTextWithRecursion() z przesunięciem szyfru ujemnym o -3
    public void EncoderNegativeWithRecursion(){
        Assert.assertEquals(cesarNegative.encodeTextWithRecursion("test"), "QBPQ");
    }
}

import com.cwiczenia.type.NumberCipher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNumberCipher {

    private final NumberCipher numberCipher = new NumberCipher();

    @Before
    private void setUp(){

    }

    @Test
    //  Sprawdza działanie metody encoder()
    public void Encoder(){
        Assert.assertEquals("83377778", numberCipher.encodeText("test"));
    }

    @Test
    //  Sprawdza działanie metody rekurencyjnej encoderWithRecursion()
    public void EncoderWithRecursion(){
        Assert.assertEquals("83377778", numberCipher.encodeTextWithRecursion("test"));
    }


}

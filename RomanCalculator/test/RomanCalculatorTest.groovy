import org.junit.Before
import org.junit.Ignore
import org.junit.Test

/**
 * Created by romina on 01.02.2016.
 */
class RomanCalculatorTest {


    def calculator

    @Before
    void setup() {
        calculator = new RomanCalculator()
    }


    @Test
    void IplusIisII() {
        assert "II" == calculator.sum("I", "I")
    }

    @Test
    void "I plus II is III"() {
        assert "III" == calculator.sum("I", "II")
    }

    @Test
    void XplusXisXX() {
        assert "XX" == calculator.sum("X", "X")
    }

    @Test
    void CplusCisCC() {
        assert "CC" == calculator.sum("C", "C")

    }

    @Test
    void MplusMisMM() {
        assert "MM" == calculator.sum("M", "M")

    }


    @Test
    @Ignore
    void VplusVisX() {
        assert "X" == calculator.sum("V", "V")
    }




    @Test
    void LplusLisC() {


    }



    @Test
    void DplusDisM() {


    }


    @Test
    void IIplusIIisIV() {


    }


    @Test
    void XXplusXXisXL() {


    }


    @Test
    void CCplusCCisCD() {


    }


    @Test
    void IIIplusIIIisVI() {


    }

    @Test
    void XXXplusXXXisLX() {


    }


    @Test
    void CCCplusCCCisDC() {


    }

    @Test
    void "I plus III is IV"() {

    }

    @Test
    void "I plus VIII is IX"() {

    }

    @Test
    void "I plus XIII is XIV"() {

    }

    @Test
    void "I plus XVIII is XIX"() {

    }

    @Test
    void "X plus XXX is XL"() {

    }

    @Test
    void "X plus LXXX is XC"() {

    }

    @Test
    void "V plus IV is IX"() {

    }

    @Test
    void "D plus CD is CM"() {

    }
}

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
    void "V plus II is VII"() {
        assert "VII" == calculator.sum("V", "II")
    }

    @Test
    void "XX plus I is XXI"() {
        assert "XXI" == calculator.sum("XX", "I")
    }

    @Test
    void "XX plus II is XXII"() {
        assert "XXII" == calculator.sum("XX", "II")
    }

    @Test
    void "II plus I is III"() {
        assert "III" == calculator.sum("II", "I")
    }

    @Test
    void "I plus V is VI"() {
        assert "VI" == calculator.sum("I", "V")
    }

    @Test
    void "II plus V is VII"() {
        assert "VII" == calculator.sum("II", "V")
    }


    @Test
    void VplusVisX() {
        assert "X" == calculator.sumSpecialSymbols("V", "V")
    }


    @Test
    void LplusLisC() {
        assert "C" == calculator.sumSpecialSymbols("L", "L")
    }



    @Test
    void DplusDisM() {
        assert "M" == calculator.sumSpecialSymbols("D", "D")

    }


    @Test
    void IIplusIIisIV() {
        assert "IV" == calculator.sumSpecialSymbols("II", "II")

    }


    @Test
    void XXplusXXisXL() {
        assert "XL" == calculator.sumSpecialSymbols("XX", "XX")

    }


    @Test
    void CCplusCCisCD() {
        assert "CD" == calculator.sumSpecialSymbols("CC", "CC")

    }


    @Test
    void IIIplusIIIisVI() {
        assert "VI" == calculator.sumSpecialSymbols("III", "III")

    }

    @Test
    void XXXplusXXXisLX() {
        assert "LX" == calculator.sumSpecialSymbols("XXX", "XXX")

    }


    @Test
    void CCCplusCCCisDC() {
        assert "DC" == calculator.sumSpecialSymbols("CCC", "CCC")

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

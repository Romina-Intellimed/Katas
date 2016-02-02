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
        assert "II" == calculator.sumSpecialSymbols("I", "I")
    }

    @Test
    void "I plus II is III"() {
        assert "III" == calculator.sumSpecialSymbols("I", "II")
    }

    @Test
    void XplusXisXX() {
        assert "XX" == calculator.sumSpecialSymbols("X", "X")
    }

    @Test
    void CplusCisCC() {
        assert "CC" == calculator.sumSpecialSymbols("C", "C")
    }

    @Test
    void MplusMisMM() {
        assert "MM" == calculator.sumSpecialSymbols("M", "M")
    }

    @Test
    void "V plus II is VII"() {
        assert "VII" == calculator.sumSpecialSymbols("V", "II")
    }

    @Test
    void "XX plus I is XXI"() {
        assert "XXI" == calculator.sumSpecialSymbols("XX", "I")
    }

    @Test
    void "XX plus II is XXII"() {
        assert "XXII" == calculator.sumSpecialSymbols("XX", "II")
    }

    @Test
    void "II plus I is III"() {
        assert "III" == calculator.sumSpecialSymbols("II", "I")
    }

    @Test
    void "I plus V is VI"() {
        assert "VI" == calculator.sumSpecialSymbols("I", "V")
    }

    @Test
    void "II plus V is VII"() {
        assert "VII" == calculator.sumSpecialSymbols("II", "V")
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
        assert "IV" == calculator.sumSpecialSymbols("I", "III")
    }

    @Test
    void "I plus VIII is IX"() {
        assert "IX" == calculator.sumSpecialSymbols("I", "VIII")

    }

    @Test
    void "I plus XIII is XIV"() {
        assert "XIV" == calculator.sumSpecialSymbols("I", "XIII")
    }

    @Test
    void "I plus XVIII is XIX"() {
        assert "XIX" == calculator.sumSpecialSymbols("I", "XVIII")
    }

    @Test
    void "X plus XXX is XL"() {
        assert "XL" == calculator.sumSpecialSymbols("X", "XXX")
    }

    @Test
    void "X plus LXXX is XC"() {
        assert "XC" == calculator.sumSpecialSymbols("X", "LXXX")
    }

    @Test
    void "V plus IV is IX"() {
        assert "IX" == calculator.sumSpecialSymbols("V", "IV")
    }

    @Test
    void "D plus CD is CM"() {
        assert "CM" == calculator.sumSpecialSymbols("D", "CD")

    }
}

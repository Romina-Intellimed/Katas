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
        assert "II" == calculator.sumRomanNumbers("I", "I")
    }

    @Test
    void "I plus II is III"() {
        assert "III" == calculator.sumRomanNumbers("I", "II")
    }

    @Test
    void XplusXisXX() {
        assert "XX" == calculator.sumRomanNumbers("X", "X")
    }

    @Test
    void CplusCisCC() {
        assert "CC" == calculator.sumRomanNumbers("C", "C")
    }

    @Test
    void MplusMisMM() {
        assert "MM" == calculator.sumRomanNumbers("M", "M")
    }

    @Test
    void "V plus II is VII"() {
        assert "VII" == calculator.sumRomanNumbers("V", "II")
    }

    @Test
    void "XX plus I is XXI"() {
        assert "XXI" == calculator.sumRomanNumbers("XX", "I")
    }

    @Test
    void "XX plus II is XXII"() {
        assert "XXII" == calculator.sumRomanNumbers("XX", "II")
    }

    @Test
    void "II plus I is III"() {
        assert "III" == calculator.sumRomanNumbers("II", "I")
    }

    @Test
    void "I plus V is VI"() {
        assert "VI" == calculator.sumRomanNumbers("I", "V")
    }

    @Test
    void "II plus V is VII"() {
        assert "VII" == calculator.sumRomanNumbers("II", "V")
    }


    @Test
    void VplusVisX() {
        assert "X" == calculator.sumRomanNumbers("V", "V")
    }


    @Test
    void LplusLisC() {
        assert "C" == calculator.sumRomanNumbers("L", "L")
    }



    @Test
    void DplusDisM() {
        assert "M" == calculator.sumRomanNumbers("D", "D")

    }


    @Test
    void IIplusIIisIV() {
        assert "IV" == calculator.sumRomanNumbers("II", "II")

    }


    @Test
    void XXplusXXisXL() {
        assert "XL" == calculator.sumRomanNumbers("XX", "XX")

    }


    @Test
    void CCplusCCisCD() {
        assert "CD" == calculator.sumRomanNumbers("CC", "CC")

    }


    @Test
    void IIIplusIIIisVI() {
        assert "VI" == calculator.sumRomanNumbers("III", "III")

    }

    @Test
    void XXXplusXXXisLX() {
        assert "LX" == calculator.sumRomanNumbers("XXX", "XXX")

    }


    @Test
    void CCCplusCCCisDC() {
        assert "DC" == calculator.sumRomanNumbers("CCC", "CCC")

    }

    @Test
    void "I plus III is IV"() {
        assert "IV" == calculator.sumRomanNumbers("I", "III")
    }

    @Test
    void "I plus VIII is IX"() {
        assert "IX" == calculator.sumRomanNumbers("I", "VIII")

    }

    @Test
    void "I plus XIII is XIV"() {
        assert "XIV" == calculator.sumRomanNumbers("I", "XIII")
    }

    @Test
    void "I plus XVIII is XIX"() {
        assert "XIX" == calculator.sumRomanNumbers("I", "XVIII")
    }

    @Test
    void "X plus XXX is XL"() {
        assert "XL" == calculator.sumRomanNumbers("X", "XXX")
    }

    @Test
    void "X plus LXXX is XC"() {
        assert "XC" == calculator.sumRomanNumbers("X", "LXXX")
    }

    @Test
    void "V plus IV is IX"() {
        assert "IX" == calculator.sumRomanNumbers("V", "IV")
    }

    @Test
    void "D plus CD is CM"() {
        assert "CM" == calculator.sumRomanNumbers("D", "CD")

    }
}

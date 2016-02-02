/**
 * Created by romina on 01.02.2016.
 */
class RomanCalculator {

    def romanDigitValue = ['I': 1, 'V': 2, 'X': 3, 'L': 4, 'C': 5, 'D': 6, 'M': 7]
    def romanSameConsecutiveDigitEquivalence = ['IIIII': 'V', 'VV': 'X', 'XXXXX': 'L', 'LL': 'C', 'CCCCC': 'D', 'DD': 'M']
    def romanSubstractivesEquivalence = ['IIII': 'IV', 'VIIII': 'IX', 'XXXX': 'XL', 'LXXXX': 'XC', 'CCCC': 'CD', 'DCCCC': 'CM']


    def sumRomanNumbers(firstRoman, secondRoman) {


        def digitsFromRomansToSumUp = replaceSubstractiveGroups(firstRoman) + replaceSubstractiveGroups(secondRoman)
        digitsFromRomansToSumUp = digitsFromRomansToSumUp.toList().sort { romanDigitValue.get(it) }.reverse().join()


        digitsFromRomansToSumUp = replaceInStringKeyWithValue(romanSameConsecutiveDigitEquivalence, digitsFromRomansToSumUp)
        digitsFromRomansToSumUp = replaceInStringKeyWithValue(romanSubstractivesEquivalence.iterator().reverse(), digitsFromRomansToSumUp)

        return digitsFromRomansToSumUp
    }

    def replaceSubstractiveGroups(romanNumber) {
        return replaceInStringValueWithKey(romanSubstractivesEquivalence, romanNumber)
    }


    def replaceInStringValueWithKey(keyValuePairs, romanNumber) {
        keyValuePairs.each { entry ->
            romanNumber = romanNumber.replaceAll(entry.value, entry.key)
        }
        return romanNumber
    }

    def replaceInStringKeyWithValue(keyValuePairs, romanNumber) {
        keyValuePairs.each { entry ->
            romanNumber = romanNumber.replaceAll(entry.key, entry.value)
        }
        return romanNumber
    }

}

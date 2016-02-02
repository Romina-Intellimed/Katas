/**
 * Created by romina on 01.02.2016.
 */
class RomanCalculator {

    def romanDigitValue = ['I': 1, 'V': 2, 'X': 3, 'L': 4, 'C': 5, 'D': 6, 'M': 7]
    def romanSameConsecutiveDigitEquivalence = ['IIIII':'V', 'VV':'X', 'XXXXX':'L', 'LL':'C', 'CCCCC':'D', 'DD':'M']
    def romanSubstractivesEquivalence =['IIII':'IV', 'VIIII':'IX', 'XXXX':'XL', 'LXXXX':'XC', 'CCCC':'CD', 'DCCCC':'CM']


    def sumRomanNumbers(firstRoman, secondRoman){

        romanSubstractivesEquivalence.each { entry ->
            firstRoman = firstRoman.replaceAll(entry.value, entry.key)
        }

        romanSubstractivesEquivalence.each { entry ->
            secondRoman = secondRoman.replaceAll(entry.value, entry.key)
        }


        def digitsFromRomansToSumUp = firstRoman + secondRoman
        digitsFromRomansToSumUp = digitsFromRomansToSumUp.toList().sort{romanDigitValue.get(it)}.reverse().join()


        romanSameConsecutiveDigitEquivalence.keySet().each { key ->
            digitsFromRomansToSumUp = digitsFromRomansToSumUp.replaceAll(key, romanSameConsecutiveDigitEquivalence.get(key))
        }
        romanSubstractivesEquivalence.keySet().iterator().reverse().each { key ->
            digitsFromRomansToSumUp = digitsFromRomansToSumUp.replaceAll(key, romanSubstractivesEquivalence.get(key))}

       return digitsFromRomansToSumUp
    }

}

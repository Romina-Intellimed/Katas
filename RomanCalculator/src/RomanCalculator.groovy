/**
 * Created by romina on 01.02.2016.
 */
class RomanCalculator {

    def romanDigitValue = ['I': 1, 'V': 2, 'X': 3, 'L': 4, 'C': 5, 'D': 6, 'M': 7]
    def romanSameConsecutiveDigitEquivalence = ['IIIII':'V', 'VV':'X', 'XXXXX':'L', 'LL':'C', 'CCCCC':'D', 'DD':'M']
    def romanSubstractivesEquivalence =['IIII':'IV', 'VIIII':'IX', 'XXXX':'XL', 'LXXXX':'XC', 'CCCC':'CD', 'DCCCC':'CM']


    def sum(firstRoman, secondRoman) {
        def digitsFromRomansToSumUp = firstRoman + secondRoman
        return digitsFromRomansToSumUp.toList().sort{romanDigitValue.get(it)}.reverse().join()
    }

    def sumSpecialSymbols(firstRoman, secondRoman){
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

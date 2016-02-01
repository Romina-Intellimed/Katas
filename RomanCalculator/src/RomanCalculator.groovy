/**
 * Created by romina on 01.02.2016.
 */
class RomanCalculator {

    def romanDigitValue = ['I': 1, 'V': 2, 'X': 3, 'L': 4, 'C': 5, 'D': 6, 'M': 7]
    def romanDigitEquivalence = ['IIIII':'V','VV':'X','XXXXX':'L','LL':'C','CCCCC':'M','DD':'M']


    def sum(firstRoman, secondRoman) {
        def digitsFromRomansToSumUp = firstRoman + secondRoman
        return digitsFromRomansToSumUp.toList().sort{romanDigitValue.get(it)}.reverse().join()
    }

    def sumSpecialSymbols(firstRoman, secondRoman){
        def digitsFromRomansToSumUp = firstRoman + secondRoman
        romanDigitEquivalence.keySet().each { key ->
            digitsFromRomansToSumUp = digitsFromRomansToSumUp.replaceAll(key, romanDigitEquivalence.get(key))
        }

       return digitsFromRomansToSumUp
    }

}

/**
 * Created by romina on 25.02.2016.
 */
class CountingWordFrequency {

    void countWords() {
        def textCorpus = """Look for the bare necessities The simple bare necessities Forget about your worries and your strife
                        I mean the bare necessities Old Mother Nature's recipes That bring the bare necessities of life """

        def words = textCorpus.tokenize()
        def wordFrequency = [:]

        words.each { word ->
            wordFrequency[word] = wordFrequency.get(word, 0) + 1
        }

        def wordList = wordFrequency.keySet().toList()

        wordList.sort { wordFrequency[it] }


        def statistic = "\n"

        wordList[-1..-5].each { word ->
            statistic += word.padLeft(12) + ': '
            statistic += wordFrequency[word] + "\n"

        }

        assert statistic == ""
        necessities: 4
        bare: 4
        the: 3
        your: 2
        life: 1
        ""

    }
}

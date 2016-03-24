import spock.lang.Specification

/**
 * Created by romina on 24.03.2016.
 */
class GPathSpec extends Specification {
    def ulcDate
    def otherDate
    def ulc
    def ve


    void setup(){
        ulcDate=Date.parse('yyyy-MM-dd', '2015-01-01')
        otherDate=Date.parse('yyyy-MM-dd', '2015-02-02')
        ulc=new Product( dollar:1499, name:'ULC'   )
        ve=new Product(dollar:499, name:'Visual Editor')
    }


    void "test GPath"(){
        given:
        def invoices = [
                new Invoice(date:ulcDate, items: [
                        new LineItem(count:5, product:ulc),
                        new LineItem(count:1, product:ve)
                ]),
                new Invoice(date:otherDate, items: [
                        new LineItem(count:4, product:ve)
                ])
        ]

        when:
        def allItems = invoices.items.flatten()
        then:
        assert [5*1499, 499, 4*499] == allItems*.total()
        assert ['ULC'] == allItems.grep{it.total() > 7000}.product.name

        when:
        def searchDates = invoices.grep{
            it.items.any{it.product == ulc}
        }.date*.toString()
        then:
        assert [ulcDate.toString()] == searchDates
    }
}


class Invoice{
    List items
    Date date
}

class LineItem{
    Product product
    int count
    int total(){
        return product.dolar*count
    }
}

class Product{
    String name
    def dollar
}

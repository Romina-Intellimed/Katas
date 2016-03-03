package todolist

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ToDoItemController)
@Mock([ToDoItem])
class ToDoItemControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "index returns empty list when no to do items"() {
        when:
        def actualListItems = controller.index().todoListItems

        then:
        assert [] == actualListItems
    }

    void "index returns list with all created toDoItems"() {
        given:
        def todoItem = new ToDoItem(name: "something").save()
        def todoItem2 = new ToDoItem(name: "something 2").save()

        when:
        def actualListItems = controller.index().todoListItems

        then:
        assert [todoItem, todoItem2] == actualListItems
    }

    void "test index return model"() {
        when:
        def toDoItemModel = controller.index()
        then:
        assert "In Show ToDoList page" == toDoItemModel.helloString
        assert [] == toDoItemModel.todoListItems

    }

    void "sort_byName renders corresponding view"() {
        when:
        controller.sort_byName()
        then:
        assert "/toDoItem/index" == view

    }


    void "sort_byName renders corresponding model"() {
        when:
        controller.sort_byName()
        then:
        assert [] == model.todoListItems

    }
}

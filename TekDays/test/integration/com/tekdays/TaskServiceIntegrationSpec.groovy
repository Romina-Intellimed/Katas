package com.tekdays

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.spock.IntegrationSpec

@TestFor(TaskService)
@Mock([TekUser, TekEvent])
class TaskServiceIntegrationSpec extends IntegrationSpec {

    def setup() {
        new TekUser(fullName: 'Tammy Tester', userName: 'tester', email: 'tester@test.com', website: 'test.com',
                bio: 'A test person', password: 'password').save()
    }

    def cleanup() {

    }

    void "test something"() {
        when: "we pass an event to taskService.addDefaultTasks"
        def e = new TekEvent(name: 'Test Event',
                city: 'TestCity, USA',
                description: 'Test description',
                organizer: TekUser.findByUserName('tester'),
                venue: 'Test Center',
                startDate: new Date(),
                endDate: new Date() + 1)
        service.addDefaultTasks(e)
        then: "the event will have 6 default tasks"
        e.tasks.size() == 6

    }
}

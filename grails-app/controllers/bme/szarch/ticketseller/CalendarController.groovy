package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class CalendarController {

    @Secured('permitAll')
    def index() { 
    	def concerts = Concert.list()
    	println concerts
    	def events = []
    	concerts.each{ c ->
    		events += [ title: c.performer, start: c.startTime, end: c.endTime, id: c.id]
    	}
    	[events:events]
    }
}

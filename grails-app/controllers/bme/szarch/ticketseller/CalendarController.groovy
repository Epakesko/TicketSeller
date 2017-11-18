package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class CalendarController {

    @Secured('permitAll')
    def index() { 
    	def concerts = Concert.list()
    	println concerts
    	def events = []
    	concerts.each{ concert ->
    		events += [ title: concert.performer, start: concert.date]
    	}
    	println events
    	[events:events]
    }
}

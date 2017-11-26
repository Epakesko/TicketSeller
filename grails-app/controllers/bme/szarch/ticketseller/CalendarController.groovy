package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class CalendarController {

	def concertService

    @Secured('permitAll')
    def index() { 
    	def concerts = concertService.listConcerts()
    	def events = []
    	concerts.each{ c ->
    		events += [ title: c.performer, start: c.startTime, end: c.endTime, id: c.id]
    	}
    	[events:events]
    }
}

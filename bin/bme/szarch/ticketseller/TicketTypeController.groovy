package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class TicketTypeController {
	
	@Secured('isAuthenticated()')
    def index() { 
    	def tickettypes = TicketType.list()
        [tickettypes:tickettypes]
    }
}

package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class TicketTypeController {
	
	def ticketTypeService
	
	@Secured('isAuthenticated()')
    def index() { 
    	def tickettypes = ticketTypeService.listTicketTypes()
        [tickettypes:tickettypes]
    }
}

package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class TicketController {
	def springSecurityService
    def ticketService
    
    @Secured('isAuthenticated()')
    def buy() { 
    	try{
			ticketService.buyTickets(params, springSecurityService.currentUser)
			flash.message = "Tickets bought!"
		}
		catch(e){
		    flash.message = e.getMessage()
		}
		redirect(controller: "concert", action: "show", id: params.id)
    }

}

package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class TicketController {
	def springSecurityService
    
    @Secured('isAuthenticated()')
    def buy() { 
    	def concert = Concert.get(params.id)		
    	def user = springSecurityService.currentUser	
		Collection<Ticket> tickets = Ticket.findAllByConcertAndOwnerOfIsNull(concert)
		tickets.each{ ticket ->
			def ticketID = "buyCount" + ticket.id
			def count = params[ticketID].toInteger()
			if(count != 0){
			    ticket.count -= count
			    ticket.save(flush: true)
			    
			    Ticket userTickets = Ticket.findByConcertAndTicketTypeAndOwnerOf(concert, ticket.ticketType, user)
			    if(userTickets == null) userTickets = new Ticket(ticketType: ticket.ticketType, concert: concert, count: 0, ownerOf: user)
			    userTickets.count += count
			    
			    userTickets.save(flush: true)            
			}
		}
		
		redirect(controller: "concert", action: "show", id: params.id)
    }

}

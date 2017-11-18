package bme.szarch.ticketseller


import grails.plugin.springsecurity.annotation.Secured


class ConcertController {

    
	def index() { }

	@Secured('permitAll')
	def show() {
		def concert = Concert.get(params.id)
	    def tickets = concert.getTickets()
	    
		[data: [ concert: concert, tickets: tickets ]]
	}

	@Secured('ROLE_ADMIN')
	def delete(){
		def concert = Concert.get(params.id)
		Collection<Ticket> tickets = Ticket.findAllByConcert(concert);
    	tickets*.delete(flush: true)
		concert.delete(flush: true)
		redirect(controller: "calendar", action: "index")
	}
}

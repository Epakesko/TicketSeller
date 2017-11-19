package bme.szarch.ticketseller


import grails.plugin.springsecurity.annotation.Secured


class ConcertController {

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
	
	@Secured('ROLE_ADMIN')
	def update(){
		def concert = Concert.get(params.id)
		Collection<Ticket> tickets = Ticket.findAllByConcert(concert)
		tickets.each{ ticket ->
			def ticketID = "ticketCount" + ticket.id
		    ticket.count = params[ticketID].toInteger()
		    ticket.save(flush: true)
		}

		concert.performer = params.performer
		concert.startTime = Date.parse('yyyy-MM-dd H:m', params.startTime)
		concert.endTime = Date.parse('yyyy-MM-dd H:m', params.endTime)
		concert.location = params.location
		concert.save(flush: true)
		
		//TODO: VALIDATE
		//TODO: FLUSH
		
		redirect(controller: "concert", action: "show", id: params.id)
	}
}

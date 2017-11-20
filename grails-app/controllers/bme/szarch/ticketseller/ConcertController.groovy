package bme.szarch.ticketseller


import grails.plugin.springsecurity.annotation.Secured


class ConcertController {

	@Secured('ROLE_ADMIN')
	def add() {
		def tTypes = TicketType.list()
		[ ticketTypes: tTypes ]   
	}

	@Secured('ROLE_ADMIN')
	def save() {
		
		Concert newConcert = new Concert(performer: params.performer, location: params.location, startTime: Date.parse('yyyy-MM-dd H:m', params.startTime), endTime: Date.parse('yyyy-MM-dd H:m', params.startTime)).save()  
		def tTypes = TicketType.list()
		tTypes.each{ tType ->
    		if(params[ tType.tType ] != 0){
    			new Ticket(ticketType: tType.tType, concert: newConcert, count: params[ tType.tType ]).save()                       
    		}

		}
   
	}

    @Secured('permitAll')
	def show() {
		def concert = Concert.get(params.id)
	    def tickets = concert.getTickets()
	    
		[data: [ concert: concert, tickets: tickets ]]
	}

	@Secured('ROLE_ADMIN')
	def delete(){
		def concert = Concert.get(params.id)
		Collection<Ticket> tickets = Ticket.findAllByConcertAndOwnerOfIsNull(concert);
    	tickets*.delete(flush: true)
		concert.delete(flush: true)
		redirect(controller: "calendar", action: "index")
	}
	
	@Secured('ROLE_ADMIN')
	def update(){
		def concert = Concert.get(params.id)
		Collection<Ticket> tickets = Ticket.findAllByConcertAndOwnerOfIsNull(concert)
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

package bme.szarch.ticketseller


import grails.plugin.springsecurity.annotation.Secured


class ConcertController {

	def concertService

	@Secured('ROLE_ADMIN')
	def add() {
		def tTypes = TicketType.list()
		[ ticketTypes: tTypes ]   
	}

	@Secured('ROLE_ADMIN')
	def save() {
		Concert newConcert = new Concert(performer: params.performer, location: params.location, startTime: Date.parse("yyyy-MM-dd'T'HH:mm", params.startTime), endTime: Date.parse("yyyy-MM-dd'T'HH:mm", params.endTime))
		newConcert.save()  
		def tTypes = TicketType.list()
		tTypes.each{ tType ->
			def ticketCount = params[ tType.tType ].toInteger()
    		if(ticketCount > 0){
    			new Ticket(ticketType: tType, concert: newConcert, count: params[ tType.tType ]).save(failOnError: true)                       
    		}

		}
   		redirect(controller: "calendar", action: "index")
	}

    @Secured('permitAll')
	def show() {
		def concert = Concert.get(params.id)
	    def tickets = concert.getTickets()
	    def startTimeFormatted = concert.startTime.format("yyyy-MM-dd'T'HH:mm")
	    def endTimeFormatted = concert.endTime.format("yyyy-MM-dd'T'HH:mm")
		[data: [ concert: concert, tickets: tickets, startTimeFormatted: startTimeFormatted, endTimeFormatted: endTimeFormatted]]
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
		Collection<Ticket> tickets = Ticket.findAllByConcertAndOwnerOfIsNull(concert)
		
		def msg = concertService.checkParameters(params, tickets)
		
		if(msg == "OK"){
			tickets.each{ ticket ->
				def ticketID = "ticketCount" + ticket.id
			    ticket.count = params[ticketID].toInteger()
			    ticket.save(flush: true)
			}
	
			concert.performer = params.performer
			concert.startTime = Date.parse("yyyy-MM-dd'T'HH:mm", params.startTime)
			concert.endTime = Date.parse("yyyy-MM-dd'T'HH:mm", params.endTime)
			concert.location = params.location
			concert.save(flush: true)
			flash.message = "Update successful"		           
		}
		else{
			flash.message = msg
		}
		redirect(controller: "concert", action: "show", id: params.id)
		
		
	}
}

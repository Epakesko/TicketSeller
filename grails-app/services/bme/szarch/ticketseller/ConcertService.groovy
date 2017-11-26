package bme.szarch.ticketseller

import grails.gorm.transactions.Transactional

@Transactional
class ConcertService {

	def listConcerts(){
	    Concert.list()
	}

	def saveConcert(def params){
	    Concert newConcert = new Concert(performer: params.performer, location: params.location, startTime: Date.parse("yyyy-MM-dd'T'HH:mm", params.startTime), endTime: Date.parse("yyyy-MM-dd'T'HH:mm", params.endTime))
		newConcert.save()  
		def tTypes = TicketType.list()
		tTypes.each{ tType ->
			def ticketCount = params[ tType.tType ].toInteger()
    		if(ticketCount > 0){
    			new Ticket(ticketType: tType, concert: newConcert, count: params[ tType.tType ]).save()                       
    		}
    		else if(ticketCount < 0) throw new Exception("Ticket count can't be negative!")
		}
		
    	if(newConcert.performer == null || newConcert.performer == "") throw new Exception("Performer can't be empty!")
		else if(newConcert.location == null || newConcert.location == "") throw new Exception("Location can't be empty!")
		else if(newConcert.startTime > newConcert.endTime) throw new Exception("Starting time must be before ending time!")
	}


	def deleteConcert(def id){
	    def concert = Concert.get(id)
		Collection<Ticket> tickets = Ticket.findAllByConcert(concert);
    	tickets*.delete()
		concert.delete()
	}

	def showConcert(def id){
	    def concert = Concert.get(id)
	    def tickets = concert.getTickets()
	    def startTimeFormatted = concert.startTime.format("yyyy-MM-dd'T'HH:mm")
	    def endTimeFormatted = concert.endTime.format("yyyy-MM-dd'T'HH:mm")
	    return [concert: concert, tickets: tickets, startTimeFormatted: startTimeFormatted, endTimeFormatted: endTimeFormatted]    
	}

	def updateConcert(def params){
	    def concert = Concert.get(params.id)
		Collection<Ticket> tickets = Ticket.findAllByConcertAndOwnerOfIsNull(concert)
		
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
		
		concert = Concert.get(params.id)
		tickets = Ticket.findAllByConcertAndOwnerOfIsNull(concert)
		def negative = false
		tickets.each{ ticket ->
		    if(ticket.count < 0) throw new Exception("Ticket count can't be negative!")
		}
		
    	if(concert.performer == null || concert.performer == "") throw new Exception("Performer can't be empty!")
		else if(concert.location == null || concert.location == "") throw new Exception("Location can't be empty!")
		else if(concert.startTime > concert.endTime) throw new Exception("Starting time must be before ending time!")
	}
}

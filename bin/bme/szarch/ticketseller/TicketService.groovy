package bme.szarch.ticketseller

import grails.gorm.transactions.Transactional

@Transactional
class TicketService {
	
	def getUserTickets(def user){
	    Ticket.findAllByOwnerOf(user)
	}


    def buyTickets(def params, def user) {
		def concert = Concert.get(params.id)	
		Collection<Ticket> tickets = Ticket.findAllByConcertAndOwnerOfIsNull(concert)
		tickets.each{ ticket ->
			def ticketID = "buyCount" + ticket.id
			def count = params[ticketID].toInteger()
			if(count < 0) throw new Exception("You can't buy negative amount of tickets!")
			
			ticket.count -= count
			ticket.save()
			
			if(ticket.count < 0) throw new Exception("Not enough tickets!") 
			if(count > 0){
				Ticket userTickets = Ticket.findByConcertAndTicketTypeAndOwnerOf(concert, ticket.ticketType, user)
				if(userTickets == null) userTickets = new Ticket(ticketType: ticket.ticketType, concert: concert, count: 0, ownerOf: user)
				userTickets.count += count
				userTickets.save()          
			}


		}
    }
}

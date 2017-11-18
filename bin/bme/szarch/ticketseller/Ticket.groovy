package bme.szarch.ticketseller

class Ticket {

	TicketType ticketType
	Concert concert
	User ownerOf
	Integer count

    static constraints = {
    	ticketType blank: false
    	concert blank: false
    	ownerOf nullable: true
    	count blank: false
    }
}

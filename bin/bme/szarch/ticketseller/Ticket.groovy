package bme.szarch.ticketseller

class Ticket {

	TicketType ticketType
	Concert concert
	User ownerOf
	Integer count

    static constraints = {
    	ticketType blank: false, unique: false
    	concert blank: false, unique: false
    	user nullable: true, unique: false
    	count blank: false, unique: false
    }
}

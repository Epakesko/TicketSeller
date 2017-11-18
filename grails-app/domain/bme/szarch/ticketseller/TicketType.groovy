package bme.szarch.ticketseller

class TicketType {

	String tType
	Double price

    static constraints = {
    	tType blank: false
    	price blank: false
    }
}

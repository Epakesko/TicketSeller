package bme.szarch.ticketseller

class TicketType {

	String tType
	Double price

    static constraints = {
    	tType blank: false, unique: false
    	price blank: false, unique: false
    }
}

package bme.szarch.ticketseller

class Concert {

	Date startTime
	Date endTime
	String location
	String performer

    static constraints = {
    	startTime min: Date.parse('yyyy-MM-dd H:m', '2017-01-01 00:00'), max: Date.parse('yyyy-MM-dd H:m', '2999-12-31 23:59'), blank: false
    	endTime min: Date.parse('yyyy-MM-dd H:m', '2017-01-01 00:00'), max: Date.parse('yyyy-MM-dd H:m', '2999-12-31 23:59'), blank: false 
    	location blank: false 
    	performer blank: false
    }
    
    
    def getTickets() {
    	return Ticket.findAllByConcertAndOwnerOfIsNull(this)
  	}
}

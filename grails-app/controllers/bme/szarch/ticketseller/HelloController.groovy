package bme.szarch.ticketseller
class HelloController {
    def index() { 
    	def tickets = Ticket.list()
        [tickets:tickets]
    }
}

package bme.szarch.ticketseller
class TicketTypeController {
    def index() { 
    	def tickettypes = TicketType.list()
        [tickettypes:tickettypes]
    }
}

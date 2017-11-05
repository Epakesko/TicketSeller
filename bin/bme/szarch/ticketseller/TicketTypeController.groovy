package bme.szarch.ticketseller
class HelloController {
    def index() { 
    	def tickettypes = TicketType.list()
        [tickettypes:tickettypes]
    }
}

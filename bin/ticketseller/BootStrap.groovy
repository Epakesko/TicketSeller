package ticketseller

import bme.szarch.ticketseller.*;

class BootStrap {

    def init = { servletContext ->
    	TicketType vip = new TicketType()
    	vip.name = "vip"
    	vip.price = 500
    	vip.save()
    	
    	TicketType sitting = new TicketType()
    	sitting.name = "sitting"
    	sitting.price = 200
    	sitting.save()
    	
    	Ticket newticket = new Ticket()
    	newticket.ticketType = vip
    	newticket.count = 100;
    	newticket.save()
    	
    	Ticket newticket2 = new Ticket()
    	newticket2.ticketType = sitting
    	newticket2.count = 500;  
    	newticket2.save()  
    }
    def destroy = {
    }
}

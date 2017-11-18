package ticketseller

import bme.szarch.ticketseller.*;

class BootStrap {

    def init = { servletContext ->
    
    	new Role(authority: "ROLE_USER").save()
    
    	Role role = new Role(authority: "ROLE_ADMIN").save()
    
    	User user = new User(username: "admin", password: "admin").save()
    
    	UserRole.create user, role

		Concert RHODES = new Concert(startTime: Date.parse('yyyy-MM-dd H:m', '2017-11-15 18:30'), endTime: Date.parse('yyyy-MM-dd H:m', '2017-11-15 18:55'), location: "Wembley", performer: "RHODES").save()
		Concert Ed = new Concert(startTime: Date.parse('yyyy-MM-dd H:m', '2017-11-15 19:00'), endTime: Date.parse('yyyy-MM-dd H:m', '2017-11-15 20:30'), location: "Wembley", performer: "Ed Sheeran").save()
		Concert U2 = new Concert(startTime: Date.parse('yyyy-MM-dd H:m', '2017-11-15 21:00'), endTime: Date.parse('yyyy-MM-dd H:m', '2017-11-15 23:00'),location: "Wembley", performer: "U2").save(failOnError:true)
		Concert CELLOS = new Concert(startTime: Date.parse('yyyy-MM-dd H:m', '2017-11-21 19:35'), endTime: Date.parse('yyyy-MM-dd H:m', '2017-11-21 21:35'),location: "SYMA", performer: "2CELLOS").save()
		Concert Wellhello = new Concert(startTime: Date.parse('yyyy-MM-dd H:m', '2017-12-12 01:00'), endTime: Date.parse('yyyy-MM-dd H:m', '2017-12-12 02:00'),location: "A38", performer: "Wellhello").save()
    	
    	TicketType VIP = new TicketType(tType: "VIP", price: 1000).save()
    	TicketType StandA = new TicketType(tType: "Standing A", price: 800).save()
    	TicketType StandB = new TicketType(tType: "Standing B", price: 600).save()
    	TicketType Sitting = new TicketType(tType: "Sitting", price: 400).save()
    	TicketType SittingR = new TicketType(tType: "Sitting Restricted View", price: 200).save()
    	
    	new Ticket(ticketType: VIP, concert: Ed, count: 100).save()
    	new Ticket(ticketType: StandA, concert: Ed, count: 500).save()
    	new Ticket(ticketType: StandB, concert: Ed, count: 1000).save()
    	new Ticket(ticketType: Sitting, concert: Ed, count: 1000).save()
    	new Ticket(ticketType: SittingR, concert: Ed, count: 500).save()
    	
    	new Ticket(ticketType: StandA, concert: RHODES, count: 600).save()
    	new Ticket(ticketType: StandB, concert: RHODES, count: 1000).save()
    	new Ticket(ticketType: Sitting, concert: RHODES, count: 1000).save()
    	new Ticket(ticketType: SittingR, concert: RHODES, count: 500).save()
    	
    	new Ticket(ticketType: VIP, concert: U2, count: 100).save()
    	new Ticket(ticketType: StandA, concert: U2, count: 500).save()
    	new Ticket(ticketType: StandB, concert: U2, count: 1000).save()
    	new Ticket(ticketType: Sitting, concert: U2, count: 1000).save()
    	new Ticket(ticketType: SittingR, concert: U2, count: 500).save()
    	
    	new Ticket(ticketType: VIP, concert: CELLOS, count: 500).save()
    	new Ticket(ticketType: Sitting, concert: CELLOS, count: 2000).save()
    	new Ticket(ticketType: SittingR, concert: CELLOS, count: 1500).save()
    	
    	new Ticket(ticketType: StandB, concert: Wellhello, count: 2000).save()
    }
    def destroy = {
    }
}

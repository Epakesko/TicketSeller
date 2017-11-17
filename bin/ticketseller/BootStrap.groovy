package ticketseller

import bme.szarch.ticketseller.*;

class BootStrap {

    def init = { servletContext ->
    
    	new Role(authority: "ROLE_USER").save()
    
    	Role role = new Role(authority: "ROLE_ADMIN").save()
    
    	User user = new User(username: "admin", password: "admin").save()
    
    	UserRole.create user, role


		new Concert(date: Date.parse('yyyy-MM-dd H:m', '2017-11-15 19:00'), location: "Wembley", performer: "Ed Sheeran").save()
		new Concert(date: Date.parse('yyyy-MM-dd H:m', '2017-11-15 21:00'), location: "Wembley", performer: "U2").save(failOnError:true)
		new Concert(date: Date.parse('yyyy-MM-dd H:m', '2017-11-21 19:35'), location: "SYMA", performer: "Gorillaz").save()
		new Concert(date: Date.parse('yyyy-MM-dd H:m', '2017-12-12 01:00'), location: "A38", performer: "Wellhello").save()
    	new TicketType(tType: "VIP", price: 1000).save()
    	new TicketType(tType: "Standing A", price: 800).save()
    	new TicketType(tType: "Standing B", price: 600).save()
    	new TicketType(tType: "Sitting", price: 400).save()
    	new TicketType(tType: "Sitting Restricted View", price: 200).save()
    }
    def destroy = {
    }
}

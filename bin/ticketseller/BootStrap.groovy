package ticketseller

import bme.szarch.ticketseller.*;

class BootStrap {

    def init = { servletContext ->
    
    	new Role(authority: "ROLE_USER").save()
    
    	Role admin = new Role(authority: "ROLE_ADMIN")
    	admin.save()
    
    	new User(role: admin, userName: "admin", password: "admin").save()
    
    	new TicketType(tType: "VIP", price: 1000).save()
    	new TicketType(tType: "Standing A", price: 800).save()
    	new TicketType(tType: "Standing B", price: 600).save()
    	new TicketType(tType: "Sitting", price: 400).save()
    	new TicketType(tType: "Sitting Restricted View", price: 200).save()
    }
    def destroy = {
    }
}

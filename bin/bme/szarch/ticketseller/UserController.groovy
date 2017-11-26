package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class UserController {

	def springSecurityService
	def ticketService
	def userService

	@Secured('permitAll')
    def index() { 
    	def tickets = ticketService.getUserTickets(springSecurityService.currentUser)
    	[ tickets:tickets ]
    }
    
    @Secured('permitAll')
    def register() {

		if (springSecurityService.isLoggedIn()) {
			redirect uri: "/"
			return
		}

		render view: 'register'
	}
	
	@Secured('permitAll')
    def save() {
		try{
			userService.saveUser(params)
			flash.message = "Registration succesful. Please login."
			redirect(controller: "login", action: 'auth')
		}catch(e){
			flash.message = e.getMessage()
			redirect(action: 'register')
		}
		
	}
}

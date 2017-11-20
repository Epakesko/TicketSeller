package bme.szarch.ticketseller

import grails.plugin.springsecurity.annotation.Secured

class UserController {

	def springSecurityService
	def userService

	@Secured('permitAll')
    def index() { 
    	def tickets = Ticket.findAllByOwnerOf(springSecurityService.currentUser)
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
		def msg = userService.checkRegistration(params)
		if(msg == "OK"){
			flash.message = "Registration succesful. Please login."
			new User(username: params.username, email: params.email, password: params.password).save(failOnError:true)
			redirect(controller: "login", action: 'auth')
		}
		else{
			flash.message = msg
			redirect(action: 'register')
		}
		
	}
}

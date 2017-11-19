package bme.szarch.ticketseller

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def checkRegistration(def params) {
    	def emailPattern = /[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})/
    
    	if(params.username == null || params.username == "") return "Username can't be empty!"
    	else if(User.findByUsername(params.username)!=null) return "This username is taken!"
    	else if(params.email == null || params.email == "") return "You have to provide an e-mail address. The bought tickets will be sent here."
    	else if(!(params.email ==~ emailPattern)) return "The e-mail is not in a valid format."
    	else if(params.password == null || params.password == "") return "Password can't be empty!"
    	else if(params.password != params.password2) return "The passwords do not match."
		else return "OK"
    }
}

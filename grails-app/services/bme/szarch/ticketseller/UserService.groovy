package bme.szarch.ticketseller

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def saveUser(def params) {
    	def emailPattern = /[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})/
    	if(User.findByUsername(params.username)!=null) throw new Exception("This username is taken!")
    	else if(params.username == null || params.username == "") throw new Exception("Username can't be empty!")
    	else if(params.email == null || params.email == "") throw new Exception("You have to provide an e-mail address. The bought tickets will be sent here.")
    	else if(!(params.email ==~ emailPattern)) throw new Exception("The e-mail is not in a valid format.")
    	else if(params.password == null || params.password == "") throw new Exception("Password can't be empty!")
    	else if(params.password != params.password2) throw new Exception("The passwords do not match.")
		else return new User(username: params.username, email: params.email, password: params.password).save()
    }
}

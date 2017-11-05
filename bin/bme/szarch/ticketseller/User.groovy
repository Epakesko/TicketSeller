package bme.szarch.ticketseller

class User {

	Role role
	String userName
	String password
	String email

    static constraints = {
        userName size: 5..15, blank: false, unique: true
        password size: 5..15, blank: false
        email email: true, blank: false, nullable: true
        role blank: false
    }
}

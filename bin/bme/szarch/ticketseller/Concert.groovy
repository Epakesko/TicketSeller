package bme.szarch.ticketseller

class Concert {

	String date
	String location
	String performer

    static constraints = {
    	date min: Date.parse('yyyy-MM-dd', '2017-01-01'), max: Date.parse('yyyy-MM-dd', '2999-12-31'), blank: false, unique: false 
    	location blank: false, unique: false
    	performer blank: false, unique: false 
    }
}

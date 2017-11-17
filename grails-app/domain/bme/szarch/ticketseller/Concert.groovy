package bme.szarch.ticketseller

class Concert {

	Date date
	String location
	String performer

    static constraints = {
    	date min: Date.parse('yyyy-MM-dd H:m', '2017-01-01 00:00'), max: Date.parse('yyyy-MM-dd H:m', '2999-12-31 23:59'), blank: false, unique: false 
    	location blank: false 
    	performer blank: false, unique: false 
    }
}

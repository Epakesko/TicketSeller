package bme.szarch.ticketseller

import grails.gorm.transactions.Transactional

@Transactional
class ConcertService {

    def checkParameters(def params, def tickets) {
    	def minus = false
		tickets.each{ ticket ->
			def ticketID = "ticketCount" + ticket.id
		    if(params[ticketID].toInteger() < 0) minus = true
		}
		
    	if(params.performer == null || params.performer == "") return "Performer can't be empty!"
    	else if(minus) return "Not enough tickets!"
		else if(params.location == null || params.location == "") return "Location can't be empty!"
		else if(params.location == null || params.location == "") return "Location can't be empty!"
		else if(Date.parse("yyyy-MM-dd'T'HH:mm", params.startTime) > Date.parse("yyyy-MM-dd'T'HH:mm", params.endTime)) return "Starting time must be before ending time!"
		else return "OK" 
    }
}

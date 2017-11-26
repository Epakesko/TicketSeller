package bme.szarch.ticketseller

import grails.gorm.transactions.Transactional

@Transactional
class TicketTypeService {

    def listTicketTypes() {
		TicketType.list()
    }
}

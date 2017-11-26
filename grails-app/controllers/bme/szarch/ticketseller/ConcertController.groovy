package bme.szarch.ticketseller


import grails.plugin.springsecurity.annotation.Secured


class ConcertController {

	def concertService
	def ticketTypeService

	@Secured('ROLE_ADMIN')
	def add() {
		def tTypes = ticketTypeService.listTicketTypes()
		[ ticketTypes: tTypes ]   
	}

	@Secured('ROLE_ADMIN')
	def save() {
		try{
		    concertService.saveConcert(params)
		    flash.message = "Concert added!"
		}
		catch(e){
		    flash.message = e.getMessage()
		}
   		redirect(controller: "concert", action: "add")
	}

    @Secured('permitAll')
	def show() {
		def concert = concertService.showConcert(params.id)
		[data: concert]
	}

	@Secured('ROLE_ADMIN')
	def delete(){
		concertService.deleteConcert(params.id)
		redirect(controller: "calendar", action: "index")
	}
	
	@Secured('ROLE_ADMIN')
	def update(){
		try{
		    concertService.updateConcert(params)
		    flash.message = "Update successful!"
		}
		catch(e){
		    flash.message = e.getMessage()
		}
		redirect(controller: "concert", action: "show", id: params.id)
		
	}
}

package bme.szarch.ticketseller


import grails.plugin.springsecurity.annotation.Secured


class ConcertController {

    
	def index() { }

	@Secured('permitAll')
	def show() {
		[concert: Concert.get(params.id)]
	}

}

package ticketseller

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/concerts"(resources:'concert', includes:['show'])
        "/"(controller: "calendar", action: "index")
        "/aaa"(view: "/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

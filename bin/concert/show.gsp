<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Ticket types</title>
	</head>
	<body">
		<sec:ifNotGranted roles='ROLE_ADMIN'>
        <h2>${data.concert.performer}</h2>
		<p> <i class="fa grails-icon"> <asset:image src="location.png"/> ${data.concert.location} </i> </p>
		<p> From ${data.concert.startTime} to ${data.concert.endTime} </p>
		</br>
		<h3>Available tickets:
			<g:each in="${data.tickets}" var="ticket" status="i">
	            <br>	Type: ${ticket.ticketType.tType}, Price: ${ticket.ticketType.price}, Available: ${ticket.count} </br>
	        </g:each>
	    </h3>
		</sec:ifNotGranted>
		
		<sec:ifAllGranted roles='ROLE_ADMIN'>
		<form action="<g:createLink controller="concert" action="update" id="${data.concert.id}" />">
        <h3>Performer: <g:textField name="performer" value="${data.concert.performer}"/></h3>
		<h3>Venue: <g:textField name="location" value="${data.concert.location}"/></h3>
		<h3>Starts at: <g:textField name="startTime" value="${data.concert.startTime}"/></h3>
		<h3>Ends at (estimated): <g:textField name="endTime" value="${data.concert.endTime}"/></h3>
		<h3>Available tickets:
			<g:each in="${data.tickets}" var="ticket" status="i">
	            <br>	Type: ${ticket.ticketType.tType}, Price: ${ticket.ticketType.price}, Available: <g:textField name="ticketCount${ticket.id}" value="${ticket.count}"/> </br>
	        </g:each>
	    </h3>
	   
    		<input type="submit" value="EDIT" />
		</form>
	    <form action="<g:createLink controller="concert" action="delete" id="${data.concert.id}" />">
    		<input type="submit" value="DELETE" />
		</form>
		</sec:ifAllGranted>
		<sec:ifLoggedIn>
		<form action="<g:createLink controller="ticket" action="buy" id="${data.concert.id}" />">
    		<input type="submit" value="BUY" />
		</form>
		</sec:ifLoggedIn>
	</body>
</html>
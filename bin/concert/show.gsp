<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Ticket types</title>
	</head>
	<body>
		<sec:ifNotGranted roles='ROLE_ADMIN'>
        <h3>Performer: ${data.concert.performer}</h3>
		<h3>Venue: ${data.concert.location}</h3>
		<h3>Starts at: ${data.concert.startTime}</h3>
		<h3>Ends at (estimated): ${data.concert.endTime}</h3>
		<h3>Available tickets:
			<g:each in="${data.tickets}" var="ticket" status="i">
	            <br>	Type: ${ticket.ticketType.tType}, Price: ${ticket.ticketType.price}, Available: ${ticket.count} </br>
	        </g:each>
	    </h3>
		</sec:ifNotGranted>
		
		<sec:ifAllGranted roles='ROLE_ADMIN'>
        <h3>Performer: <g:textField name="performer" value="${data.concert.performer}"/></h3>
		<h3>Venue: <g:textField name="location" value="${data.concert.location}"/></h3>
		<h3>Starts at: <g:textField name="startTime" value="${data.concert.startTime}"/></h3>
		<h3>Ends at (estimated): <g:textField name="endTime" value="${data.concert.endTime}"/></h3>
		<h3>Available tickets:
			<g:each in="${data.tickets}" var="ticket" status="i">
	            <br>	Type: ${ticket.ticketType.tType}, Price: ${ticket.ticketType.price}, Available: <g:textField name="ticketCount" value="${ticket.count}"/> </br>
	        </g:each>
	    </h3>
	    <form action="<g:createLink controller="concert" action="update" id="${data.concert.id}" />">
    		<input type="submit" value="EDIT" />
		</form>
	    <form action="<g:createLink controller="concert" action="delete" id="${data.concert.id}" />">
    		<input type="submit" value="DELETE" />
		</form>
		</sec:ifAllGranted>

			
	</body>
</html>
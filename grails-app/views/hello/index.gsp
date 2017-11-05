<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Tickets</title>
	</head>
	<body>
        <g:each in="${tickets}" var="ticket" status="i">
            <h3>${i+1}. ${ticket.ticketType.name}, ${ticket.ticketType.price}</h3>
            <p>
                Count: ${ticket.count}
            </p>
            <br/>
        </g:each>
	</body>
</html>
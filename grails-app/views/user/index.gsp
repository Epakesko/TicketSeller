<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Profile</title>
	</head>
	<body>
	<h3> Your tickets: </h3>
        <g:each in="${tickets}" var="ticket" status="i">
            <p>Concert: ${ticket.concert.performer} - Category: ${ticket.ticketType.tType} - Count: ${ticket.count}</p>
        </g:each>
	</body>
</html>
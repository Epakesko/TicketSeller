<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Ticket types</title>
	</head>
	<body>
        <g:each in="${tickettypes}" var="ticketType" status="i">
            <h3>Category: ${ticketType.tType} - Price: ${ticketType.price}</h3>
        </g:each>
	</body>
</html>
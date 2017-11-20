<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Ticket types</title>
		<style>
		.numberField{
			width:80px;
		}
		
		.concert-container {
		    position: relative;
		    width: 100%;
		    overflow: hidden; /*To get your parent to respect the floated divs*/
		}
		
		.concert-properties{
		    position: relative;
		    width: 66.6666%; /*Because you only have 3 elements (100 divided by 3)*/
		    float: left; /*To get them next to each other if all else fails*/
		    overflow: hidden; /*To get your parent to respect the floated divs*/
		}
		
		.concert-description{
		    position: relative;
		    width: 50%; /*Because you only have 3 elements (100 divided by 3)*/
		    float: left; /*To get them next to each other if all else fails*/
		}
		
		.concert-tickets{
		    position: relative;
		    width: 50%; /*Because you only have 3 elements (100 divided by 3)*/
		    float: left; /*To get them next to each other if all else fails*/
		}
		
		.concert-buy{
		    position: relative;
		    width: 33.3333%; /*Because you only have 3 elements (100 divided by 3)*/
		    float: left; /*To get them next to each other if all else fails*/
		}
		</style>
	</head>
	<body">
	
		<div class="concert-container">
			<div class="concert-properties">
				<form action="<g:createLink controller="concert" action="update" id="${data.concert.id}" />" method="post">
					<div class="concert-description">
						<sec:ifNotGranted roles='ROLE_ADMIN'>
					        <h2>${data.concert.performer}</h2>
							<p> <i class="fa grails-icon"> <asset:image src="location.png"/> ${data.concert.location} </i> </p>
							<p> From ${data.concert.startTime} to ${data.concert.endTime} </p>
						</sec:ifNotGranted>
						<sec:ifAllGranted roles='ROLE_ADMIN'>
					        <h2><g:textField name="performer" value="${data.concert.performer}"/></h2>
							<p> <i class="fa grails-icon"> <asset:image src="location.png"/> <g:textField name="location" value="${data.concert.location}"/> </i> </p>
							<p> From <g:textField name="startTime" value="${data.concert.startTime}"/> to <g:textField name="endTime" value="${data.concert.endTime}"/> </p>
						</sec:ifAllGranted>	
					</div>
					<div class="concert-tickets">
						<sec:ifNotGranted roles='ROLE_ADMIN'>
						<h3>Available tickets:</h3>
							<g:each in="${data.tickets}" var="ticket" status="i">
					            <p>Available: ${ticket.count}&emsp;${ticket.ticketType.tType}</br>
					        </g:each>
						</sec:ifNotGranted>
						<sec:ifAllGranted roles='ROLE_ADMIN'>
						<h3>Available tickets:</h3>
							<g:each in="${data.tickets}" var="ticket" status="i">
					            <p>Available: <g:field class="numberField" type="number" name="ticketCount${ticket.id}" value="${ticket.count}"/>&emsp;${ticket.ticketType.tType}</br>
					        </g:each>
					    <input type="submit" value="EDIT" />    
					    </br>  
					    <form action="<g:createLink controller="concert" action="delete" id="${data.concert.id}" />">
							<input type="submit" value="DELETE" />
							</br>
						</form>  
					    </sec:ifAllGranted>	
				   	</div>
				</form>

			</div>
			<div class="concert-buy">
				<sec:ifLoggedIn>
					<form action="<g:createLink controller="ticket" action="buy" id="${data.concert.id}"/>" method="post">
						<h3>Buy tickets:</h3>
							<g:each in="${data.tickets}" var="ticket" status="i">
					            <p><g:field type="number" class="numberField" name="buyCount${ticket.id}" value="0"/>&emsp;${ticket.ticketType.price} money/ticket</br>
					        </g:each>
				        </br>
			    		<input type="submit" value="BUY" />
					</form>
				</sec:ifLoggedIn>
			</div>
		</div>
	</body>
</html>
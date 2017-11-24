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
		
		td{
			vertical-align:middle;
		}
		.labeltext{
			text-align:center;
		}
		
		</style>
	</head>
	<body">
		
		<div class="concert-container">
			<div class="concert-properties">
				
				<form action="<g:createLink controller="concert" action="update" id="${data.concert.id}" />" method="post">
					<div class="concert-description">
						<sec:ifNotGranted roles='ROLE_ADMIN'>
							<table style="width:75%;">
					        <tr><th colspan="2" >
					        <h1><b>${data.concert.performer}</b></h1>
					        </th></tr><tr><td class="labeltext">
							<i class="fa grails-icon"> <asset:image src="location.png"/> </i></td><td>${data.concert.location} 
							</td></tr><tr><td class="labeltext">
							From</td><td>${data.concert.startTime}
							</td></tr><tr><td class="labeltext">
							To</td><td>${data.concert.endTime}
							</td></tr>
							</table>	
						</sec:ifNotGranted>
						<sec:ifAllGranted roles='ROLE_ADMIN'>
							<table style="width:75%;>
					        <tr><td colspan="2" >
					        <h2><g:textField name="performer" value="${data.concert.performer}"/></h2>
							</td></tr><tr><td class="labeltext">
							<i class="fa grails-icon"><asset:image src="location.png"/></i></td><td style="vertical-align:middle"><g:textField name="location" value="${data.concert.location}"/> 
							</td></tr><tr><td class="labeltext">
							From</td><td><g:field type="datetime-local" name="startTime" value="${data.startTimeFormatted}"/>
							</td></tr><tr><td class="labeltext">
							To</td><td><g:field type="datetime-local" name="endTime" value="${data.endTimeFormatted}"/>
							</td></tr>
							</table>	
						</sec:ifAllGranted>	
					</div>
					<div class="concert-tickets">
						<sec:ifNotGranted roles='ROLE_ADMIN'>
						<table style="width:75%;" >
					    <tr><th colspan="3" >
						<h3>Available tickets:</h3></th></tr>
							<g:each in="${data.tickets}" var="ticket" status="i">
					            <tr><td class="labeltext">Available:</td><td style="text-align:right;">${ticket.count}</td><td>${ticket.ticketType.tType}</td></tr>
					        </g:each>
						</table>	
						</sec:ifNotGranted>
						<sec:ifAllGranted roles='ROLE_ADMIN'>
						<table style="width:75%;">
						<tr><th colspan="3" >
						<h3>Available tickets:</h3></th></tr>
							<g:each in="${data.tickets}" var="ticket" status="i">
					            <tr><td class="labeltext">Available:</td><td style="text-align:right;"><g:field class="numberField" type="number" name="ticketCount${ticket.id}" value="${ticket.count}"/></td><td>${ticket.ticketType.tType}</td></tr>
					        </g:each>
					    <tr><td><input type="submit" value="EDIT" /></td></tr>
					    </table>	
					    </sec:ifAllGranted>	
				   	</div>
				</form>
				
				<table><tr><td>
				<sec:ifAllGranted roles='ROLE_ADMIN'>
			    <form action="<g:createLink controller="concert" action="delete" id="${data.concert.id}" />">
					<input type="submit" value="DELETE" />
					</br>
				</form>
				</sec:ifAllGranted>  
				</td>
				<td>
				<g:if test='${flash.message}'>
					<div class="registration_message">${flash.message}</div>
				</g:if>
				</td>
				</tr></table>
			</div>
			<div class="concert-buy">
				<sec:ifLoggedIn>
					<form action="<g:createLink controller="ticket" action="buy" id="${data.concert.id}"/>" method="post">
						<table style="width:75%;">
						<tr><th colspan="2" >
						<h3>Buy tickets:</h3></th></tr>
							<g:each in="${data.tickets}" var="ticket" status="i">
					            <tr><td class="labeltext"><g:field type="number" class="numberField" name="buyCount${ticket.id}" value="0"/></td><td>${ticket.ticketType.price} money/ticket</td></tr>
					        </g:each>
			    		<tr><td><input type="submit" value="BUY" /></td></tr>
					    </table>	
					</form>
				</sec:ifLoggedIn>
			</div>
		</div>
	</body>
</html>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/#">
                    <i class="fa grails-icon">
                        <asset:image src="ticketicon.png"/>
                    </i> TicketSeller
                </a>
            </div>
            <div class="navbar-header right">
	            <div class="navbar-header">
	            	<sec:ifNotLoggedIn>
	            		<a class="navbar-brand" href="<g:createLink controller="login"/>">
	            			Login
						</a>
					</sec:ifNotLoggedIn>
					<sec:ifLoggedIn>
						<a class="navbar-brand" href="<g:createLink controller="user"/>">
	            			<sec:username/>
						</a>
	                </sec:ifLoggedIn>
	            </div>
	           	<div class="navbar-header">
	                <sec:ifNotLoggedIn>
	                	<a class="navbar-brand" href="<g:createLink controller="user" action="register"/>">
	            			Register
						</a>
					</sec:ifNotLoggedIn>
	                <sec:ifLoggedIn>
	                	<a class="navbar-brand" href="<g:createLink controller="logout"/>">
	            			Logout
						</a>
	                </sec:ifLoggedIn>
	            </div>
	        </div>
        </div>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>


</body>
</html>
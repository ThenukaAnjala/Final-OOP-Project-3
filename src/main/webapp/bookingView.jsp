<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/basic_styles.css">
    <link rel="shortcut icon" type="image/png" href="images/logo_symbol.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbar-fixed/">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com"> 
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,600;0,800;1,100;1,200&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com"> 
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
    <link href="https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@300;400;700&display=swap" rel="stylesheet">
    <title>
        Destinare : Car Rentals
    </title>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="images/Logo_icon.ico">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

    <link href="./styles/navbar-top-fixed.css" rel="stylesheet">
    <link href="./styles/sticky-footer.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body style="overflow: hidden">

<div class="text-center">
        <label style="margin-bottom: -200px;" class="title-1">Booking Summary</label><br>
        <label class="title-2">Check your just made booking. Modify details as you want!</label>
</div><br>

<center>
<div class="form-container">
<table class="table-basic" style="width: 25%; border: 2px solid">
<c:forEach var = "cus" items = "${cusDetails}">
       <c:set var = "rBookingID" value = "${cus.rBookingID}"/>
       <c:set var = "tripType" value = "${cus.tripType}"/>
       <c:set var = "pickupDate" value = "${cus.pickupDate}"/>
       <c:set var = "returnDate" value = "${cus.returnDate}"/>
       <c:set var = "pickupPoint" value = "${cus.pickupPoint}"/>
       <c:set var = "returnPoint" value = "${cus.returnPoint}"/>

<tr>
    <td>BookingID</td>
    <td>${cus.rBookingID}</td>
</tr>       
  
<tr>
    <td>Trip Type</td>
    <td>${cus.tripType}</td>
</tr>
<tr>
    <td>Pickup Date</td>
    <td>${cus.pickupDate}</td>
</tr>
<tr>
    <td>Return Date</td>
    <td>${cus.returnDate}</td>
</tr>
<tr>
    <td>Pickup Point</td>
    <td>${cus.pickupPoint}</td>
</tr>
<tr>
    <td>Return Point</td>
    <td>${cus.returnPoint}</td>
</tr>

</c:forEach>
</table>

<c:url value = "updateBooking.jsp" var = "updateBooking">
    <c:param name = "rBookingID"  value = "${rBookingID}"/>
    <c:param name = "tripType"  value = "${tripType}"/>
    <c:param name = "pickupDate"  value = "${pickupDate}"/>
    <c:param name = "returnDate"  value = "${returnDate}"/>
    <c:param name = "pickupPoint"  value = "${pickupPoint}"/>
    <c:param name = "returnPoint"  value = "${returnPoint}"/>
    
</c:url>
			<br>
			<div>
				<a href="${updateBooking}">
					<input class="basic-btn" type="button" name="update" value="Update My Data">
				</a>

				<c:url value="cancelBooking.jsp" var="cancelBooking">
					<c:param name="rBookingID" value="${rBookingID}" />
					<c:param name="tripType" value="${tripType}" />
					<c:param name="pickupDate" value="${pickupDate}" />
					<c:param name="returnDate" value="${returnDate}" />
					<c:param name="pickupPoint" value="${pickupPoint}" />
					<c:param name="returnPoint" value="${returnPoint}" />
				</c:url>
				
				<c:url value="dummyBooking.jsp" var="payment">
					<c:param name="rBookingID" value="${rBookingID}" />
<%-- 					<c:param name="tripType" value="${tripType}" /> --%>
<%-- 					<c:param name="pickupDate" value="${pickupDate}" /> --%>
<%-- 					<c:param name="returnDate" value="${returnDate}" /> --%>
<%-- 					<c:param name="pickupPoint" value="${pickupPoint}" /> --%>
<%-- 					<c:param name="returnPoint" value="${returnPoint}" /> --%>
				</c:url>

				<a href="${cancelBooking}">
					<input class="basic-btn" type="button" name="delete" value="Cancel Booking">
				</a>
				
				<a href="${payment}">
<!-- 					<form action="#" method="post"> -->
<!-- 						<input type="hidden" name=""> -->
						<button class="basic-btn">Proceed to payment</button>
<!-- 					</form> -->
				</a>
			</div>
		</div>
</center>


</body>
</html>
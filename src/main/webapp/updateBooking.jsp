<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <label style="margin-bottom: -200px;" class="title-1">Update Booking</label><br>
        <label class="title-2">Modify your booking!</label>
</div><br>

 <%
    String rBookingID = request.getParameter("rBookingID");
    String tripType = request.getParameter("tripType");
    String pickupDate = request.getParameter("pickupDate");
    String returnDate = request.getParameter("returnDate");
    String pickupPoint = request.getParameter("pickupPoint");
    String returnPoint = request.getParameter("returnPoint");
 %>
<center>
<div class="form-container">
<form action = "update" method = "post">
Register customer BookingID:
<input type="text"  name="rBookingID" value = "<%= rBookingID %>" class="form-dropdown" style="margin: 15px" readonly>
<br>
Select a trip type:
<select name="tripType" class="form-dropdown" style="margin: 15px">
  <option id="sd" value="Self Drive">Self Drive</option>
  <option id="pp" value="Pickup">Pickup</option>
  <option value="wedding and VIP">wedding and VIP</option>
  <option id="ap" value="Airport Pickup">Airport Pickup</option>
  <option value = "Truck" >Truck</option>
</select>
<input type="text" id="tt" value = "<%= tripType %>" hidden readonly>
<br>
Pickup Date:
<input type="date"  name="pickupDate" value = "<%= pickupDate %>" class="form-dropdown" style="margin: 15px">
<br>
Return Date:
<input type="date"  name="returnDate" value = "<%= returnDate %>" class="form-dropdown" style="margin: 15px">
<br>
Pickup Point:
<input type = "text"  name = "pickupPoint" value = "<%= pickupPoint %>" class="form-dropdown" style="margin: 15px">
<br>
Return Point:
<input type = "text"  name = "returnPoint" value = "<%= returnPoint %>" class="form-dropdown" style="margin: 15px">
<br>
<input class="basic-btn" type = "submit" name = "submit" value = "Update My Data">
</form>
		</div>
</center>
<script>
	var type = document.getElementById("tt").value;
	
	switch (type) {
		case "Self Drive" : document.getElementById("sd").selected = "selected";
							break;
							
		case "Pickup" : document.getElementById("pp").selected = "selected";
							break;
		
		case "Airport Pickup" : document.getElementById("ap").selected = "selected";
							break;
	}
</script>
</body>
</html> 
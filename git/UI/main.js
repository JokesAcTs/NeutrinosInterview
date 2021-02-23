
    function validateUser(){
            var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
		
		$.ajax({
            url: "http://localhost:8080/validateUser",
            type: 'get',
            data: {username, password},
            dataType: 'json',
            success:function(response) {
				var designation = "";
				 if(response.loginStatus == true) {
					 designation = response.designation;
					 alert(response.loginMessage);
					 if(designation=="DA"){
						 document.location.href = "home.html";
					 } else if(designation=="FA") {
						 document.location.href = "home1.html";
					 } else if(designation=="S") {
						 
					 }
				 } else {
					 alert(response.loginMessage);
				}
            }
        });
    }
	
	function saveOrderDetails() {
		var delivery_address = document.getElementById("delivery_address").value;
		
		$.ajax({
            url: "http://localhost:8080/new_order",
            type: 'post',
            data: {delivery_address},
            dataType: 'json',
            success:function(response) {
				alert(response);
            }
        });
	}
	
	function getOrderDetails() {
		document.getElementById("orderDetails").innerHTML = "";
		$.ajax({
            url: "http://localhost:8080/getOrderDetails",
            type: 'get',
            dataType: 'json',
            success:function(response) {
				var tableHeader = "<table class=\"table\"><tr><th>Order ID</th><th>Delivery Address</th><th>Delivery Status</th><th>Delivered</th></tr>";
            	
				for(i=0; i < response.length; i++) {
					tableHeader = tableHeader + "  <tr><td>" + response[i].order_id + "</td><td> "+ response[i].delivery_address + "</td><td>" + response[i].delivery_status +"</td>";
					tableHeader = tableHeader + "<td>" +
        "<button type='button' onclick='updateOrder(this);' class='btn btn-default' text='Delivered'>Order Delivered!" +
        "</button></tr></td>";

				}
				
				tableHeader = tableHeader + "</table>";
				document.getElementById("orderDetails").innerHTML +=  tableHeader;
            }
        });
	}
	
		function updateOrder(data) {
		var order_id = $(data).parents("tr")[0].innerText.split("\t")[0];
		$.ajax({
            url: "http://localhost:8080/update_order",
            type: 'post',
            data: {order_id},
            dataType: 'json',
            success:function(response) {
				alert("Order successfully delivered");
				getOrderDetails();
            }
        });
		
	}
	

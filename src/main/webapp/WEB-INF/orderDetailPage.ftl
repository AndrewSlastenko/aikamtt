<html>
<head>
<meta charset="UTF-8">
<title>Order detail page</title>
</head>
<body>
	<h2> Order #${orderNumber} detail </h2>
	<table>
		<thead>
			<th>Item id</th>
			<th>Item name</th>
			<th>Price</th>
			<th>Count</th>
			<th>Total</th>
		</thead>
		<tbody id="orderPositionsTable">
		<#list orderPositions as position>
			<tr>
				<td>${position.itemId}</td>
				<td>${position.name}</td>
				<td>${position.price}</td>
				<td>${position.count}</td>
				<td>${position.total}</td>
			</tr>
		</#list>
		</tbody>
	</table><br>
	<h3>Total sum of order: ${orderSum}</h3><br>
</body>
</html>
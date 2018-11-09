<html>
<head>
<meta charset="UTF-8">
<title>Orders page</title>
</head>
<body>
	<h2> Orders table </h2>
	<table>
		<thead>
			<th>Order number</th>
			<th></th>
		</thead>
		<tbody id="ordersTable">
		<#list orders as order>
			<tr>
				<td>${order}</td>
				<td><a href="order/${order}">Detail</a></td>
			</tr>
		</#list>
		</tbody>
	</table><br>
</body>
</html>
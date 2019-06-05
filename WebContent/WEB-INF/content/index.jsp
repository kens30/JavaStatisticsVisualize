<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Java Statistics Sample</title>
		<link rel="stylesheet" href="/JavaStatisticsVisualize/css/index.css" />
		<link rel="stylesheet" href="/JavaStatisticsVisualize/css/canvas.css" />
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" />
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
	</head>
	<body>
		<h1>Java Statistics Sample</h1>
		<div id="main" class="container">
			<div>
				<div id="control-panel-area">
					<h2>basic statistics</h2>
					please input comma separated values.
					<div class="row flex-row">
						<input id="txt-basic-input" class="form-control" type="text" value="" />
					</div>
					<div id="basic-button-area" class="row flex-row">
						<input id="btn-max-value" class="btn btn-primary" type="button" value="max value" />
						<input id="btn-min-value" class="btn btn-primary" type="button" value="min value" />
						<input id="btn-sum-value" class="btn btn-primary" type="button" value="sum value" />
						<input id="btn-avg-value" class="btn btn-primary" type="button" value="average value" />
						<input id="btn-med-value" class="btn btn-primary" type="button" value="median value" />
						<input id="btn-dev-value" class="btn btn-primary" type="button" value="standard deviation" />
						<input id="btn-mod-value" class="btn btn-primary" type="button" value="mode" />
					</div>
				</div>
				<div id="graphics-area">
					<h2>detail statistics</h2>
				</div>
				<div id="graph-area">
					<canvas id="can-area1">
					</canvas>
				</div>
				<div id="console-area">
					Console:
					<div id="console-inner-area">
					testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.testtest.
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
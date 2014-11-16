/*---------------------------------------------------------------------------
 *	bargraph is controller of analysis income-outcome 
 * 	display format is bar chart 
 ----------------------------------------------------------------------------*/
moneyMovement.controller('bargraph',function($scope,statedata,$timeout){
	$scope.url = '';
	$scope.datauser = statedata.getData();
	$scope.monthlist = statedata.getListMonth();
	$scope.yearlist = statedata.getListYear();
	$scope.creategraph = function(){
		//statedata.clearData("analysisBarchart");
		$scope.calldata();
		if(statedata.getanalysisBarchart()){
			$scope.datagraph = statedata.getanalysisBarchart();
		}
		else{
			$timeout(function(){
				$scope.creategraph();
			},9000);
		}
		$scope.callFormatGraph();
	};
	$scope.calldata = function(){
		$scope.url='service/balanceanalysis?username='+$scope.datauser.data.username
		+'&sessionId='+$scope.datauser.data.sessionId
		+'&startsavedate='+$scope.format.datayear.year+'-'+$scope.format.datamonth.id+'-1'
		+'&stopsavedate='+$scope.format.datayear.year+'-'+$scope.format.datamonth.id+'-30';
		statedata.requireCompareData($scope.url);
	}
	$scope.callFormatGraph = function(){
		$scope.data = {
				labels: [$scope.datagraph.data.result[2].type,$scope.datagraph.data.result[1].type,$scope.datagraph.data.result[0].type],
				datasets: [
				           {
				        	   label: 'VALUE REFFERENCE',
				        	   fillColor: 'rgba(220,220,220,0.2)',
				        	   strokeColor: 'rgba(220,220,220,1)',
				        	   pointColor: 'rgba(220,220,220,1)',
				        	   pointStrokeColor: '#fff',
				        	   pointHighlightFill: '#fff', 
				        	   pointHighlightStroke: 'rgba(220,220,220,1)',
				        	   data: [$scope.datagraph.data.result[2].valueref,$scope.datagraph.data.result[1].valueref,$scope.datagraph.data.result[0].valueref]
				           },
				           {
				        	   label: 'VALUE USED',
				        	   fillColor: 'rgba(151,187,205,0.2)',
				        	   strokeColor: 'rgba(151,187,205,1)',
				        	   pointColor: 'rgba(151,187,205,1)',
				        	   pointStrokeColor: '#fff',
				        	   pointHighlightFill: '#fff',
				        	   pointHighlightStroke: 'rgba(151,187,205,1)',
				        	   data: [$scope.datagraph.data.result[2].valueuse,$scope.datagraph.data.result[1].valueuse,$scope.datagraph.data.result[0].valueuse]
				           }
				           ]
		};

		$scope.options =  {

				// Sets the chart to be responsive
				responsive: true,

				//Boolean - Whether to show lines for each scale point
				scaleShowLine : true,

				//Boolean - Whether we show the angle lines out of the radar
				angleShowLineOut : true,

				//Boolean - Whether to show labels on the scale
				scaleShowLabels : true,

				// Boolean - Whether the scale should begin at zero
				scaleBeginAtZero : true,

				//String - Colour of the angle line
				angleLineColor : 'rgba(0,0,0,.1)',

				//Number - Pixel width of the angle line
				angleLineWidth : 1,

				//String - Point label font declaration
				pointLabelFontFamily : '"Arial"',

				//String - Point label font weight
				pointLabelFontStyle : 'normal',

				//Number - Point label font size in pixels
				pointLabelFontSize : 10,

				//String - Point label font colour
				pointLabelFontColor : '#666',

				//Boolean - Whether to show a dot for each point
				pointDot : true,

				//Number - Radius of each point dot in pixels
				pointDotRadius : 3,

				//Number - Pixel width of point dot stroke
				pointDotStrokeWidth : 1,

				//Number - amount extra to add to the radius to cater for hit detection outside the drawn point
				pointHitDetectionRadius : 20,

				//Boolean - Whether to show a stroke for datasets
				datasetStroke : true,

				//Number - Pixel width of dataset stroke
				datasetStrokeWidth : 2,

				//Boolean - Whether to fill the dataset with a colour
				datasetFill : true,

				//String - A legend template
				legendTemplate : '<ul class="tc-chart-js-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].strokeColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul></div>'
		};
	};

});
/*---------------------------------------------------------------------------------------
 * 
 * doughnut is controller display proportion of income-outcome with doughnut chart
 * 
 * --------------------------------------------------------------------------------------*/
moneyMovement.controller('doughnut', function( $scope,statedata,$timeout ) {
	$scope.url = '';
	$scope.monthlist = statedata.getListMonth();
	$scope.yearlist = statedata.getListYear();
	//console.log($scope.format.datayear);
	$scope.datadoghnutgraph = {};
	$scope.datauser = statedata.getData();
	$scope.creategraph = function(){
		//console.log(startsavedate);
		//statedata.clearData();
		$scope.url='service/useanalysis?username='+$scope.datauser.data.username
		+'&sessionId='+$scope.datauser.data.sessionId
		+'&startsavedate='+$scope.format.datayear.year+'-'+$scope.format.datamonth.id+'-1'
		+'&stopsavedate='+$scope.format.datayear.year+'-'+$scope.format.datamonth.id+'-30';
		statedata.requireDoghnutData($scope.url);
		$scope.checkdata();
	};
	$scope.checkdata = function(){
		if(statedata.setFormatDoghnut()){
			$scope.datadoghnutgraph = statedata.setFormatDoghnut();
		}
		else
		{
			$timeout(function(){
				$scope.checkdata();
			},10000);
		}
		console.log($scope.datadoghnutgraph);
		$scope.callFormatdoghnutgraph();
	}
	// Chart.js Data
	$scope.callFormatdoghnutgraph = function(){
		$scope.data = $scope.datadoghnutgraph;

		// Chart.js Options
		$scope.options =  {

				// Sets the chart to be responsive
				responsive: true,

				//Boolean - Whether we should show a stroke on each segment
				segmentShowStroke : true,

				//String - The colour of each segment stroke
				segmentStrokeColor : '#fff',

				//Number - The width of each segment stroke
				segmentStrokeWidth : 2,

				//Number - The percentage of the chart that we cut out of the middle
				percentageInnerCutout : 50, // This is 0 for Pie charts

				//Number - Amount of animation steps
				animationSteps : 100,

				//String - Animation easing effect
				animationEasing : 'easeOutBounce',

				//Boolean - Whether we animate the rotation of the Doughnut
				animateRotate : true,

				//Boolean - Whether we animate scaling the Doughnut from the centre
				animateScale : false,

				//String - A legend template
				legendTemplate : '<ul class="tc-chart-js-legend inline"><% for (var i=0; i<segments.length; i++){%><li><span style="background-color:<%=segments[i].fillColor%>"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>'

		};
	};

});
/*------------------------------------------------------------------------------------
 * linaergraph is controller display daily spend user with line chart
 * 
 * 
 *------------------------------------------------------------------------------------*/
moneyMovement.controller('lineargraph',function($scope,statedata,$timeout){
	$scope.url = '';
	$scope.monthlist = statedata.getListMonth();
	$scope.yearlist = statedata.getListYear();


	$scope.creategraph = function(){
		$scope.labelarray= statedata.setarraylabel($scope.format.datamonth.id);
		//alert($scope.labelarray+statedata.setarraylabel());
		$scope.dataarray = statedata.setarraydata($scope.format.datamonth.id);
		$scope.datagraph = statedata.getLinearGraph();
		$scope.datauser = statedata.getData();
		if($scope.dataarray.length>1){
			$scope.templatechart($scope.dataarray,$scope.labelarray);
		}
		else{
			alert("Data is not enough");
		}
	};
	$scope.templatechart = function(dataarray,labelarray){
		$scope.data = {
				labels: labelarray ,
				datasets: [
				           {
				        	   //label: 'My First dataset',
				        	   fillColor: 'rgba(255,255,255,0.1)',
				        	   strokeColor: 'rgba(220,200,220,200)',
				        	   pointColor: 'rgba(200,220,200,210)',
				        	   pointStrokeColor: '#fff',
				        	   pointHighlightFill: '#fff', 
				        	   pointHighlightStroke: 'rgba(220,220,220,1)',
				        	   data: dataarray
				           }
				           ]
		};

		$scope.options =  {

				// Sets the chart to be responsive
				responsive: true,

				//Boolean - Whether to show lines for each scale point
				scaleShowLine : false,

				//Boolean - Whether we show the angle lines out of the radar
				angleShowLineOut : false,

				//Boolean - Whether to show labels on the scale
				scaleShowLabels : true,

				// Boolean - Whether the scale should begin at zero
				scaleBeginAtZero : false,

				//String - Colour of the angle line
				angleLineColor : '#F9BF3B',

				//Number - Pixel width of the angle line
				angleLineWidth : 5,

				//String - Point label font declaration
				pointLabelFontFamily : '"Arial"',

				//String - Point label font weight
				pointLabelFontStyle : 'normal',

				//Number - Point label font size in pixels
				pointLabelFontSize : 1,

				//String - Point label font colour
				pointLabelFontColor : '#666',

				//Boolean - Whether to show a dot for each point
				pointDot : true,

				//Number - Radius of each point dot in pixels
				pointDotRadius : 3,

				//Number - Pixel width of point dot stroke
				pointDotStrokeWidth : 1,

				//Number - amount extra to add to the radius to cater for hit detection outside the drawn point
				pointHitDetectionRadius : 1,

				//Boolean - Whether to show a stroke for datasets
				datasetStroke : true,

				//Number - Pixel width of dataset stroke
				datasetStrokeWidth : 1,

				//Boolean - Whether to fill the dataset with a colour
				datasetFill : true,

				//String - A legend template
				//legendTemplate : '<ul class="tc-chart-js-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].strokeColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul></div>'
		};
	};
});
/*----------------------------------------------------------------------------------------------
 * display comparison of income-outcome with bar chart
 * 
 * ---------------------------------------------------------------------------------------------*/
moneyMovement.controller('compareBargraph',function($scope,statedata,$filter,$timeout){
	$scope.url = '';
	$scope.datauser = statedata.getData();
	$scope.yearlist = statedata.getListYear();
	$scope.createCompareBargraph = function(){
		$scope.callBarDataGraph();
		if($scope.monthLabel = statedata.setFormatgraph()){
			console.log($scope.datagraph);
		}else{
			$timeout(function(){
				$scope.creategraph();
			},9000);
		}
		//$scope.setFormatData();
		$scope.callBarFormatGraph();
	};
	$scope.callBarDataGraph = function(){
		$scope.url='service/comparemyincomeoutlaywithanother?username='+$scope.datauser.data.username
		+'&sessionId='+$scope.datauser.data.sessionId
		+'&startsavedate='+$scope.format.datayear.year+'-'+'1-1';
		+'&stopsavedate='+$scope.format.datayear.year+'-'+'12-31';
		statedata.requireCompareBarData($scope.url);
	}
	$scope.callBarFormatGraph = function(){
		$scope.data = {
				labels: $scope.monthLabel.month,
				datasets: [
				           {
				        	   label: 'Other money',
				        	   fillColor: 'rgba(220,220,220,0.5)',
				        	   strokeColor: 'rgba(220,220,220,0.8)',
				        	   highlightFill: 'rgba(220,220,220,0.75)',
				        	   highlightStroke: 'rgba(220,220,220,1)',
				        	   data: $scope.monthLabel.valueref
				           },
				           {
				        	   label: 'your money',
				        	   fillColor: 'rgba(151,187,205,0.5)',
				        	   strokeColor: 'rgba(151,187,205,0.8)',
				        	   highlightFill: 'rgba(151,187,205,0.75)',
				        	   highlightStroke: 'rgba(151,187,205,1)',
				        	   data: $scope.monthLabel.valueuse
				           }
				           ]
		};

		// Chart.js Options
		$scope.options =  {

				// Sets the chart to be responsive
				responsive: true,

				//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
				scaleBeginAtZero : true,

				//Boolean - Whether grid lines are shown across the chart
				scaleShowGridLines : true,

				//String - Colour of the grid lines
				scaleGridLineColor : "rgba(0,0,0,.05)",

				//Number - Width of the grid lines
				scaleGridLineWidth : 1,

				//Boolean - If there is a stroke on each bar
				barShowStroke : true,

				//Number - Pixel width of the bar stroke
				barStrokeWidth : 2,

				//Number - Spacing between each of the X value sets
				barValueSpacing : 5,

				//Number - Spacing between data sets within X values
				barDatasetSpacing : 1,

				//String - A legend template
				legendTemplate : '<ul class="tc-chart-js-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].fillColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>'
		};
	};
});
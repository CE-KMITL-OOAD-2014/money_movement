checkuser.controller('radargraph',function($scope,datatest){
	$scope.url = '';

	//console.log($scope.datagraph);
	$scope.datauser = datatest.getData();
	$scope.creategraph = function(){
		$scope.url='service/comparemyincomeoutlaywithanother?username='+$scope.datauser.data.username
		+'&sessionId='+$scope.datauser.data.sessionId
		+'&startsavedate=null'
		+'&stopsavedate=null';
		datatest.requireCompareData($scope.url);
		$scope.datagraph = datatest.getCompareLineGraph();
		$scope.callFormatGraph(10);
	};
	$scope.callFormatGraph = function(i){
		$scope.data = {
				labels: [$scope.datagraph.data.result[i].datagroup[0].type,$scope.datagraph.data.result[i].datagroup[1].type,$scope.datagraph.data.result[i].datagroup[2].type],
				datasets: [
				           {
				        	   label: 'VALUE REFFERENCE',
				        	   fillColor: 'rgba(220,220,220,0.2)',
				        	   strokeColor: 'rgba(220,220,220,1)',
				        	   pointColor: 'rgba(220,220,220,1)',
				        	   pointStrokeColor: '#fff',
				        	   pointHighlightFill: '#fff', 
				        	   pointHighlightStroke: 'rgba(220,220,220,1)',
				        	   data: [$scope.datagraph.data.result[i].datagroup[0].valueref,$scope.datagraph.data.result[i].datagroup[1].valueref,$scope.datagraph.data.result[i].datagroup[2].valueref]
				           },
				           {
				        	   label: 'VALUE USED',
				        	   fillColor: 'rgba(151,187,205,0.2)',
				        	   strokeColor: 'rgba(151,187,205,1)',
				        	   pointColor: 'rgba(151,187,205,1)',
				        	   pointStrokeColor: '#fff',
				        	   pointHighlightFill: '#fff',
				        	   pointHighlightStroke: 'rgba(151,187,205,1)',
				        	   data: [$scope.datagraph.data.result[i].datagroup[0].valueuse,$scope.datagraph.data.result[i].datagroup[1].valueuse,$scope.datagraph.data.result[i].datagroup[2].valueuse]
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

checkuser.controller( 'doughnut', function( $scope,datatest ) {
	$scope.url = '';
	$scope.datadoghnutgraph = {};
	$scope.datauser = datatest.getData();
	$scope.creategraph = function(){
		$scope.url='service/useanalysis?username='+$scope.datauser.data.username
		+'&sessionId='+$scope.datauser.data.sessionId
		+'&startsavedate=null'
		+'&stopsavedate=null';
		datatest.requireDoghnutData($scope.url);
		$scope.datadoghnutgraph = datatest.getDoghnutGraph();
		console.log($scope.datadoghnutgraph);
		$scope.callFormatdoghnutgraph();
	};
	// Chart.js Data
	$scope.callFormatdoghnutgraph = function(){
		$scope.data = [
		               {
		            	   value: $scope.datadoghnutgraph.data.result[0].value,
		            	   color:'#114611',
		            	   highlight: '#111111',
		            	   label: $scope.datadoghnutgraph.data.result[0].type
		               },
		               {
		            	   value: $scope.datadoghnutgraph.data.result[1].value,
		            	   color: '#46BFBD',
		            	   highlight: '#5AD3D1',
		            	   label: $scope.datadoghnutgraph.data.result[1].type
		               },
		               {
		            	   value: $scope.datadoghnutgraph.data.result[2].value,
		            	   color: '#46BFBD',
		            	   highlight: '#5AD3D1',
		            	   label: $scope.datadoghnutgraph.data.result[3].type
		               },
		               {
		            	   value: $scope.datadoghnutgraph.data.result[4].value,
		            	   color: '#46BFBD',
		            	   highlight: '#5AD3D1',
		            	   label: $scope.datadoghnutgraph.data.result[4].type
		               },
		               {
		            	   value: $scope.datadoghnutgraph.data.result[5].value,
		            	   color: '#46BFBD',
		            	   highlight: '#5AD3D1',
		            	   label: $scope.datadoghnutgraph.data.result[5].type
		               },
		               {
		            	   value: $scope.datadoghnutgraph.data.result[6].value,
		            	   color: '#46BFBD',
		            	   highlight: '#5AD3D1',
		            	   label: $scope.datadoghnutgraph.data.result[6].type
		               },
		               {
		            	   value: $scope.datadoghnutgraph.data.result[7].value,
		            	   color: '#46BFBD',
		            	   highlight: '#5AD3D1',
		            	   label: $scope.datadoghnutgraph.data.result[7].type
		               }, 
		               {
		            	   value: $scope.datadoghnutgraph.data.result[8].value,
		            	   color: '#46BFBD',
		            	   highlight: '#5AD3D1',
		            	   label: $scope.datadoghnutgraph.data.result[8].type
		               },
		               {
		            	   value:$scope.datadoghnutgraph.data.result[9].value,
		            	   color: '#FDB45C',
		            	   highlight: '#FFC870',
		            	   label: $scope.datadoghnutgraph.data.result[9].type
		               }
		               ];

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
				legendTemplate : '<ul class="tc-chart-js-legend"><% for (var i=0; i<segments.length; i++){%><li><span style="background-color:<%=segments[i].fillColor%>"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>'

		};
	};

});

checkuser.controller('lineargraph',function($scope,datatest){
	$scope.url = '';
	$scope.labelarray= datatest.setarraylabel();
	//alert($scope.labelarray+datatest.setarraylabel());
	$scope.dataarray = datatest.setarraydata();
	$scope.datagraph = datatest.getLinearGraph();
	$scope.datauser = datatest.getData();
	$scope.creategraph = function(){
		$scope.url='service/balanceanalysis?username='+$scope.datauser.data.username
		+'&sessionId='+$scope.datauser.data.sessionId
		+'&startsavedate='+$scope.datadate.initdate
		+'&stopsavedate='+$scope.datadate.finaldate;
		datatest.requireLinearData($scope.url);
	};

	$scope.data = {
			labels: $scope.labelarray ,
			datasets: [
			           {
			        	   //label: 'My First dataset',
			        	   fillColor: 'rgba(255,255,255,0.1)',
			        	   strokeColor: 'rgba(220,200,220,200)',
			        	   pointColor: 'rgba(200,220,200,210)',
			        	   pointStrokeColor: '#fff',
			        	   pointHighlightFill: '#fff', 
			        	   pointHighlightStroke: 'rgba(220,220,220,1)',
			        	   data:$scope.dataarray
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
			angleLineColor : 'rgba(0,0,0,.1)',

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

});
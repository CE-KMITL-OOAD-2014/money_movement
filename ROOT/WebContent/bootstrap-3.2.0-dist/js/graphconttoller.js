checkuser.controller('chartgraph',function($scope){
	$scope.data = {
		      labels: ['Eating', 'Drinking', 'Sleeping', 'Designing', 'Coding', 'Cycling', 'Running'],
		      datasets: [
		        {
		          label: 'My First dataset',
		          fillColor: 'rgba(220,220,220,0.2)',
		          strokeColor: 'rgba(220,220,220,1)',
		          pointColor: 'rgba(220,220,220,1)',
		          pointStrokeColor: '#fff',
		          pointHighlightFill: '#fff',
		          pointHighlightStroke: 'rgba(220,220,220,1)',
		          data: [65, 59, 90, 81, 56, 55, 40]
		        },
		        {
		          label: 'My Second dataset',
		          fillColor: 'rgba(151,187,205,0.2)',
		          strokeColor: 'rgba(151,187,205,1)',
		          pointColor: 'rgba(151,187,205,1)',
		          pointStrokeColor: '#fff',
		          pointHighlightFill: '#fff',
		          pointHighlightStroke: 'rgba(151,187,205,1)',
		          data: [28, 48, 40, 19, 96, 27, 12]
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
		      scaleShowLabels : false,

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

});

checkuser.controller( 'doughnut', function( $scope ) {

    // Chart.js Data
    $scope.data = [
      {
        value: 300,
        color:'#F7464A',
        highlight: '#FF5A5E',
        label: 'Red'
      },
      {
        value: 50,
        color: '#46BFBD',
        highlight: '#5AD3D1',
        label: 'Green'
      },
      {
        value: 100,
        color: '#FDB45C',
        highlight: '#FFC870',
        label: 'Yellow'
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

  });
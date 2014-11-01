checkuser.directive('chartradar',function(){
	return{
		restrict:'E',
		//transclude: true,
		template: 		
						'<div ng-controller="chartgraph">'+
							'<canvas tc-chartjs-radar chart-options="options" chart-data="data" auto-legend></canvas>'+
						    '<canvas tc-chartjs-line chart-options="options" auto-legend chart-data="data" ></canvas>'+
						'</div>',
						
					
		//replace:true
	};
});
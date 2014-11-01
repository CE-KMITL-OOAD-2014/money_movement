checkuser.directive('chartradar',function(){
	return{
		restrict:'E',
		//transclude: true,
		template: 
						'<div ng-controller="chartgraph">'+
							'<canvas tc-chartjs-radar chart-options="options" chart-data="data" auto-legend></canvas>'+
						'</div>',
					
		//replace:true
	};
});
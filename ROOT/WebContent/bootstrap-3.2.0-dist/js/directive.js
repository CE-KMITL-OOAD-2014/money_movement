moneyMovement.directive('barchart',function(){
	return{
		restrict:'E',
		templateUrl: 'barchart.html' 		
	};
});
moneyMovement.directive('transaction',function(){
	return{
		restrict:'E',
		templateUrl: 'incomeoutlay.html' 		
	};
});
moneyMovement.directive('doughnutchart',function(){
	return{
		restrict:'E',
		templateUrl: 'chartdoughnut.html' 		
	};
});
moneyMovement.directive('linechart',function(){
	return{
		restrict:'E',
		templateUrl: 'linechart.html' 		
	};
});
moneyMovement.directive('comparechart',function(){
	return{
		restrict:'E',
		templateUrl: 'comparechart.html' 		
	};
});
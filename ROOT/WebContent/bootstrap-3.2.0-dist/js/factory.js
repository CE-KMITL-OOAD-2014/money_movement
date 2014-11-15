/*------------------------------------------------------------------------------------
 * 
 * 
 * 
 * -----------------------------------------------------------------------------------*/
checkuser.factory('datatest',['$http','$filter',function ($http,$filter) {
	/*-----------------------------------------------
	 * variable of function return
	 * 
	 * ----------------------------------------------*/
	var tempvalue = {
			value : []
	};
	var tempdata = {
			data : []
	};
	var temptotal = {
			total : []
	};
	var formatData = {
			format : []
	}
	var yearlist = [{'year':2010},{'year':2011},{'year':2012},{'year':2013},{'year':2014},{'year':2015},{'year':2016},{'year':2017},{'year':2018},{'year':2019}];
	var monthlist = [{'id':1,'month':'January'},{'id':2,'month': 'February'}, {'id':3,'month':'March'}, {'id':4,'month':'April'},{'id':5,'month': 'May'},{'id':6,'month': 'June'},
	                 {'id':7,'month':'July'},{'id':8,'month': 'August'}, {'id':9,'month':'September'}, {'id':10,'month':'October'}, {'id':11,'month':'November'}, {'id':12,'month':'December'}];
	var monthData = [{'id':1,'month':'Jan'}, {'id':2,'month':'Fab'},{'id':3,'month':'Mar'},{'id':4,'month':'Apr'},{'id':5,'month':'May'},{'id':6,'month':'Jun'},
	                 {'id':7,'month':'Jul'},{'id':8,'month':'Aug'},{'id':9,'month':'Sep'},{'id':10,'month':'Oct'},{'id':11,'month':'Nov'},{'id':12,'month':'Dec'}]
	var datagraph = {};
	var formatDoghnutchart = [];
	var total = {} ;
	var label = {};
	var dailygraph = {};
	var doghnutgraph = {};
	var compareBargraph = {};
	var compareLinegraph = {};
	var transaction = {};
	var service = {};
	/*--------------------------------------------------------------
	 * return value follow function this below
	 * 
	 * -------------------------------------------------------------*/
	return{
		getListMonth : function(){
			return monthlist;
		},
		getListYear :function(){
			return yearlist;
		},
		/*--------------------------------
		 * 
		 * -------------------------------*/
		getData : function(){
			service =  JSON.parse(localStorage.getItem("service"));
			return service;
		},
		setData : function(input){
			localStorage.setItem("service",JSON.stringify(input));
		},
		clearData : function(){
			localStorage.removeItem("doghnutgraph");
		},
		/*--------------------------------
		 * 
		 * -------------------------------*/
		gettransaction : function(){
			transaction =  JSON.parse(localStorage.getItem("transaction"));
			console.log(transaction);
			return transaction;
		},
		settransaction : function(input){
			localStorage.setItem("transaction",JSON.stringify(input));

		},
		cleartransaction : function(){
			localStorage.clear();
		},


		/*-----------------------------------------------------------
		 * ***********collection of graph**************
		 * 
		 * -----------------------------------------------------------*/ 
		getDoghnutGraph : function(){
			doghnutgraph = JSON.parse(localStorage.getItem("doghnutgraph"));
			return doghnutgraph;

		},

		requireDoghnutData : function(url){
			$http.post(url).success(function(data,status){
				if(data){
					localStorage.setItem("doghnutgraph",JSON.stringify(data));
				}
			}).error(function(data,status){

			})
		},

		////------------------------------------------------------------//////////
		getCompareBarGraph : function(){
			compareDataBargraph = JSON.parse(localStorage.getItem("compareDataBargraph"));
			return compareDataBargraph;
		},
		requireCompareBarData : function(url){
			$http.post(url).success(function(data,status){
				if(data){
					localStorage.setItem("compareDataBargraph",JSON.stringify(data));
					//console.log(compareDataBargraph);
				}
			}).error(function(data,status){

			})
		},

		//////---------------------------------------------------------------//////

		getCompareLineGraph : function(){
			compareLinegraph = JSON.parse(localStorage.getItem("compareLinegraph"));
			return compareLinegraph;
		},
		requireCompareData : function(url){
			$http.post(url).success(function(data,status){
				if(data){
					localStorage.setItem("compareLinegraph",JSON.stringify(data));
				}
			}).error(function(data,status){

			})
		},

		//////---------------------------------------------//////
		getLinearGraph : function(){
			linegraph = JSON.parse(localStorage.getItem("linegraph"));
			return linegraph;
		},
		requireLinaerData : function(url){
			$http.post(url).success(function(data,status){
				if(data){
					localStorage.setItem("Lineargraph",JSON.stringify(data));
				}
			}).error(function(data,status){

			})
		},

		///////----------------------------------------------------///
		setarraylabel : function(monthselect){
			tempvalue.value = [];
			var temp = $filter('orderBy')(transaction.data.incomeoutlay,'savedate');
			for(var i in temp){
				console.log(temp[i].savedate);
				var date = new Date(temp[i].savedate);
				console.log(date.getMonth()+' '+monthselect);
				if(date.getMonth()== (monthselect-1)){
					var item = temp[i].savedate;
					var date = new Date(item);
					var day = date.getDate();
					tempvalue.value.push(day)
				}

			}
			localStorage.setItem("label",JSON.stringify(tempvalue.value));
			label = JSON.parse(localStorage.getItem("label"));
			console.log(label);
			return label;

		},
		//-//---------------------------------------------------------////	  

		setFormatgraph : function(){

			tempvalue.value = [];
			temptotal.total = [];
			formatData.format = [];
			var refval = '';
			var useval = '';
			var month = '';
			var graph = this.getCompareBarGraph();
			for(var i in graph.data.result){
				//console.log(graph[i].month);
				for(var j in monthData){
					if(graph.data.result[i].month == monthData[j].id){

						month = monthData[j].month;
						refval = graph.data.result[i].valueref;
						useval = graph.data.result[i].valueuse;
						formatData.format.push(month);
						tempvalue.value.push(refval);
						temptotal.total.push(useval);
					}
				}
			}
			localStorage.setItem("datagraph",JSON.stringify({'month':formatData.format,'valueref':tempvalue.value,'valueuse':temptotal.total}));
			datagraph = JSON.parse(localStorage.getItem("datagraph"));
			return datagraph;
		},
		///---------------------------------------------------------------////
		setFormatDoghnut: function(){
			formatData.format = [];

			var doghnutColor = [{'color':'rgb(142,235,0)'},{'color':'rgb(92,153,0)'},{'color':'rgb(63,146,210)'},{'color':'rgb(54,187,206)'},{'color':'rgb(115,115,217)'},
			                    {'color':'rgb(255,53,0)'},{'color':'rgb(255,144,115)'},{'color':'rgb(255,146,0)'},{'color':'rgb(255,173,64)'},{'color':'rgb(255,238,0)'}]
			var value = '';
			var color = '';
			var highlight = '';
			var label = '';
			var doghnut = this.getDoghnutGraph();
			for(var i in doghnut.data.result){
				for(var j in doghnutColor){
					if(i==j){
						console.log(doghnut.data.result[i]);
						value = doghnut.data.result[i].value;
						color = doghnutColor[j].color;
						highlight = '#FF5A5E';
						label = doghnut.data.result[i].type;
						formatData.format.push({'value':value,'color':color,'highlight':highlight,'label':label});
					}
				}
			}
			localStorage.setItem("formatDoghnutchart",JSON.stringify(formatData.format));
			formatDoghnutchart = JSON.parse(localStorage.getItem("formatDoghnutchart"));
			return formatDoghnutchart;

		},

		///---------------------------------------------------------------////
		setarraydata : function(monthselect){
			tempdata.data = [];
			temptotal.total = [];
			var totalincomeoutcome = 0;
			var income = 0;
			var outcome = 0;
			var temp = $filter('orderBy')(transaction.data.incomeoutlay,'savedate');
			for(var i in temp){
				var date = new Date(temp[i].savedate);
				console.log(date.getMonth());
				if(date.getMonth()=== (monthselect-1)){
					var item = temp[i].amount;
					if(temp[i].typeofuse.type=="outcome"){
						outcome += item;
						item *= (-1);
						tempdata.data.push(item);
					}else{
						income += item;
						tempdata.data.push(item);
					} 
					totalincomeoutcome += item;
					console.log(item +' '+total);
				}
			}
			temptotal.total.push({
				'income': income,
				'outcome': outcome,
				'total': totalincomeoutcome
			});

			localStorage.setItem("total",JSON.stringify(temptotal.total));
			localStorage.setItem("data",JSON.stringify(tempdata.data));
			data = JSON.parse(localStorage.getItem("data"));
			console.log(item);
			return data;

		},
		////----------------------------------------------------------///
		getsumvalue : function(){
			total = JSON.parse(localStorage.getItem("total"));
			console.log(total);
			return total;
		}

	}
}]);

/**
 *  @author JetMuffin
 */

// 路径配置
require.config({
	paths : {
		echarts : '/robot/resources/plugin/echarts/dist'
	}
});

var id = $('#expertId').attr('data-id');
var url_percent = '/robot/expert/paperReferedPercent/'+id+'.json';
var url_dist = '/robot/expert/getPaperRefGrade/'+id+'.json';
var url_recent = '/robot/expert/getPaperRefTenYears/' + id + '.json';

require([ 'echarts', 'echarts/chart/pie', 'echarts/chart/bar','echarts/chart/line' ], function(ec) {
	
$.getJSON(url_percent,function(data){
		//论文引用百分比
			option_pie = {
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ '引用', '未引用' ]
				},
				color : [ '#6699FF', '#FFE5E5' ],
				calculable : true,
				series : [ {
					name : '论文引用量',
					type : 'pie',
					radius : [ '50%', '70%' ],
					itemStyle : {
						normal : {
							label : {
								show : false
							},
							labelLine : {
								show : false
							}
						},
						emphasis : {
							label : {
								show : true,
								position : 'center',
								textStyle : {
									fontSize : '15',
									fontWeight : 'bold'
								}
							}
						}
					},
					data : data
				} ]
			};
			var refer = ec.init(document.getElementById('paper-refer'));
			refer.setOption(option_pie);
});

$.getJSON(url_dist,function(data){
	//论文引用次数
	option_bar = {
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '引用量' ]
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : [ '0', '1~10', '11~50', '51~100', '>100' ]
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '引用量',
			type : 'bar',
			data : data,
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				}, {
					type : 'min',
					name : '最小值'
				} ]
			},
			itemStyle : {
				normal : {
					color : '#6699FF'
				}
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	};
	
	var referdist = ec.init(document.getElementById('paper-referdist'));
	referdist.setOption(option_bar);
});

$.getJSON(url_recent,function(data){
	//近10年论文发表
	option_recent = {
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '发表论文数']
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : [  '2006', '2007', '2008', '2009', '2010', '2011','2012','2013','2014','2015' ]
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value}'
			}
		} ],
		series : [ {
			name : '发表论文数',
			type : 'line',
			data : data,
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				}, {
					type : 'min',
					name : '最小值'
				} ]
			},
			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ]
			}
		} ]
	};

	var recent = ec.init(document.getElementById('lastTenyearPaper'));
	recent.setOption(option_recent);
});

	
});

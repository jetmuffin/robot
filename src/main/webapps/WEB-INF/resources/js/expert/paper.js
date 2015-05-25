/**
 *  @author JetMuffin
 */

// 路径配置
require.config({
	paths : {
		echarts : '/robot/resources/plugin/echarts/dist'
	}
});

//论文引用百分比
require([ 'echarts', 'echarts/chart/pie', 'echarts/chart/bar','echarts/chart/line' ], function(ec) {
	option_pie = {
		legend : {
			orient : 'vertical',
			x : 'left',
			data : [ '被引用', '未被引用' ]
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
			data : [ {
				value : 38,
				name : '引用'
			}, {
				value : 12,
				name : '未被引用'
			} ]
		} ]
	};

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
			data : [ 121, 310, 90, 6, 2 ],
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
			data : [ 67,56,50,49,45,30,17,0,0,0 ],
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

	var referdist = ec.init(document.getElementById('paper-referdist'));
	referdist.setOption(option_bar);
	var refer = ec.init(document.getElementById('paper-refer'));
	refer.setOption(option_pie);
	var recent = ec.init(document.getElementById('lastTenyearPaper'));
	recent.setOption(option_recent);
});

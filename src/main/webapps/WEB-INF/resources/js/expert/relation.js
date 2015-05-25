/**
 *  @author JetMuffin
 */

// 路径配置
require.config({
	paths : {
		echarts : '/robot/resources/plugin/echarts/dist'
	}
});

require([ 'echarts', 'echarts/chart/force', ], function(ec) {

	option = {
		title : {
			text : '人物关系：周志华',
			x : 'right',
			y : 'bottom'
		},
		tooltip : {
			trigger : 'item',
			formatter : '{a} : {b}'
		},
		toolbox : {
			show : true,
			feature : {
				restore : {
					show : true
				},
				magicType : {
					show : true,
					type : [ 'force', 'chord' ]
				},
				saveAsImage : {
					show : true
				}
			}
		},
		legend : {
			x : 'left',
			data : [ '同事', '合作伙伴' ]
		},
		series : [ {
			type : 'force',
			name : "人物关系",
			ribbonType : false,
			categories : [ {
				name: '专家'
			},{
				name : '同事'
			}, {
				name : '合作伙伴'
			}],
			itemStyle : {
				normal : {
					label : {
						show : true,
						textStyle : {
							color : '#333'
						}
					},
					nodeStyle : {
						brushType : 'both',
						borderColor : 'rgba(255,215,0,0.4)',
						borderWidth : 1
					},
					linkStyle : {
						type : 'curve'
					}
				},
				emphasis : {
					label : {
						show : false
					// textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
					},
					nodeStyle : {
					//r: 30
					},
					linkStyle : {}
				}
			},
			useWorker : false,
			minRadius : 15,
			maxRadius : 25,
			gravity : 1.1,
			scaling : 1.1,
			roam : 'move',
			nodes : [ {
				category : 0,
				name : '周志华',
				value : 10,
			}, {
				category : 1,
				name : '陈兆乾',
				value : 2
			}, {
				category : 1,
				name : '尹旭日',
				value : 3
			}, {
				category : 1,
				name : '陈世福',
				value : 3
			}, {
				category : 1,
				name : '史忠植',
				value : 7
			}, {
				category : 2,
				name : '李宁',
				value : 5
			}, {
				category : 2,
				name : '牟廉明',
				value : 8
			}, {
				category : 2,
				name : '高阳',
				value : 9
			}, {
				category : 2,
				name : '陆新泉',
				value : 4
			}, {
				category : 2,
				name : '陈虎',
				value : 4
			}, {
				category : 2,
				name : '陈可佳',
				value : 1
			}, ],
			links : [ {
				source : '陈世福',
				target : '周志华',
				weight : 1,
				name : '导师'
			}, {
				source : '陈兆乾',
				target : '周志华',
				weight : 2,
				name : '导师'
			}, {
				source : '牟廉明',
				target : '周志华',
				weight : 1,
			}, {
				source : '陆新泉',
				target : '周志华',
				weight : 2
			},  {
				source : '高阳',
				target : '周志华',
				weight : 1
			}, {
				source : '李宁',
				target : '周志华',
				weight : 6,
				name : '竞争对手'
			}, {
				source : '尹旭日',
				target : '周志华',
				weight : 1,
			}, {
				source : '史忠植',
				target : '周志华',
				weight : 1
			}, {
				source : '陈可佳',
				target : '周志华',
				weight : 1
			}, {
				source : '陈虎',
				target : '周志华',
				weight : 1
			} ]
		 } ]
	};
	
	var relation = ec.init(document.getElementById('expertRelation'));
	relation.setOption(option);
});
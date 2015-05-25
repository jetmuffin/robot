/**
 * 
 */

require.config({
	paths : {
		echarts : '/robot/resources/plugin/echarts/dist'
	}
});

require([ 'echarts', 'echarts/chart/force' ], function(ec, theme) {
	option_net = {
		tooltip : {
			trigger : 'item',
			formatter : '{a} : {b}'
		},
		legend : {
			x : 'left',
			data : [ '专家', '研究方向' ]
		},
		series : [ {
			type : 'force',
			name : "专家网络",
			ribbonType : false,
			categories : [ {
				name : '人物'
			}, {
				name : '家人'
			}, {
				name : '朋友'
			} ],
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
				category: 1,
				name : '机器学习',
				value :20,
			},{
				category : 0,
				name : '周志华',
				value : 10,
			}, {
				category : 0,
				name : '苏金树',
				value : 2
			}, {
				category : 0,
				name : '徐昕',
				value : 3
			}, {
				category : 0,
				name : '李德仁',
				value : 3
			}, {
				category : 0,
				name : '张为华',
				value : 7
			}, {
				category : 0,
				name : '孔汶汶',
				value : 5
			}, {
				category : 0,
				name : '程熙',
				value : 8
			}, {
				category : 0,
				name : '钱旭培',
				value : 9
			}, {
				category : 0,
				name : '何书萍',
				value : 4
			},{
				category : 0,
				name : '陈世福',
				value : 1
			}, ],
			links : [{
				source : '钱旭培',
				target : '何书萍',
				weight : 2,
				name : '合作'
			}, {
				source : '机器学习',
				target : '周志华',
				weight : 1,
			},  {
				source : '机器学习',
				target : '程熙',
				weight : 1,
			},{
				source : '机器学习',
				target : '钱旭培',
				weight : 2
			}, {
				source : '机器学习',
				target : '陈世福',
				weight : 3,
			}, {
				source : '机器学习',
				target : '徐昕',
				weight : 1
			}, {
				source : '机器学习',
				target : '李德仁',
				weight : 6,
			}, {
				source : '机器学习',
				target : '张为华',
				weight : 1,
				name : '爱将'
			}, {
				source : '机器学习',
				target : '孔汶汶',
				weight : 1
			}, {
				source : '机器学习',
				target : '苏金树',
				weight : 1
			}, {
				source : '李德仁',
				target : '程熙',
				weight : 1,
				name : '同事'
			}, {
				source : '孔汶汶',
				target : '钱旭培',
				weight : 1,
				name: '合作',
			}, {
				source : '陈世福',
				target : '周志华',
				weight : 1,
				name: '同事'
			}, {
				source : '机器学习',
				target : '何书萍',
				weight : 1
			} ]
		} ]
	};

	var network = ec.init(document.getElementById('expertNetwork'));
	network.setOption(option_net);

});
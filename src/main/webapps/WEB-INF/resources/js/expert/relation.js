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
	
	var id = $('#expertId').attr('data-id');
	var url = '/robot/expert/getExpertGraph/'+id+'.json'
	$.getJSON(url,function(data){
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
					nodes : data.nodes,
					links : data.links
				 } ]
			};
			
			var relation = ec.init(document.getElementById('expertRelation'));
			relation.setOption(option);
	});

});
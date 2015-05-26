/**
 * 
 */

// 路径配置
require.config({
	paths : {
		echarts : '/robot/resources/plugin/echarts/dist'
	}
});

require([ 'echarts', 'echarts/chart/force' ], function(ec, theme) {

	var nodes = [];
	var links = [];
	var constMaxDepth = 2;
	var constMaxChildren = 7;
	var constMinChildren = 4;
	var constMaxRadius = 10;
	var constMinRadius = 2;

	var id = $('#topicId').attr('data-id');
	var depth = 3;
	var url = '/robot/topic/getTopicGraph/'+id+'?depth=' + depth;
	
	$.getJSON(url,function(data){
		console.log(data.nodes);
		console.log(data.links);
		option = {
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
					data : [ '叶子节点', '非叶子节点', '根节点' ]
				},
				series : [ {
					type : 'force',
					name : "Force tree",
					ribbonType : false,
					categories : [ {
						name : '叶子节点'
					}, {
						name : '非叶子节点'
					}, {
						name : '根节点'
					} ],
					itemStyle : {
						normal : {
							label : {
								show : false
							},
							nodeStyle : {
								brushType : 'both',
								borderColor : 'rgba(255,215,0,0.6)',
								borderWidth : 1
							}
						}
					},
					minRadius : constMinRadius,
					maxRadius : constMaxRadius,
					coolDown : 0.995,
					steps : 10,
					nodes : data.nodes,
					links : data.links,
					steps : 1
				} ]
			};

			var knowledge = ec.init(document.getElementById('knowledgeNet'));
			knowledge.setOption(option);
	});
	
});
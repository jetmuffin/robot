/**
 *  @author JetMuffin
 */

// 路径配置
require.config({
	paths : {
		echarts : '/robot/resources/plugin/echarts/dist'
	}
});

require([ 'echarts', 'echarts/chart/pie', ], function(ec) {
	var id = $('#topicKeywords').attr('data-id');
	console.log(id);
	var url = 'http://localhost:8080/robot/expert/getPaperKey/' + id + '.json';
	$.getJSON(url, function(data) {
		console.log(data);
		option = {
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				x : 'center',
				y : 'bottom',
				data : [ '机器学习', '数据挖掘', ' 半监督学习', '多标记学习', '图像检索', '模式识别' ]
			},
			calculable : true,
			series : [ {
				type : 'pie',
				radius : [ 30, 110 ],
				roseType : 'radius',
				x : '100%', // for funnel
				max : 40, // for funnel
				sort : 'ascending', // for funnel
				data : data
			} ]
		};

		var relation = ec.init(document.getElementById('topicKeywords'));
		relation.setOption(option);
	});

});
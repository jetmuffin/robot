/**
 * @author JetMuffin
 */

// 路径配置
require.config({
	paths : {
		echarts : '/robot/resources/plugin/echarts/dist'
	}
});

// 论文引用百分比
require([ 'echarts', 'echarts/theme/macarons', 'echarts/chart/pie',
		'echarts/chart/bar', 'echarts/chart/line', 'echarts/chart/map' ],
		function(ec, theme) {
		
		var id = $('#topicId').attr('data-id');
		var url_org = '/robot/topic/getTopicExpertDataInfo/'+id+'.json';
		var url_gender ='/robot/topic/getExpertGender/' +id+ '.json';
		var url_prov = '/robot/topic/getExpertArea/' + id + '.json';
		
		$.getJSON(url_org,function(data){
			var data_org = [];
			var data_org_num = [];
			$.each(data,function(i,item){
				data_org.push(item.name);
				data_org_num.push(item.value);
			});
			option_bar = {
					title:{
						text:'本方向专家组织分布',
						x:'center'
					},
				tooltip : {
					trigger : 'axis'
				},

				color : [ '#6699FF' ],
				calculable : true,
				xAxis : [ {
					type : 'value',
					boundaryGap : [ 0, 0.01 ]
				} ],
				yAxis : [ {
					type : 'category',
					data : data_org
				} ],
				series : [ {
					sort : 'ascending',
					itemStyle : {
						normal : {
							barBorderRadius : 5
						},
						emphasis : {
							barBorderRadius : 5
						}
					},
					name : '专家数',
					type : 'bar',
					data : data_org_num
				} ]
			};

		
			var location = ec.init(document.getElementById('expertLocation'),
					theme);
			location.setOption(option_bar);
		});
		//end of orgnization
		
		
		$.getJSON(url_gender,function(data){
			option_pie = {
					legend : {
						orient : 'vertical',
						x : 'left',
						data : [ '男', '女' ]
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
						data :data
					} ]
				};
			
			var gender = ec.init(document.getElementById('expertGender'));
			gender.setOption(option_pie);
		});
		
		var dataStyle = {
				normal : {
					label : {
						show : false
					},
					labelLine : {
						show : false
					}
				}
			};
			var placeHolderStyle = {
				normal : {
					color : 'rgba(0,0,0,0)',
					label : {
						show : false
					},
					labelLine : {
						show : false
					}
				},
				emphasis : {
					color : 'rgba(0,0,0,0)'
				}
			};
			
			option_edu = {
				tooltip : {
					show : true,
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 0,
					y : 0,
					itemGap : 12,
					data : [ '博士及以上学历', '硕士学历', '本科学历' ]
				},
				series : [ {
					name : '1',
					type : 'pie',
					clockWise : false,
					radius : [ 60, 80 ],
					itemStyle : dataStyle,
					data : [ {
						value : 68,
						name : '博士及以上学历'
					}, {
						value : 32,
						name : 'invisible',
						itemStyle : placeHolderStyle
					} ]
				}, {
					name : '2',
					type : 'pie',
					clockWise : false,
					radius : [ 40, 60 ],
					itemStyle : dataStyle,
					data : [ {
						value : 29,
						name : '硕士学历'
					}, {
						value : 71,
						name : 'invisible',
						itemStyle : placeHolderStyle
					} ]
				}, {
					name : '3',
					type : 'pie',
					clockWise : false,
					radius : [ 20, 40 ],
					itemStyle : dataStyle,
					data : [ {
						value : 3,
						name : '本科学历'
					}, {
						value : 97,
						name : 'invisible',
						itemStyle : placeHolderStyle
					} ]
				} ]
			};

			$.getJSON(url_prov,function(data){
				option_prov = {
						tooltip : {
							trigger: 'item'
						},
						title:{
							text: '本方向专家分布',
							x: 'center'
						},
					series : [ {
						name : 'Map',
						type : 'map',
						hoverable: false,
						mapLocation : {
							x : 'left',
							y : 'top',
							height : 500
						},
						data : [

						],
						markPoint : {
							itemStyle : {
								normal : {
									color : 'skyblue'
								}
							},
							data : data
						},
						geoCoord: {
							 '上海省': [121.4648,31.2891],
							 '天津省': [117.4219,39.4189],
							'北京省': [116.395645,39.929986],
							'上海省': [121.487899,31.249162],
							'天津省': [117.210813,39.14393],
							'重庆省': [106.530635,29.544606],
							'香港省': [114.186124,22.293586],
							'澳门省': [113.557519,22.204118],
							'台湾省': [120.961454,23.80406],
							'安徽省': [117.282699,31.866942],
							'福建省': [119.330221,26.047125],
							'甘肃省': [103.823305,36.064226],
							'广东省': [113.30765,23.120049],
							'广西省': [108.297234,22.806493],
							'贵州省': [106.709177,26.629907],
							'海南省': [110.330802,20.022071],
							'河北省': [114.522082,38.048958],
							'河南省': [113.649644,34.75661],
							'黑龙江省': [126.657717,45.773225],
							'湖北省': [114.3162,30.581084],
							'湖南省': [112.979353,28.213478],
							'江苏省': [118.778074,32.057236],
							'江西省': [115.893528,28.689578],
							'吉林省': [125.313642,43.898338],
							'辽宁省': [123.432791,41.808645],
							'内蒙古省': [111.660351,40.828319],
							'宁夏省': [106.206479,38.502621],
							'青海省': [101.767921,36.640739],
							'山东省': [117.024967,36.682785],
							'山西省': [112.550864,37.890277],
							'陕西省': [108.953098,34.2778],
							'四川省': [104.067923,30.679943],
							'西藏省': [91.111891,29.662557],
							'新疆省': [87.564988,43.84038],
							'云南省': [102.714601,25.049153],
							'浙江省': [120.219375,30.259244]
							}
					} ]
				};				
				var province = ec
				.init(document.getElementById('expertProv'), theme);
		province.setOption(option_prov);
			});
	
			var edu = ec.init(document.getElementById('expertEdu'), theme);
			edu.setOption(option_edu);

		});
package com.dag.robot.neo.object;


import org.neo4j.graphdb.Node;
import org.springframework.beans.factory.annotation.Autowired;

import com.dag.robot.neo.type.*;

public class NeoCreateObject{
	
	@Autowired
	protected NeoObject neoObject;
	
	public NeoCreateObject(){
	}
	
	public NeoCreateObject(String db_path){
		neoObject = new NeoObject(db_path);
	}

	
	public NeoObject getNeoObject(){
		return neoObject;
	}

	public void setDB_PATH(String dB_PATH) {
		neoObject = new NeoObject();
		neoObject.setDB_PATH(dB_PATH);
		neoObject.begin();
	}
	
	public void begin(){
		neoObject.begin();
	}
	public void success(){
		neoObject.success();
	}
	public void finish(){
		neoObject.finish();
	}

	public Node findNode(LabelTypes label, String property, String value){
		return neoObject.findNode(label, property, value);
	}
	public Node findNode(LabelTypes label, String property, int value){
		return neoObject.findNode(label, property, value);
	}
	/**
	 * 输入十一元组，创建一个有向关系
	 * @param labela	起点Label
	 * @param ida		起点键值属性名称
	 * @param valueIda	起点键值属性值
	 * @param namea		起点名称参数
	 * @param valueNamea	起点名称值
	 * @param relTypes	关系类型
	 * @param labelb	终点Label
	 * @param idb		终点键值属性名称
	 * @param valueIdb	终点键值属性值
	 * @param nameb		终点名称参数
	 * @param valueNameb	终点名称值
	 */
	public void createLine(LabelTypes labela,String ida,int valueIda,String namea,String valueNamea
			,RelTypes relTypes
			,LabelTypes labelb,String idb,int valueIdb,String nameb,String valueNameb){
		

		System.out.println(valueNamea+"("+valueIda+")"+" -> "+valueNameb+"("+valueIdb+")");
		
		Node aNode = null;
		Node bNode = null;
		
		aNode = neoObject.findNode(labela, ida, valueIda);
		if(aNode == null){
			System.out.println("find anode "+valueNamea+" is null");
			aNode = neoObject.graphDb.createNode(labela);
			aNode.setProperty(ida, valueIda);
			aNode.setProperty(namea, valueNamea);
		}
		bNode = neoObject.findNode(labelb, idb, valueIdb);
		if(bNode == null){
			System.out.println("find bnode "+valueNameb+" is null");
			bNode = neoObject.graphDb.createNode(labelb);
			bNode.setProperty(idb, valueIdb);
			bNode.setProperty(nameb, valueNameb);
		}
		aNode.createRelationshipTo(bNode, relTypes);
	}
	
}
